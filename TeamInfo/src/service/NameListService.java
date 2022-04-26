package service;

import domain.equipment.Equipment;
import domain.equipment.NoteBook;
import domain.equipment.PC;
import domain.equipment.Printer;
import domain.human.Architect;
import domain.human.Designer;
import domain.human.Employee;
import domain.human.Programmer;
//����Data������нṹ��
import static service.Data.*;

/**
 * @author kinoz
 * @date 2022/4/22 - 20:48
 * @apiNote �����Data�е����ݷ�װ��Employee[]������
 * ���ṩEmployee[]��صķ���
 */
public class NameListService {
    //����employees����
    private Employee[] employees;

    //�˹��������ڸ�employees����Ԫ�ؽ��г�ʼ��
    public NameListService() {
        //������Ŀ�ṩ��Data�� new��Ӧ��С��employees����
        employees = new Employee[EMPLOYEES.length];

        //�������
        for (int i = 0; i < employees.length; i++) {
            /*��ȡData�е�EMPLOYESS�����λ�����ȫ��Ԫ��
            * ����type������(��ΪEMPLOYEES�е�Ԫ��ΪString����,����Ҫ����ǿת)*/
            int type = Integer.parseInt(EMPLOYEES[i][0]);

            /*ÿ��������������EMPLOYEES��Ӧ������ֵ
            * ͨ��switch case���new��Ӧ�Ķ������������*/

            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            double bonus;
            int stock;

            /* �˶������ڻ�ȡ�豸���ڴ˴�ֻ����������
             * �ھ���ĳ����������ʱ���ڶ�Ӧ��λ��ȥ��ֵ*/
            Equipment equipment;

            //ͨ��type��ȡ��ֵ���ж�ֵ��Ӧ��ȫ�ֳ��������ȷ��newʲô���͵Ķ���
            switch (type){
                //���ֿɶ���̫�ʹ�ó�����ʾ��ֱ��
                case EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case PROGRAMMER:
                    equipment = creatEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                    break;
                case DESIGNER:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bonus);
                    break;
                case ARCHITECT:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
            }
        }
    }
    //��ȡָ��index��Ա�����豸
    private Equipment creatEquipment(int index){

        //��ȡData�е�EQUPMENTS�����λ�����ȫ��Ԫ��
        int type = Integer.parseInt(EQUIPMENTS[index][0]);

        /*ÿ��������������EQUIPMENTS�ж�Ӧ������ֵ
         * ͨ��switch case���new��Ӧ�Ķ������������*/
        String model = EQUIPMENTS[index][1];
        String display = EQUIPMENTS[index][2];
        String name = EQUIPMENTS[index][1];
        String printerType = EQUIPMENTS[index][2];
        double price;

        //ͨ��type��ȡ��ֵ���ж�ֵ��Ӧ��ȫ�ֳ��������ȷ��newʲô���͵Ķ���
        switch (type){
            case PC:
                return new PC(model,display);

            case NOTEBOOK:
                price = Double.parseDouble(EQUIPMENTS[index][2]);
                return new NoteBook(model,price);

            case PRINTER:
                return new Printer(name,printerType);
        }
        return  null;
    }
    //��ȡ����Ա��
    public Employee[] getAllEmployees(){
        return employees;
    }
    //��ȡָ��id��Ա��
    public Employee getEmployee(int id) throws TeamException{
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id){
                //����ҵ��Ļ�ֱ��return����
                return employees[i];
            }
        }
        //���û���ҵ����׳������Զ�����쳣
        throw new TeamException("�Ҳ���ָ����Ա��");
    }


}
