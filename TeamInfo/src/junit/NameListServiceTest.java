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
 * @apiNote 对NameListService的测试
 * 开发中要写一点测试一点，不要全部写完了等到最后去测设
 * 那样会死的很惨，秃头的很快
 * 要不断的debug查看异常提高自己的逻辑能力
 */
public class NameListServiceTest {
    NameListService service = new NameListService();
    @Test
    //获取所有员工
    public void testNameListService(){
        Employee[] employees = service.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    @Test
    //获取指定id员工
    public void textGetIndexEmployee() {
        try {
            System.out.println(service.getEmployee(32));
        } catch (TeamException e) {
            //输入我们自己throw的异常信息
            System.out.println(e.getMessage());
        }
    }
}
