package domain.human;

import domain.equipment.Equipment;
import service.Status;

/**
 * @author kinoz
 * @date 2022/4/22 - 20:50
 * @apiNote
 */
public class Programmer extends Employee{
    private int memberId;//�����Ŷ��е�id(�����˴��Ŷ���ɾ�������⻹���Ŷӵ��˵�memberID�ǲ����)
    /*������StatusĬ��״̬Ϊfree
    NameLitService����Ŀ��û��Ҫ�����statusԪ��
    ��ͨ�����ڵ�TeamService����ʱ�ٽ����޸ĵ�
     */
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer() {
        super();
    }

    public Programmer(int id, String name, int age, double salary,Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        //����getDescription()���������ؾ������Ϣ�����������򷵻ص�ֵַ
        return getDetails()+"\t����Ա\t"+status+"\t\t\t\t\t"+equipment.getDescription();
    }

    //����TeamView����getTeam���������߼��ĵ���
    public String getDetailsForTeamView(){
        return memberId + "/" +getId()+"\t\t" +getName() + "\t" + getAge() + "\t" + getSalary() + "\t����Ա";
    }
}
