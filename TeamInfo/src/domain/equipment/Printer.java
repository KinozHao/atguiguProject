package domain.equipment;

/**
 * @author kinoz
 * @date 2022/4/22 - 20:52
 * @apiNote ��ӡ����
 */
public class Printer implements Equipment {
    //�����ͺ�
    private String name;
    //��������
    private String type;

    @Override
    public String getDescription() {
        return name+ "(" + type + ")";
    }

    public Printer(String name, String type) {
        super();
        this.name = name;
        this.type = type;
    }
    public Printer(){
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
