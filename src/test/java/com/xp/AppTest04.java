package com.xp;

import com.xp.po.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author xp
 * @CreateTime 2019/04/18  22:45
 * @Function Stream操作
 */
public class AppTest04 {
    List<Employee> emps = Arrays.asList(
            new Employee(101,"tom",20,10000),
            new Employee(102,"jack",22,12000),
            new Employee(103,"lucy",24,11000),
            new Employee(104,"carl",21,15000),
            new Employee(105,"jerry",21,15000),
            new Employee(105,"jerry",21,15000),
            new Employee(105,"jerry",21,15000)
    );
    /**
     * 筛选和切片
     * filter:接收Lambda,从流中排除某些元素
     * limit:截断流,使元素不超过指定数量
     * skip(n):跳过元素，返回一个扔掉了前n个元素的流。若元素不足n个，则返回一个空流，与limit(n)互补
     * distinct:筛选，通过流所生成元素的 hasnCode()和 equals() 去重
     *
     * */
    @Test
    public void test01(){
        emps.stream()
            .filter((e) -> e.getAge()>21)
            .forEach(System.out::println);
    }

    @Test
    public void test02(){
    emps.stream()
        .limit(3)
        .forEach(System.out::println);
    }

    @Test
    public void test03(){
        emps.stream()
                .filter((e) -> e.getAge()>20)
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    public void test04(){
        emps.stream()
                .filter((e) -> e.getAge()>20)
                .distinct()
                .forEach(System.out::println);
    }
}
