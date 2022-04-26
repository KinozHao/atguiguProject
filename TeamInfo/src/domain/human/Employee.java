package domain.human;

/**
 * @author kinoz
 * @date 2022/4/22 - 20:48
 * @apiNote
 */
public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee() {
        super();
    }

    public Employee(int id, String name, int age, double salary) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return getDetails();
    }
    /*
    * 子类的子类需要调用时候可能会遇到参数重复问题
    * 直接把toString包装为方法，子类的子类调用时候
    * 直接调用此方法即可，就不用super.toString()了
    * */
    public String getDetails() {
        return id +"\t" + name + "\t" + age + "\t" + salary;
    }
}
