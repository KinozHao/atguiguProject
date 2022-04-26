package service;

import domain.human.Architect;
import domain.human.Designer;
import domain.human.Employee;
import domain.human.Programmer;

/**
 * @author kinoz
 * @date 2022/4/22 - 20:48
 * @apiNote 开发团队成员的管理[增删改查]
 */
public class TeamService {
    //用于给TID赋值
    private static int counter = 1;
    //开发团队至多人数
    private final int MAX_MEMBER = 5;
    //用于保存团队成员
    private Programmer[] team = new Programmer[MAX_MEMBER];
    //记录团队实际人数
    private int total = 0;

    //1:获取开发团队所有成员[知识点:数组遍历]
    public Programmer[] getTeam(){
        /*Note: 此数组意义
        每次传入的人数并不都是MAX_MEMBER
        而是通过total来记录到底传入了多少人
        total为几就造几个team对象*/
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        //返回团队中人数
        return team;
    }

    //2:添加指定员工到团队中[知识点:异常处理]
    public void addMember(Employee e) throws TeamException{
        //step 1:判断团队成员数量
        if (total >= MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }

        //step 2:判断Employee是不是Programmer类型的
        if (!(e instanceof Programmer)){
            throw new TeamException("该成员非开发人员，无法添加");
        }

        //step 3:判断要添加的成语是不是已在团队中
        if(isExist(e)){
            throw new TeamException("该员工已在本团队中");
        }

        /*step 4:根据step2的判断，
        我们可以得知此employee必定是一个Programmer类型的
        [不会出现ClassCastException]
        通过此Programmer的状态来判断他是在别的团队，还是在休假*/

        //强制类型转换，调用programmer的状态变量
        Programmer cxy = (Programmer)e;

        //写法一:存在nullPointerException风险
        /*if (cxy.getStatus().getNAME().equals("BUSY")){
            throw new TeamException("该成员已经是某团队成员");
        }else if (cxy.getStatus().getNAME().equals("VACATION")){
            throw new TeamException("该成员正在休假，无法添加");
        }*/

        //写法二:避免出现nullPointerException
        if ("BUSY".equals(cxy.getStatus().getNAME())){
            throw new TeamException("该成员已经是某团队成员");
            //IgnoreCase忽略大小写
        }else if ("VACATION".equalsIgnoreCase(cxy.getStatus().getNAME())){
            throw new TeamException("该成员正在休假，无法添加");
        }

        //step 5: [团队至多有一个架构师、两个设计师、三个程序员]

        //5.1:获取team中已有架构师、设计师、程序员的人数
        int numOfArch = 0,numOfDes = 0,numOfPro=0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect){
                numOfArch++;
            }else if (team[i] instanceof Designer){
                numOfDes++;
            //}else if (team[i] instanceof Programmer){
            }else {
                numOfPro++;
            }
        }
        //5.2根据获取到的人数进行判断，并抛出相应异常
        if (cxy instanceof Architect){
            if (numOfArch >=1){
                throw new TeamException("TEAM_MAX_ARCHITECT:1");
            }
        }else if (cxy instanceof Designer) {
            if (numOfDes >= 2) {
                throw new TeamException("TEAM_MAX_DESIGNER:2");
            }
        //}else if(cxy instanceof Programmer){
        }else {
            if (numOfPro >=3){
                throw new TeamException("TEAM_MAX_PROGRAMMER:3");
            }
        }

        //step6 如果能走到此步说明以上都没有问题，就可以把指定员工添加到团队中
        //cxy和e是一个对象[只是在上面使用时进行了强转],最周添加哪个都可以
        team[total++] = cxy;
        //根据面向对象以及内存解析，属性赋值在前在后意义不大
        //cxy属性进行赋值
        cxy.setStatus(Status.BUSY);
        //设置cxy团队中的id
        cxy.setMemberId(counter++);
    }

    //3:删除团队中指定的员工[知识点:元素交换]
    public void removeMember(int TID) throws  TeamException{
        //accord this judge,decide:logic1 OR logic2
        int i =0;
        for (; i < total; i++) {
            if (team[i].getMemberId() == TID){
                //设置此员工状态为FREE
                team[i].setStatus(Status.FREE);
                //此时即可跳出循环
                break;
            }
        }

        //logic1:没找到ID的情况
        if (i == total){
            throw new TeamException("找不到指定TID的员工,删除失败！");
        }

        //logic2:找到ID的情况(后一个元素覆盖前一个元素)
        for (int j = i; j < total; j++) {
            team[j] = team[j+1];
        }
        //最后一个元素要置null
        team[total-1] = null;
        total--;
        //写法2
        //team[--total] = null;
    }

    //2.1 Step3.1:判断要添加的员工是否已经存在团队中
    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            //判断开发团队中成员ID和要添加的是否相同(也可以使用memberID判断)
            //写法1
            /*if (team[i].getId() == e.getId()){
                return true;
            }*/
            //写法2 返回的一定是一个boolean类型的[节省代码]
            return team[i].getId() == e.getId();
        }
        return false;
    }
}
