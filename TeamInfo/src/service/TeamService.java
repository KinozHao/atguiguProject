package service;

import domain.human.Architect;
import domain.human.Designer;
import domain.human.Employee;
import domain.human.Programmer;

/**
 * @author kinoz
 * @date 2022/4/22 - 20:48
 * @apiNote �����Ŷӳ�Ա�Ĺ���[��ɾ�Ĳ�]
 */
public class TeamService {
    //���ڸ�TID��ֵ
    private static int counter = 1;
    //�����Ŷ���������
    private final int MAX_MEMBER = 5;
    //���ڱ����Ŷӳ�Ա
    private Programmer[] team = new Programmer[MAX_MEMBER];
    //��¼�Ŷ�ʵ������
    private int total = 0;

    //1:��ȡ�����Ŷ����г�Ա[֪ʶ��:�������]
    public Programmer[] getTeam(){
        /*Note: ����������
        ÿ�δ����������������MAX_MEMBER
        ����ͨ��total����¼���״����˶�����
        totalΪ�����켸��team����*/
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        //�����Ŷ�������
        return team;
    }

    //2:���ָ��Ա�����Ŷ���[֪ʶ��:�쳣����]
    public void addMember(Employee e) throws TeamException{
        //step 1:�ж��Ŷӳ�Ա����
        if (total >= MAX_MEMBER){
            throw new TeamException("��Ա�������޷����");
        }

        //step 2:�ж�Employee�ǲ���Programmer���͵�
        if (!(e instanceof Programmer)){
            throw new TeamException("�ó�Ա�ǿ�����Ա���޷����");
        }

        //step 3:�ж�Ҫ��ӵĳ����ǲ��������Ŷ���
        if(isExist(e)){
            throw new TeamException("��Ա�����ڱ��Ŷ���");
        }

        /*step 4:����step2���жϣ�
        ���ǿ��Ե�֪��employee�ض���һ��Programmer���͵�
        [�������ClassCastException]
        ͨ����Programmer��״̬���ж������ڱ���Ŷӣ��������ݼ�*/

        //ǿ������ת��������programmer��״̬����
        Programmer cxy = (Programmer)e;

        //д��һ:����nullPointerException����
        /*if (cxy.getStatus().getNAME().equals("BUSY")){
            throw new TeamException("�ó�Ա�Ѿ���ĳ�Ŷӳ�Ա");
        }else if (cxy.getStatus().getNAME().equals("VACATION")){
            throw new TeamException("�ó�Ա�����ݼ٣��޷����");
        }*/

        //д����:�������nullPointerException
        if ("BUSY".equals(cxy.getStatus().getNAME())){
            throw new TeamException("�ó�Ա�Ѿ���ĳ�Ŷӳ�Ա");
            //IgnoreCase���Դ�Сд
        }else if ("VACATION".equalsIgnoreCase(cxy.getStatus().getNAME())){
            throw new TeamException("�ó�Ա�����ݼ٣��޷����");
        }

        //step 5: [�Ŷ�������һ���ܹ�ʦ���������ʦ����������Ա]

        //5.1:��ȡteam�����мܹ�ʦ�����ʦ������Ա������
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
        //5.2���ݻ�ȡ�������������жϣ����׳���Ӧ�쳣
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

        //step6 ������ߵ��˲�˵�����϶�û�����⣬�Ϳ��԰�ָ��Ա����ӵ��Ŷ���
        //cxy��e��һ������[ֻ��������ʹ��ʱ������ǿת],��������ĸ�������
        team[total++] = cxy;
        //������������Լ��ڴ���������Ը�ֵ��ǰ�ں����岻��
        //cxy���Խ��и�ֵ
        cxy.setStatus(Status.BUSY);
        //����cxy�Ŷ��е�id
        cxy.setMemberId(counter++);
    }

    //3:ɾ���Ŷ���ָ����Ա��[֪ʶ��:Ԫ�ؽ���]
    public void removeMember(int TID) throws  TeamException{
        //accord this judge,decide:logic1 OR logic2
        int i =0;
        for (; i < total; i++) {
            if (team[i].getMemberId() == TID){
                //���ô�Ա��״̬ΪFREE
                team[i].setStatus(Status.FREE);
                //��ʱ��������ѭ��
                break;
            }
        }

        //logic1:û�ҵ�ID�����
        if (i == total){
            throw new TeamException("�Ҳ���ָ��TID��Ա��,ɾ��ʧ�ܣ�");
        }

        //logic2:�ҵ�ID�����(��һ��Ԫ�ظ���ǰһ��Ԫ��)
        for (int j = i; j < total; j++) {
            team[j] = team[j+1];
        }
        //���һ��Ԫ��Ҫ��null
        team[total-1] = null;
        total--;
        //д��2
        //team[--total] = null;
    }

    //2.1 Step3.1:�ж�Ҫ��ӵ�Ա���Ƿ��Ѿ������Ŷ���
    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            //�жϿ����Ŷ��г�ԱID��Ҫ��ӵ��Ƿ���ͬ(Ҳ����ʹ��memberID�ж�)
            //д��1
            /*if (team[i].getId() == e.getId()){
                return true;
            }*/
            //д��2 ���ص�һ����һ��boolean���͵�[��ʡ����]
            return team[i].getId() == e.getId();
        }
        return false;
    }
}
