package com.xp;

import com.xp.inter.MyFunction;
import com.xp.inter.MyFuntion02;
import com.xp.po.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AppTest01 {

    List<Employee> emps = Arrays.asList(
        new Employee(101,"tom",20,10000, Employee.Status.FREE),
        new Employee(102,"jack",22,12000, Employee.Status.BUSY),
        new Employee(103,"lucy",24,11000, Employee.Status.VACATION),
        new Employee(104,"carl",21,15000,Employee.Status.BUSY),
        new Employee(105,"jerry",21,15000, Employee.Status.FREE)
    );

    /**
     * Collections.sort()方法，通过定制排序比较两个Employee
     *       先按照年龄比，年龄相同按姓名比，使用Lambda作为参数传递
     * */
    @Test
    public void test01(){
        Collections.sort(emps, (e1,e2) -> {
            if (e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });

        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }

    /**
     * Lambda表达式当成数据传递
     *
     * */
    @Test
    public void test02(){
        String s = strHandler("afahih", (str) -> str.toUpperCase());
        System.out.println(s);
    }

    @Test
    public void test03(){
        op(100L,200L ,(x,y) ->  x + y);
    }


    //需求：用于字符串处理
    public String strHandler(String s, MyFunction mf){
        return mf.getValue(s);
    }

    //需求：对两个Long型数据进行处理
    public void op(Long l1, Long l2, MyFuntion02<Long,Long> mf){
        System.out.println(mf.getValue(l1,l2 ));
    }
}
