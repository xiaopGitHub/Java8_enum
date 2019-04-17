package com.xp.inter;

/**
 * @Author xp
 * @CreateTime 2019/04/14  22:46
 * @Function 带2个泛型的函数式接口
 */

@FunctionalInterface
public interface MyFuntion02<T,R> {

    public R getValue(T t1,T t2);
}
