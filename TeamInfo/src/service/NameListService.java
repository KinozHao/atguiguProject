package service;

import domain.equipment.Equipment;
import domain.equipment.NoteBook;
import domain.equipment.PC;
import domain.equipment.Printer;
import domain.human.Architect;
import domain.human.Designer;
import domain.human.Employee;
import domain.human.Programmer;
//导入Data类的所有结构体
import static service.Data.*;

/**
 * @author kinoz
 * @date 2022/4/22 - 20:48
 * @apiNote 负责把Data中的数据封装到Employee[]数组中
 * 并提供Employee[]相关的方法
 */
public class NameListService {
    //声明employees数组
    private Employee[] employees;

    //此构造器用于给employees数组元素进行初始化
    public NameListService() {
        //根据项目提供的Data类 new相应大小的employees数组
        employees = new Employee[EMPLOYEES.length];

        //数组遍历
        for (int i = 0; i < employees.length; i++) {
            /*获取Data中的EMPLOYESS这个二位数组的全部元素
            * 存入type变量中(因为EMPLOYEES中的元素为String类型,所以要进行强转)*/
            int type = Integer.parseInt(EMPLOYEES[i][0]);

            /*每个参数代表其在EMPLOYEES对应索引的值
            * 通过switch case语句new相应的对象传入所需参数*/

            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            double bonus;
            int stock;

            /* 此对象用于获取设备，在此处只声明不处理
             * 在具体某个类存在设别时候，在对应的位置去赋值*/
            Equipment equipment;

            //通过type获取的值、判断值对应的全局常量、最后确定new什么类型的对象
            switch (type){
                //数字可读性太差，使用常量表示更直观
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
    //获取指定index上员工的设备
    private Equipment creatEquipment(int index){

        //获取Data中的EQUPMENTS这个二位数组的全部元素
        int type = Integer.parseInt(EQUIPMENTS[index][0]);

        /*每个参数代表其在EQUIPMENTS中对应索引的值
         * 通过switch case语句new相应的对象传入所需参数*/
        String model = EQUIPMENTS[index][1];
        String display = EQUIPMENTS[index][2];
        String name = EQUIPMENTS[index][1];
        String printerType = EQUIPMENTS[index][2];
        double price;

        //通过type获取的值、判断值对应的全局常量、最后确定new什么类型的对象
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
    //获取所有员工
    public Employee[] getAllEmployees(){
        return employees;
    }
    //获取指定id的员工
    public Employee getEmployee(int id) throws TeamException{
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id){
                //如果找到的话直接return就行
                return employees[i];
            }
        }
        //如果没有找到、抛出我们自定义的异常
        throw new TeamException("找不到指定的员工");
    }


}
