package service;

/**
 * @author kinoz
 * @date 2022/4/23 - 19:20
 * @apiNote Ա����״̬��(ö���������)
 */
public class Status {
    private final String NAME;
    private Status(String name){
        this.NAME = name;
    }
    //����ȫ�ֳ�����Ӧ���ǳ�Ա�ľ���״̬
    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
