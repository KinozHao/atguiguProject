package view;

import domain.human.Employee;
import domain.human.Programmer;
import service.NameListService;
import service.TeamException;
import service.TeamService;

/**
 * @author kinoz
 * @date 2022/4/22 - 20:48
 * @apiNote ���û�����̨�Ľ���
 */
public class TeamView {
    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();

    }

    //Ա���б�
    private NameListService listSvc = new NameListService();
    //�Ŷ��б�
    private TeamService teamSvc = new TeamService();

    public void enterMainMenu(){
        boolean isFlag = true;
        char menu = 0;

        while (isFlag){
            //����1ʱ����ʾ�Ŷ��б�
            if (menu != '1'){
                listAllEmployees();
            }

            System.out.print("1-�Ŷ��б�  2-����Ŷӳ�Ա  3-ɾ���Ŷӳ�Ա 4-�˳�  ��ѡ��(1-4)��");
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
                    System.out.print("�Ƿ�ȷ���˳�(Y/N):");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y'){
                        isFlag = false;
                    }
                    break;

            }
        }

    }
    //�鿴��˾����Ա����Ϣ
    public void listAllEmployees(){
        System.out.println("----------------------------�����Ŷӵ������----------------------------\n");
        Employee[] employees = listSvc.getAllEmployees();
        //�����б�������ж�һ���Ƿ�Ϊnull,��Ϊ��ʱ�������������Ǹ��յ�
        if (employees == null || employees.length == 0){
            System.out.println("��˾��û���κ�Ա��");
        }else {
            System.out.println("ID\t����\t\t����\t����\t\tְλ\t\t״̬\t\t����\t\t��Ʊ\t\t�����豸");
            for (int i = 0; i < employees.length; i++) {
                System.out.println(employees[i]);
            }
        }
        System.out.println("----------------------------------------------------------------------");

    }
    //�鿴�����Ŷ����
    public void getTeam(){
        System.out.println("-----------------------------�Ŷӳ�Ա�б�------------------------------");

        Programmer[] team = teamSvc.getTeam();
        //���жϵ�������listAllEmployees������ͬ
        if (team == null || team.length == 0){
            System.out.println("�����Ŷ���û�г�Ա");
        }else {
            System.out.println("TID/ID\t����\t\t����\t����\t\tְλ\t\t����\t\t��Ʊ");
            for (int i = 0; i < team.length; i++) {
                System.out.println(team[i].getDetailsForTeamView());
            }
        }

        System.out.println("----------------------------------------------------------------------");
    }

     //��ӳ�Ա
    public void addMember(){
        System.out.println("-----------------------------��ӳ�Ա----------------------------------");
        System.out.print("������Ҫ��ӳ�Ա��ID:");
        int addId = TSUtility.readInt();
        try {
            Employee employee = listSvc.getEmployee(addId);
            teamSvc.addMember(employee);
            System.out.println("��ӳɹ�");
        } catch (TeamException e) {
            System.out.println("���ʧ��,ԭ��"+e.getMessage());
        }
        System.out.println("----------------------------------------------------------------------");
        //���س��������
        TSUtility.readReturn();

    }

    //ɾ����Ա
    public void deleteMember(){
        System.out.println("-----------------------------ɾ����Ա----------------------------------");
        System.out.print("������Ҫɾ����Ա��TID:");
        int delID= TSUtility.readInt();
        System.out.print("�Ƿ�ȷ��ɾ��(Y/N):");
        char conformDel = TSUtility.readConfirmSelection();
        if (conformDel == 'N') {
            return;
        }

        try {
            teamSvc.removeMember(delID);
            System.out.println("ɾ���ɹ�");
        } catch (TeamException e) {
            System.out.println("ɾ��ʧ��,ԭ��"+e.getMessage());
        }
        //���س��������
        TSUtility.readReturn();
    }
}
