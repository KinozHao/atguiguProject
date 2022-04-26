package ui;

import bean.Customer;
import service.CustomerList;

/**
 * @author kinoz
 * @date 2022/4/2 - 14:42
 * @apiNote ui�㣬����˵���ʾ�ʹ����û�����
 * ��ͼ�� ��ʾ����
 */
public class CustomerView {
   private CustomerList customerList = new CustomerList(10);

    public static void main(String[] args) {
        CustomerView View = new CustomerView();
        View.enterMainMenu();
    }

    public CustomerView(){
        //Customer cr = new Customer("��",'��',23,"666666","666@qq.com");
        //��������(�˶���ΪĬ�϶���)
        customerList.addCustomer(
                new Customer("����",'��',23,"1263266","8766@qq.com"));
    }
    //��ʾ�ͻ�����
   public void enterMainMenu(){
        boolean isFag = true;
        while (isFag) {
            System.out.println("----�ͻ���Ϣ�������----");
            System.out.println("1 ��ӿͻ�");
            System.out.println("2 �޸Ŀͻ�");
            System.out.println("3 ɾ���ͻ�");
            System.out.println("4 �ͻ��б�");
            System.out.println("5 �˳�\n");
            System.out.print("��ѡ��(1-5)��");

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
                    System.out.print("�Ƿ�ȷ���˳�(Y/N):");
                    char exit = CMUtility.readConfirmSelection();
                    if (exit == 'Y'){
                        isFag = false;
                    }
            }
        }

    }
    //��ӿͻ���Ϣ
    public void addNewCustomer(){
        System.out.println("---------------------------��ӿͻ�---------------------------");
        System.out.print("����:");
        String name = CMUtility.readString(10);

        System.out.print("�Ա�:");
        char gender = CMUtility.readChar();

        System.out.print("����:");
        int age = CMUtility.readInt();

        System.out.print("�绰:");
        String tel = CMUtility.readString(11);

        System.out.print("����:");
        String mail = CMUtility.readString(30);

        //�������ݽ��з�װ��һ����������
        Customer customer = new Customer(name,gender,age,tel,mail);
        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess){
            System.out.println("---------------------------������---------------------------");
        }else {
            System.out.println("---------------------------���ʧ��---------------------------");
        }

    }
    //�޸Ŀͻ���Ϣ
    public void modifyCustomer(){
        System.out.println("---------------------------�޸Ŀͻ�---------------------------");
        Customer cust;
        int number;  //�ж��û�����������
        for(;;) {
            System.out.print("��ѡ����޸Ŀͻ��ı��(-1�˳�):");
            number = CMUtility.readInt();
            if (number == -1){
                return;
            }
            cust = customerList.getCustomer(number -1);   //�û�Ĭ���������ֱ�������1����Ҫ-1
            if (cust == null){
                System.out.println("�޷��ҵ��˿ͻ�������");
            }else {
                break;  //break����������ҵ���
            }
        }
        //����Ϊ�ҵ�����޸����
        System.out.print("����("+cust.getName()+"):");
        String name = CMUtility.readString(10,cust.getName());

        System.out.print("�Ա�("+cust.getGender()+"):");
        char sex = CMUtility.readChar(cust.getGender());

        System.out.print("����("+cust.getAge()+"):");
        int age = CMUtility.readInt(cust.getAge());

        System.out.print("�绰("+cust.getPhone()+"):");
        String tel = CMUtility.readString(11,cust.getPhone());

        System.out.print("����("+cust.getEmail()+"):");
        String email = CMUtility.readString(30,cust.getEmail());

        Customer newcust = new Customer(name,sex,age,tel,email);
        // number-1:�û�Ĭ���������ֱ�������1����Ҫ-1
        boolean isReplaced = customerList.replaceCustomer(number-1,newcust);
        if (isReplaced){
            System.out.println("---------------------------�޸ĳɹ�---------------------------");
        }else {
            System.out.println("---------------------------�޸�ʧ��---------------------------");
        }
    }
    //ɾ���ͻ���Ϣ
    public void deleteCustomer(){
        System.out.println("---------------------------ɾ���ͻ�---------------------------");
        int number; //�ж��û�����������
        for (;;){
            System.out.print("��ѡ���ɾ���ͻ��ı��(-1�˳�):");
            number = CMUtility.readInt();
            if (number == -1){
                return;
            }
            Customer customer = customerList.getCustomer(number -1);

            if (customer == null){
                System.out.println("�޷��ҵ�ָ���ͻ���");
            }else {
                break;  //break����������ҵ���
            }
        }
        //����Ϊ�ҵ�����޸����
        System.out.print("�Ƿ�ȷ��ɾ��(Y/N):");
        char isDelete = CMUtility.readConfirmSelection();
        if (isDelete == 'Y'){
            boolean isDeleted =customerList.deleteCustomer(number - 1);
            if (isDeleted){
                System.out.println("---------------------------ɾ���ɹ�---------------------------");
            }else{
                System.out.println("---------------------------ɾ��ʧ��---------------------------");
            }
        }
    }
    //�鿴���пͻ���Ϣ
    public void listAllCustomers(){
        System.out.println("---------------------------�ͻ��б�---------------------------\n");
        int total = customerList.getTotalCusNum();
        if (total == 0){
            System.out.println("û�пͻ���Ϣ");
        }else {
            System.out.println("���\t����\t�Ա�\t���\t�绰\t\t����");
            Customer[] custs =  customerList.getAllCustomer();
            for (int i = 0; i < custs.length; i++) {
                Customer cust = custs[i];
                System.out.println((i+1)+"\t"+cust.getName()+"\t"+cust.getGender()
                +"\t"+cust.getAge()+"\t"+cust.getPhone()+"\t"+cust.getEmail());
            }

        }
        System.out.println("-------------------------�ͻ��б����-------------------------");
    }
}
