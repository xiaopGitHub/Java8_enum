package com.xp;

import com.xp.po.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author xp
 * @CreateTime 2019/04/18  22:45
 * @Function Stream中间操作，筛选和切片
 */
public class AppTest04 {
    List<Employee> emps = Arrays.asList(
            new Employee(101,"tom",20,10000, Employee.Status.BUSY),
            new Employee(102,"jack",22,12000,Employee.Status.VACATION),
            new Employee(103,"lucy",24,11000,Employee.Status.BUSY),
            new Employee(104,"carl",21,15000,Employee.Status.FREE),
            new Employee(105,"jerry",21,15000,Employee.Status.FREE),
            new Employee(105,"jerry",21,15000,Employee.Status.BUSY),
            new Employee(105,"jerry",21,15000,Employee.Status.VACATION)
    );
    /**
     * 中间操作：
     * 筛选和切片
     * filter:接收Lambda,从流中排除某些元素
     * limit:截断流,使元素不超过指定数量
     * skip(n):跳过元素，返回一个扔掉了前n个元素的流。若元素不足n个，则返回一个空流，与limit(n)互补
     * distinct:筛选，通过流所生成元素的 hasnCode()和 equals() 去重
     *
     * */
    @Test
    public void test01(){
        //筛选
        emps.stream()
            //筛选年龄大于21岁的员工
            .filter((e) -> e.getAge()>21)
            .forEach(System.out::println);
    }

    @Test
    public void test02(){
        //切片，获取千3条数据
        emps.stream()
            .limit(3)
            .forEach(System.out::println);
    }

    @Test
    public void test03(){
        //跳过，跳过前2条数据，获取后面余下的数据
        emps.stream()
                .filter((e) -> e.getAge()>20)
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    public void test04(){
        //去重，去除重复的数据
        emps.stream()
                .filter((e) -> e.getAge()>20)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 映射
     * map -- 接收Lambda 将元素转换成其他形式或提取。接受一个函数作为参数，该函数会被应用到每一个
     *        元素上，并将其映射成一个新的元素。
     *
     * flashMap -- 接受一个函数作为参数，将流中的每一个值都换成另一个流，然后把所有的流连接成一个流
     *
     *
     * */
    @Test
    public void test05(){
        //map映射,map返回一个流
        emps.stream()
                .map((e) -> e.getAge()+10)
                .forEach(System.out::println);

        emps.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

}
