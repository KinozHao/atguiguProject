package ui;

import utility.utility;

public class UserView {
    public static void main(String[] args) {
        boolean isFlag = true;
        int balance = 10000;
        //��������¼����֧����˵��
        String details ="��֧\t�˻����\t��֧���\t˵   ��\n";
        while (isFlag){
                System.out.println("------------��ͥ��֧�������--------------\n");
                System.out.println("             1 ��֧��ϸ");
                System.out.println("             2 �Ǽ�����");
                System.out.println("             3 �Ǽ�֧��");
                System.out.println("             4 �˳�\n");
                System.out.print("             ��ѡ��<1-4>:");
            //��ȡ�û���ѡ��:������1-4
            char selection = utility.readMenuSelection();
            switch (selection){
                case '1':
                    //System.out.println("1 ��֧��ϸ");
                    System.out.println("------------��ǰ��֧��ϸ��¼--------------");
                    System.out.println(details);
                    System.out.println("----------------------------------------");
                    break;
                case '2':
                    //System.out.println("2 �Ǽ�����");
                    System.out.print("����������:");
                    int addMoney = utility.readNumber();
                    System.out.print("��������˵��:");
                    String addInfo = utility.readString();

                    //����balance
                    balance += addMoney;
                    //����details
                    details +=("����\t"+balance+"\t"+addMoney+"\t\t"+ addInfo +"\n");

                    System.out.println("---------------�Ǽ����------------------\t");
                    break;
                case '3':
                    //System.out.println("3 �Ǽ�֧��");
                    System.out.print("����֧�����:");
                    int minusMoney = utility.readNumber();
                    System.out.print("����֧��˵��:");
                    String minusInfo = utility.readString();

                    //����balance
                    if (balance>= minusMoney){
                        balance -= minusMoney;
                        //����details
                        details +=("֧��\t"+balance+"\t"+ minusMoney +"\t\t"+ minusInfo +"\n");
                    }else{
                        System.out.println("֧�������˻���ȣ�֧��ʧ��");
                    }

                    System.out.println("---------------�Ǽ����------------------\t");
                    break;
                case '4':
                    System.out.print("�Ƿ�ȷ���˳�(Y/N):");
                    char isExit = utility.readConfirmSelection();
                    if (isExit == 'Y'){
                        isFlag = false;
                    }
                    break;
            }
            //isFlag=false;
        }
    }
}
