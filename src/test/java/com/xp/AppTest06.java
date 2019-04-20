package com.xp;

import com.xp.po.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @Author xp
 * @CreateTime 2019/04/18  22:45
 * @Function Stream终止操作 -- 查找和匹配
 */
public class AppTest06 {
    List<Employee> emps = Arrays.asList(
            new Employee(101,"tom",20,10000, Employee.Status.BUSY),
            new Employee(102,"jack",22,12000,Employee.Status.VACATION),
            new Employee(103,"lucy",24,11000,Employee.Status.BUSY),
            new Employee(104,"carl",21,15000,Employee.Status.FREE),
            new Employee(105,"jerry",21,15000,Employee.Status.FREE)
    );

    List<String> list =Arrays.asList("aa","bb","cc","dd");

    /**
     * 终止操作：
     * 查找和匹配
     * allMatch -- 检查是否匹配所有元素
     * anyMatch -- 检查是否匹配至少一个元素
     * noneMatch -- 检查是否没有匹配所有元素
     * findFirst -- 返回第一个元素
     * findAny -- 返回当前流中的任意元素
     * count -- 返回流中元素总个数
     * max -- 返回流中最大值
     * min -- 返回流中最小值
     *
     * */

    @Test
    public void test01() {
        //判断是否所有员工都是VACATION
        boolean b1 = emps.stream()
                .allMatch((e) -> e.getStatus().equals(Employee.Status.VACATION));
        System.out.println(b1);

        //判断是否有员工是VACATION
        boolean b2 = emps.stream()
                .anyMatch((e) -> e.getStatus().equals(Employee.Status.VACATION));
        System.out.println(b2);

        //判断是否没有员工是VACATION
        boolean b3 = emps.stream()
                .noneMatch((e) -> e.getStatus().equals(Employee.Status.VACATION));
        System.out.println(b3);

        //降序排序获取第一个,即工资最高的员工
        Optional<Employee> optional = emps.stream()
                .sorted((e1,e2) -> -Integer.compare(e1.getSalary(),e2.getSalary()))
                .findFirst();

        //升序排序获取第一个,即工资最低的员工
/*        Optional<Employee> optional = emps.stream()
                .sorted((e1,e2) -> Integer.compare(e1.getSalary(),e2.getSalary()))
                .findFirst();*/
        System.out.println(optional.get());


        //任意找一个BUSY的员工
        Optional<Employee> optional1 = emps.stream()
                .filter(e -> e.getStatus().equals(Employee.Status.BUSY))
                .findAny();

        System.out.println(optional1.get());


        //返回年龄大于20岁的员工人数
        long count = emps.stream()
                .filter(employee -> employee.getAge() > 20)
                .count();

        System.out.println(count);



        //获取工资最低的员工
        Optional<Employee> min = emps.stream()
                .min(Comparator.comparingInt(Employee::getSalary));

        System.out.println(min.get());

        //获取工资最高的员工信息
        Optional<Employee> max = emps.stream()
                .max(Comparator.comparingInt(Employee::getSalary));

        System.out.println(max.get());

        //获取最高工资
        Optional<Integer> max1 = emps.stream()
                .map(Employee::getSalary)
                .max(Integer::compare);

        System.out.println(max1.get());
    }
}
