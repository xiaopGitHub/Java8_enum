package com.xp;

/**
 * @Author xp
 * @CreateTime 2019/04/18  22:24
 * @Function Java8 流Stream操作
 */


import org.junit.Test;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一，Stream的三个操作步骤
 * 1. 创建 Stream
 *
 * 2. 中间操作
 *    筛选，切片，排序
 *
 * 3. 终止操作
 *
 * */
public class AppTest03 {

    //创建流
    @Test
    public void test01(){

        //1. 通过 Collection 系列集合提供的stream() 或 parallelStream()创建流
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //2. 通过Arrays 中的静态方法stream() 创建数组流
        Book[] books=new Book[10];
        Stream<Book> stream1 = Arrays.stream(books);

        //3. Stream类中的静态方法of(),创建流
        Stream<String> stream2 = Stream.of("aa", "bb", "cc");

        //4. 创建无限流
        //迭代
        Stream<Integer> stream3 = Stream.iterate(0, x -> x + 2);
//        stream3.forEach(System.out::println);
//        stream3.limit(10).forEach(System.out::println);//只产生10个数

        //生成
        Stream.generate(() -> Math.random())
              .limit(15)
              .forEach(System.out::println);

    }



}
