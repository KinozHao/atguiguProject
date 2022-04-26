package ui;

import utility.utility;

public class UserView {
    public static void main(String[] args) {
        boolean isFlag = true;
        int balance = 10000;
        //用它来记录收入支出的说明
        String details ="收支\t账户金额\t收支金额\t说   明\n";
        while (isFlag){
                System.out.println("------------家庭收支记账软件--------------\n");
                System.out.println("             1 收支明细");
                System.out.println("             2 登记收入");
                System.out.println("             3 登记支出");
                System.out.println("             4 退出\n");
                System.out.print("             请选择<1-4>:");
            //获取用户的选择:仅限于1-4
            char selection = utility.readMenuSelection();
            switch (selection){
                case '1':
                    //System.out.println("1 收支明细");
                    System.out.println("------------当前收支明细记录--------------");
                    System.out.println(details);
                    System.out.println("----------------------------------------");
                    break;
                case '2':
                    //System.out.println("2 登记收入");
                    System.out.print("本次收入金额:");
                    int addMoney = utility.readNumber();
                    System.out.print("本次收入说明:");
                    String addInfo = utility.readString();

                    //处理balance
                    balance += addMoney;
                    //处理details
                    details +=("收入\t"+balance+"\t"+addMoney+"\t\t"+ addInfo +"\n");

                    System.out.println("---------------登记完成------------------\t");
                    break;
                case '3':
                    //System.out.println("3 登记支出");
                    System.out.print("本次支出金额:");
                    int minusMoney = utility.readNumber();
                    System.out.print("本次支出说明:");
                    String minusInfo = utility.readString();

                    //处理balance
                    if (balance>= minusMoney){
                        balance -= minusMoney;
                        //处理details
                        details +=("支出\t"+balance+"\t"+ minusMoney +"\t\t"+ minusInfo +"\n");
                    }else{
                        System.out.println("支出超出账户额度，支付失败");
                    }

                    System.out.println("---------------登记完成------------------\t");
                    break;
                case '4':
                    System.out.print("是否确定退出(Y/N):");
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
