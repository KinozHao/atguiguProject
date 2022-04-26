package domain.human;

import domain.equipment.Equipment;
import service.Status;

/**
 * @author kinoz
 * @date 2022/4/22 - 20:50
 * @apiNote 设计师类
 */
public class Designer extends Programmer{
    //奖金
    private double bonus;

    public  Designer(){
        super();
    }

    public Designer(int id, String name, int age, double salary,Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }


    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        //equipment定义在programmer中是私有的，子类获取就需要使用get方法
        //status同理
        return getDetails()+"\t设计师\t"+getStatus()+"\t"+bonus+"\t\t\t"+getEquipment().getDescription();
    }

    //用于TeamView类中getTeam方法的中逻辑的调用
    public String getDetailsForTeamView(){
        return getMemberId() + "/" +getId()+"\t\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t设计师\t"+getBonus();
    }
}
