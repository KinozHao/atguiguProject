package view;

import domain.human.Employee;
import domain.human.Programmer;
import service.NameListService;
import service.TeamException;
import service.TeamService;

/**
 * @author kinoz
 * @date 2022/4/22 - 20:48
 * @apiNote 与用户控制台的交互
 */
public class TeamView {
    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();

    }

    //员工列表
    private NameListService listSvc = new NameListService();
    //团队列表
    private TeamService teamSvc = new TeamService();

    public void enterMainMenu(){
        boolean isFlag = true;
        char menu = 0;

        while (isFlag){
            //输入1时不显示团队列表
            if (menu != '1'){
                listAllEmployees();
            }

            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出  请选择(1-4)：");
            menu = TSUtility.readMenuSelection();
            switch (menu){
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.print("是否确认退出(Y/N):");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y'){
                        isFlag = false;
                    }
                    break;

            }
        }

    }
    //查看公司所有员工信息
    public void listAllEmployees(){
        System.out.println("----------------------------开发团队调度软件----------------------------\n");
        Employee[] employees = listSvc.getAllEmployees();
        //开发中保险起见判断一下是否为null,因为有时候这个数组可能是个空的
        if (employees == null || employees.length == 0){
            System.out.println("公司中没有任何员工");
        }else {
            System.out.println("ID\t姓名\t\t年龄\t工资\t\t职位\t\t状态\t\t奖金\t\t股票\t\t领用设备");
            for (int i = 0; i < employees.length; i++) {
                System.out.println(employees[i]);
            }
        }
        System.out.println("----------------------------------------------------------------------");

    }
    //查看开发团队情况
    public void getTeam(){
        System.out.println("-----------------------------团队成员列表------------------------------");

        Programmer[] team = teamSvc.getTeam();
        //此判断的意义与listAllEmployees意义相同
        if (team == null || team.length == 0){
            System.out.println("开发团队中没有成员");
        }else {
            System.out.println("TID/ID\t姓名\t\t年龄\t工资\t\t职位\t\t奖金\t\t股票");
            for (int i = 0; i < team.length; i++) {
                System.out.println(team[i].getDetailsForTeamView());
            }
        }

        System.out.println("----------------------------------------------------------------------");
    }

     //添加成员
    public void addMember(){
        System.out.println("-----------------------------添加成员----------------------------------");
        System.out.print("请输入要添加成员的ID:");
        int addId = TSUtility.readInt();
        try {
            Employee employee = listSvc.getEmployee(addId);
            teamSvc.addMember(employee);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println("添加失败,原因："+e.getMessage());
        }
        System.out.println("----------------------------------------------------------------------");
        //按回车继续语句
        TSUtility.readReturn();

    }

    //删除成员
    public void deleteMember(){
        System.out.println("-----------------------------删除成员----------------------------------");
        System.out.print("请输入要删除成员的TID:");
        int delID= TSUtility.readInt();
        System.out.print("是否确认删除(Y/N):");
        char conformDel = TSUtility.readConfirmSelection();
        if (conformDel == 'N') {
            return;
        }

        try {
            teamSvc.removeMember(delID);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println("删除失败,原因："+e.getMessage());
        }
        //按回车继续语句
        TSUtility.readReturn();
    }
}
