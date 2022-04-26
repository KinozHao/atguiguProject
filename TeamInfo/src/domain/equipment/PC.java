package domain.equipment;

/**
 * @author kinoz
 * @date 2022/4/22 - 20:52
 * @apiNote ̨ʽ����
 */
public class PC implements Equipment{
    //�����ͺ�
    private String model;
    //��������
    private String display;

    public PC(String model, String display) {
        super();
        this.model = model;
        this.display = display;
    }

    public PC() {
        super();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {

        return model+ "(" + display + ")";
    }
}
