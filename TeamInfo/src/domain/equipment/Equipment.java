package domain.equipment;

/**
 * @author kinoz
 * @date 2022/4/22 - 20:51
 * @apiNote
 */
public interface Equipment {

    /*用于获取设备的信息
    * 实例类实现了这个方法
    * human包下的类直接通过Equipment接口的对象调用此方法即可*/
    String getDescription();
}
