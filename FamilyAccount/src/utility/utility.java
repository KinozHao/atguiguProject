package utility;
import java.util.*;
//打包方法
public class utility {
            private static Scanner scanner = new Scanner(System.in);
            //1.判断菜单的选择
            public static char readMenuSelection(){
                char c;
                for(; ; ){
                    String str = readKeyBoard(1);
                    c = str.charAt(0);
                    if (c !='1' && c != '2' && c != '3' && c != '4'){
                        System.out.println("选择错误，请重新输入：");
                    }else break;
                }
                return c;
            }
            //2.键盘录入数值,判断数值的范围
            public static int readNumber(){
                int n;
                for(; ; ){
                    String str = readKeyBoard(4);
                    try{
                        n = Integer.parseInt(str);
                        break;
                    }catch(NumberFormatException e){
                        System.out.println("数字输入错误，请重新输入：");
                    }
                }
                return n;
            }
            //2.键盘录入收支金额的说明
            public static String readString(){
                String str = readKeyBoard(8);
                return str;
            }

            //3.退出账单的判断,输入Y就break否则就返回,toUpperCase自动转换为大写
            public static char readConfirmSelection(){
                char c;
                for(; ; ){
                    String str = readKeyBoard(1).toUpperCase(); //键盘录入转为大写的方法
                    c = str.charAt(0);
                    if(c == 'Y' || c == 'N'){
                        break;
                    }else{
                        System.out.print("选择错误，请重新输入：");
                    }
                }
                return c;
            }

            public static String readKeyBoard(int limit){
                label:for (; ; ){
                    String str = scanner.next();
                    if(str.length() > limit){
                        System.out.println("输入过长，请重新出入：");
                        continue label;
                    }else{
                        return str;
                    }
                }
            }
}
