package service;

import bean.Customer;

/**
 * @author kinoz
 * @date 2022/4/2 - 14:42
 * @apiNote ΪCustomer����Ĺ���ģ�飬�ڲ����������һ��Customer�����ṩ��Ӧ����ɾ�Ĳ�ͱ����������ҹ�CustomerView����
 * ���Ʋ� ����ҵ���߼�
 */
public class CustomerList {
    private Customer[] cusobjcet;   //����ͻ����������
    private int totalCusNum;          //��¼�Ѿ�����ͻ�������

    /** 1
    * ��ʼ��customers����Ĺ�����
    * @param totalCustomer:ָ������ĳ���
    */
    public CustomerList(int totalCustomer){
        cusobjcet = new Customer[totalCustomer];
    }

    /** 2
     * ��ָ���Ŀͻ���ӵ�������
     * @return true:��ӳɹ� false:���ʧ��
     */
    public boolean addCustomer(Customer customer){
        if (totalCusNum >= cusobjcet.length){
            return false;
        }else {
            cusobjcet[totalCusNum++] = customer;
            return true;
        }
    }

    /** 3
     * �޸�ָ������λ�õĿͻ���Ϣ
     * @param index �ͻ�����
     * @param crust �µ�����
     * @return true:�޸ĳɹ� false:�޸�ʧ��
     */
    public boolean replaceCustomer(int index,Customer crust){
        if (index < 0 || index >= totalCusNum){
            return false;
        }else {
            cusobjcet[index] = crust;
            return true;
        }
    }

    /** 4
     * ɾ��ָ������λ�õĿͻ���Ϣ
     * @param index �ͻ�����
     * @return true:ɾ���ɹ� false:ɾ��ʧ��
     */
    public boolean deleteCustomer(int index){
        if (index < 0 || index >= totalCusNum){
            return false;
        }else {
            for (int i = index; i < totalCusNum -1 ; i++) {
                cusobjcet[i] = cusobjcet[i+1];
            }
            //��������ݵ�Ԫ����Ҫ�ÿ�
            cusobjcet[totalCusNum -1] =null;
            totalCusNum--;
            return true;
        }
    }

    /** 5
     * �������пͻ���Ϣ
     * @return ���صĲ������е����飬���������Լ��������
     */
    public Customer[] getAllCustomer(){
        Customer[] crusts = new Customer[totalCusNum];
        for (int i = 0; i < totalCusNum; i++) {
            // ����������ֵ �������� ��˼����crusts��customersָ�����ͬһ������ʵ��
            crusts[i] = cusobjcet[i];
        }
        return crusts;
    }

    /** 6
     * ��ȡָ������λ�õĿͻ���Ϣ
     * @return ����ҵ���Ԫ���򷵻� û�ҵ�����null
     */
    public Customer getCustomer(int index){
        if (index < 0 || index >= totalCusNum){
            return null;
        }
        return cusobjcet[index];
    }

    /** 7
     * ��ȡ�洢�ͻ�������
     */
    public int getTotalCusNum(){
        return totalCusNum;
    }
}
