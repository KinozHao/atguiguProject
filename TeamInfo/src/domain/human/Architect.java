package domain.human;

import domain.equipment.Equipment;
import service.Status;

/**
 * @author kinoz
 * @date 2022/4/22 - 20:50
 * @apiNote
 */
public class Architect extends Designer{
    private int stock; //股票

    public Architect() {
        super();
    }

    public Architect(int id, String name, int age, double salary,Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary,equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails()+"\t架构师\t"+getStatus()+"\t"+getBonus()+"\t"+stock+"\t"+getEquipment().getDescription();
    }

    //用于TeamView类中getTeam方法的中逻辑的调用
    public String getDetailsForTeamView(){
        return getMemberId() + "/" +getId()+"\t\t"  + getName() + "\t" +
                getAge() + "\t" + getSalary() + "\t架构师\t"+getBonus()+"\t"+getStock();
    }
}
