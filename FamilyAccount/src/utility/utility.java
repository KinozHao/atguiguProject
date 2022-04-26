package utility;
import java.util.*;
//�������
public class utility {
            private static Scanner scanner = new Scanner(System.in);
            //1.�жϲ˵���ѡ��
            public static char readMenuSelection(){
                char c;
                for(; ; ){
                    String str = readKeyBoard(1);
                    c = str.charAt(0);
                    if (c !='1' && c != '2' && c != '3' && c != '4'){
                        System.out.println("ѡ��������������룺");
                    }else break;
                }
                return c;
            }
            //2.����¼����ֵ,�ж���ֵ�ķ�Χ
            public static int readNumber(){
                int n;
                for(; ; ){
                    String str = readKeyBoard(4);
                    try{
                        n = Integer.parseInt(str);
                        break;
                    }catch(NumberFormatException e){
                        System.out.println("��������������������룺");
                    }
                }
                return n;
            }
            //2.����¼����֧����˵��
            public static String readString(){
                String str = readKeyBoard(8);
                return str;
            }

            //3.�˳��˵����ж�,����Y��break����ͷ���,toUpperCase�Զ�ת��Ϊ��д
            public static char readConfirmSelection(){
                char c;
                for(; ; ){
                    String str = readKeyBoard(1).toUpperCase(); //����¼��תΪ��д�ķ���
                    c = str.charAt(0);
                    if(c == 'Y' || c == 'N'){
                        break;
                    }else{
                        System.out.print("ѡ��������������룺");
                    }
                }
                return c;
            }

            public static String readKeyBoard(int limit){
                label:for (; ; ){
                    String str = scanner.next();
                    if(str.length() > limit){
                        System.out.println("��������������³��룺");
                        continue label;
                    }else{
                        return str;
                    }
                }
            }
}
