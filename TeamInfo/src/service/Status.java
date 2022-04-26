package service;

/**
 * @author kinoz
 * @date 2022/4/23 - 19:20
 * @apiNote 员工的状态类(枚举类的体现)
 */
public class Status {
    private final String NAME;
    private Status(String name){
        this.NAME = name;
    }
    //三个全局常量对应成员的状态
    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    //用于TeamService获取状态
    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
