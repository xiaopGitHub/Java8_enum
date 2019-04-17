package com.xp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8四大内置核心函数式接口
 * 1. Consumer<T>：消费型接口,无返回值
 *    void accept(T t)
 *
 * 2. Supplier<T>：供给型接口,有返回值
 *    T get();
 *
 * 3. Function<T,R>：函数型接口，传入T类型参数，返回R类型数据
 *    R apply(T t); 传入T，返回R
 *
 * 4. Predict<T>：断言型接口,通常执行判断操作
 *    boolean test(T t);
 * */
public class AppTest02 {

    //consumer
    @Test
    public void test01(){
        happy(10000, (m) -> System.out.println("消费："+m+" 元------------"));
    }

    //supplier
    @Test
    public void test02(){
        List<Double> numList = getNumList(10, () -> Math.random() * 100);
        for (Double d : numList) {
            System.out.println(d);
        }

    }

    @Test
    public void test03(){
        String s = strHandler("asd", (str) -> str.toUpperCase());
        System.out.println(s);
    }

    @Test
    public void test04(){
        List<String> list= Arrays.asList("Hello","XP","www");
        List<String> l = filterStr(list, (s) -> s.length() > 2);

        for (String s : l) {
            System.out.println(s);
        }
    }




    public void happy(double d , Consumer<Double> c){
        c.accept(d);
    }

    public List<Double> getNumList(int num, Supplier<Double> sup){
        List<Double> list =new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Double n= sup.get();
            list.add(n);
        }
        return list;
    }

    public String strHandler(String str , Function<String,String> mf){
        String apply = mf.apply(str);
        return apply;
    }

    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> stringList =new ArrayList<>();

        for (String s : list) {
            if (pre.test(s)){
                stringList.add(s);
            }
        }

        return stringList;
    }
}
