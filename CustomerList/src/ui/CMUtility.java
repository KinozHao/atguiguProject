package ui;
import java.util.*;
/**
 * @author kinoz
 * @date 2022/4/2 - 14:34
 * @apiNote
 * CMUtility�����ࣺ
 * ����ͬ�Ĺ��ܷ�װΪ���������ǿ���ֱ��ͨ�����÷���ʹ�����Ĺ��ܣ������迼�Ǿ���Ĺ���ʵ��ϸ�ڡ�
 */

public class CMUtility {
    private static Scanner scanner = new Scanner(System.in);
    /**
     ���ڽ���˵���ѡ�񡣸÷�����ȡ���̣�����û����롯1��-��5���е������ַ����򷽷����ء�����ֵΪ�û������ַ���
     */
    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' &&
                    c != '3' && c != '4' && c != '5') {
                System.out.print("ѡ��������������룺");
            } else break;
        }
        return c;
    }

    //�Ӽ��̶�ȡһ���ַ�����������Ϊ�����ķ���ֵ��
    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }

    /**
     �Ӽ��̶�ȡһ���ַ�����������Ϊ�����ķ���ֵ��
     ����û��������ַ���ֱ�ӻس�����������defaultValue ��Ϊ����ֵ��
     */
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }

    //�Ӽ��̶�ȡһ�����Ȳ�����2λ����������������Ϊ�����ķ���ֵ��
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("��������������������룺");
            }
        }
        return n;
    }

    /**
     �Ӽ��̶�ȡһ�����Ȳ�����2λ����������������Ϊ�����ķ���ֵ��
     ����û��������ַ���ֱ�ӻس�����������defaultValue ��Ϊ����ֵ��
     */
    public static int readInt(int defaultValue) {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, true);
            if (str.equals("")) {
                return defaultValue;
            }

            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("��������������������룺");
            }
        }
        return n;
    }
    /**
     �Ӽ��̶�ȡһ�����Ȳ�����limit���ַ�������������Ϊ�����ķ���ֵ��
     */
    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }
    /**
     �Ӽ��̶�ȡһ�����Ȳ�����limit���ַ�������������Ϊ�����ķ���ֵ��
     ����û��������ַ���ֱ�ӻس�����������defaultValue ��Ϊ����ֵ��
     */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("")? defaultValue : str;
    }

    //����ȷ��ѡ������롣�÷����Ӽ��̶�ȡ��Y����N������������Ϊ�����ķ���ֵ��
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("ѡ��������������룺");
            }
        }
        return c;
    }

    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("���볤�ȣ�������" + limit + "���������������룺");
                continue;
            }
            break;
        }

        return line;
    }
}

