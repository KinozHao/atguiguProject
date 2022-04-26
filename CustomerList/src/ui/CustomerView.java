package ui;

import bean.Customer;
import service.CustomerList;

/**
 * @author kinoz
 * @date 2022/4/2 - 14:42
 * @apiNote ui层，负责菜单显示和处理用户操作
 * 视图层 显示数据
 */
public class CustomerView {
   private CustomerList customerList = new CustomerList(10);

    public static void main(String[] args) {
        CustomerView View = new CustomerView();
        View.enterMainMenu();
    }

    public CustomerView(){
        //Customer cr = new Customer("刘",'男',23,"666666","666@qq.com");
        //匿名对象(此对象为默认对象)
        customerList.addCustomer(
                new Customer("刘月",'男',23,"1263266","8766@qq.com"));
    }
    //显示客户界面
   public void enterMainMenu(){
        boolean isFag = true;
        while (isFag) {
            System.out.println("----客户信息管理软件----");
            System.out.println("1 添加客户");
            System.out.println("2 修改客户");
            System.out.println("3 删除客户");
            System.out.println("4 客户列表");
            System.out.println("5 退出\n");
            System.out.print("请选择(1-5)：");

            char menu = CMUtility.readMenuSelection();
            switch (menu){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("是否确认退出(Y/N):");
                    char exit = CMUtility.readConfirmSelection();
                    if (exit == 'Y'){
                        isFag = false;
                    }
            }
        }

    }
    //添加客户信息
    public void addNewCustomer(){
        System.out.println("---------------------------添加客户---------------------------");
        System.out.print("姓名:");
        String name = CMUtility.readString(10);

        System.out.print("性别:");
        char gender = CMUtility.readChar();

        System.out.print("年龄:");
        int age = CMUtility.readInt();

        System.out.print("电话:");
        String tel = CMUtility.readString(11);

        System.out.print("邮箱:");
        String mail = CMUtility.readString(30);

        //上述数据进行封装到一个对象里面
        Customer customer = new Customer(name,gender,age,tel,mail);
        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess){
            System.out.println("---------------------------添加完成---------------------------");
        }else {
            System.out.println("---------------------------添加失败---------------------------");
        }

    }
    //修改客户信息
    public void modifyCustomer(){
        System.out.println("---------------------------修改客户---------------------------");
        Customer cust;
        int number;  //判断用户数输入数字
        for(;;) {
            System.out.print("请选择待修改客户的标号(-1退出):");
            number = CMUtility.readInt();
            if (number == -1){
                return;
            }
            cust = customerList.getCustomer(number -1);   //用户默认输入数字比索引大1所以要-1
            if (cust == null){
                System.out.println("无法找到此客户！！！");
            }else {
                break;  //break的情况就是找到了
            }
        }
        //以下为找到后的修改语句
        System.out.print("姓名("+cust.getName()+"):");
        String name = CMUtility.readString(10,cust.getName());

        System.out.print("性别("+cust.getGender()+"):");
        char sex = CMUtility.readChar(cust.getGender());

        System.out.print("年龄("+cust.getAge()+"):");
        int age = CMUtility.readInt(cust.getAge());

        System.out.print("电话("+cust.getPhone()+"):");
        String tel = CMUtility.readString(11,cust.getPhone());

        System.out.print("邮箱("+cust.getEmail()+"):");
        String email = CMUtility.readString(30,cust.getEmail());

        Customer newcust = new Customer(name,sex,age,tel,email);
        // number-1:用户默认输入数字比索引大1所以要-1
        boolean isReplaced = customerList.replaceCustomer(number-1,newcust);
        if (isReplaced){
            System.out.println("---------------------------修改成功---------------------------");
        }else {
            System.out.println("---------------------------修改失败---------------------------");
        }
    }
    //删除客户信息
    public void deleteCustomer(){
        System.out.println("---------------------------删除客户---------------------------");
        int number; //判断用户数输入数字
        for (;;){
            System.out.print("请选择待删除客户的标号(-1退出):");
            number = CMUtility.readInt();
            if (number == -1){
                return;
            }
            Customer customer = customerList.getCustomer(number -1);

            if (customer == null){
                System.out.println("无法找到指定客户！");
            }else {
                break;  //break的情况就是找到了
            }
        }
        //以下为找到后的修改语句
        System.out.print("是否确定删除(Y/N):");
        char isDelete = CMUtility.readConfirmSelection();
        if (isDelete == 'Y'){
            boolean isDeleted =customerList.deleteCustomer(number - 1);
            if (isDeleted){
                System.out.println("---------------------------删除成功---------------------------");
            }else{
                System.out.println("---------------------------删除失败---------------------------");
            }
        }
    }
    //查看所有客户信息
    public void listAllCustomers(){
        System.out.println("---------------------------客户列表---------------------------\n");
        int total = customerList.getTotalCusNum();
        if (total == 0){
            System.out.println("没有客户信息");
        }else {
            System.out.println("编号\t姓名\t性别\t年纪\t电话\t\t邮箱");
            Customer[] custs =  customerList.getAllCustomer();
            for (int i = 0; i < custs.length; i++) {
                Customer cust = custs[i];
                System.out.println((i+1)+"\t"+cust.getName()+"\t"+cust.getGender()
                +"\t"+cust.getAge()+"\t"+cust.getPhone()+"\t"+cust.getEmail());
            }

        }
        System.out.println("-------------------------客户列表完成-------------------------");
    }
}
