package com.xp;

import com.xp.po.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author xp
 * @CreateTime 2019/04/18  22:45
 * @Function Stream操作 -- 排序 (也属于中间操作)
 */
public class AppTest05 {
    List<Employee> emps = Arrays.asList(
            new Employee(101,"tom",20,10000),
            new Employee(102,"jack",22,12000),
            new Employee(103,"lucy",24,11000),
            new Employee(104,"carl",21,15000),
            new Employee(105,"jerry",21,15000),
            new Employee(105,"jerry",21,15000),
            new Employee(105,"jerry",21,15000)
    );

    List<String> list =Arrays.asList("aa","bb","cc","dd");

    /**
     * 中间操作：
     * 排序
     * sorted()：自然排序(Comparable)
     * sorted(Comparator com)：定制排序(comparator)
     *
     * */

    @Test
    public void test01(){
        //自然排序
        list.stream()
            .sorted()
            .forEach(System.out::println);


        //定制排序
        emps.stream()
             .sorted((e1,e2) -> {
                 if(e1.getAge().equals(e2.getAge())){
                     return e1.getName().compareTo(e2.getName());
                 }else{
                     return e1.getAge().compareTo(e2.getAge());
                     //年龄逆序排
//                     return -e1.getAge().compareTo(e2.getAge());
                 }
             })
             .forEach(System.out::println);
    }

    @Test
    public void test02(){

    }

    @Test
    public void test03(){

    }

    @Test
    public void test04(){

    }


    @Test
    public void test05(){

    }

}
