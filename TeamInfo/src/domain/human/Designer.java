package domain.human;

import domain.equipment.Equipment;
import service.Status;

/**
 * @author kinoz
 * @date 2022/4/22 - 20:50
 * @apiNote ���ʦ��
 */
public class Designer extends Programmer{
    //����
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
        //equipment������programmer����˽�еģ������ȡ����Ҫʹ��get����
        //statusͬ��
        return getDetails()+"\t���ʦ\t"+getStatus()+"\t"+bonus+"\t\t\t"+getEquipment().getDescription();
    }

    //����TeamView����getTeam���������߼��ĵ���
    public String getDetailsForTeamView(){
        return getMemberId() + "/" +getId()+"\t\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t���ʦ\t"+getBonus();
    }
}
