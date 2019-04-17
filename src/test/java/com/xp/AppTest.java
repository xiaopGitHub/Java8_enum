package com.xp;

import com.xp.inter.MyTest;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 *
 * 一，Lambda表达式基础语法：Java8中引入了 "->"操作符，称为Lambda操作符或箭头操作符
 *                                          操作符将Lambda表达式拆为两部分：
 *   左侧：Lambda 表达式的参数列表
 *   右侧：Lambda 表达式的所需执行的内容，即Lambda体
 *
 *   语法格式 1：无参无返回值方法
 *              () -> System.out.println();
 *   语法格式 2：有一个参数无返回值方法
 *
 *   语法格式 3：有多个参数有返回值方法
 *
 *   语法格式 4：有多个参数，只有一条执行语句，return和{}可以省略不写
 *
 *   语法格式 5：参数列表写明数据类型,JVM编译器可以根据上下文推断出数据类型
 *
 *   一，Lambda表达式需要函数式接口支持
 *   函数式接口:只含有一个抽象方法的接口，可以使用注解@FunctionalInterface
 *
 *
 *
 */
public class AppTest {

    @Test
    public void test01(){
        Runnable runnable=() -> System.out.println("无参无返回值方法Lambda表达式语法-------");
        runnable.run();
    }

    @Test
    public void test02(){
//        Consumer<String> c = (x) -> System.out.println(x);
        Consumer<String> c = x -> System.out.println(x);
        c.accept("有一个参数无返回值方法Lambda表达式语法-------");
    }

    @Test
    public void test03(){
        Comparator<Integer> c = (x,y) -> {
            System.out.println("有多个参数执行多条语句有返回值方法Lambda表达式语法-------");
            return Integer.compare(x , y);
        };
    }

    @Test
    public void test04(){
        Comparator<Integer> c = (x,y) ->  Integer.compare(x , y);
        System.out.println(c.compare(1, 2));
    }

    @Test
    public void test05(){
        Integer total = operation(10, (v) -> v * v);
        System.out.println(total);
    }

    public Integer operation(Integer num, MyTest mt){
        return mt.test(num);
    }
}
