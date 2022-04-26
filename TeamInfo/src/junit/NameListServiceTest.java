package junit;

import domain.human.Designer;
import domain.human.Employee;
import domain.human.Programmer;
import org.junit.Test;
import service.NameListService;
import service.TeamException;

import java.util.Arrays;

/**
 * @author kinoz
 * @date 2022/4/24 - 15:38
 * @apiNote ��NameListService�Ĳ���
 * ������Ҫдһ�����һ�㣬��Ҫȫ��д���˵ȵ����ȥ����
 * ���������ĺܲң�ͺͷ�ĺܿ�
 * Ҫ���ϵ�debug�鿴�쳣����Լ����߼�����
 */
public class NameListServiceTest {
    NameListService service = new NameListService();
    @Test
    //��ȡ����Ա��
    public void testNameListService(){
        Employee[] employees = service.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    @Test
    //��ȡָ��idԱ��
    public void textGetIndexEmployee() {
        try {
            System.out.println(service.getEmployee(32));
        } catch (TeamException e) {
            //���������Լ�throw���쳣��Ϣ
            System.out.println(e.getMessage());
        }
    }
}
