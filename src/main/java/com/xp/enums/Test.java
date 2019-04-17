package com.xp.enums;

/**
 * @Author xp
 * @CreateTime 2019/04/17  22:53
 * @Function 使用enum关键字创建枚举类
 */
public class Test{
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
        spring.show();
        System.out.println(spring.getName()+" -----------> "+spring.getDesc());
        //values()方法,以对象数组的形式返回枚举类的所有对象
        Season01[] values = Season01.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        //valueOf()方法,返回字符串锁对应的对象
        String str = "SPRING";
        Season01 season01 = Season01.valueOf(str);
        System.out.println(season01.getName()+" -----------> "+season01.getDesc());
    }
}

//enum关键字创建枚举类
//常用方法: values() , valueOf()
enum  Season01 {
    SPRING("spring","春天"),
    SUMMER("summer","夏天"),
    FALL("fall","秋天"),
    WINTER("winter","冬天");

    //1.提供类的属性,声明为 private final
    private final String name;
    private final String desc;

    //2.构造器中初始化final属性
    private Season01(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    //3.提供公共方法调用属性
    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    //自定义方法
    public void show(){
        System.out.println("这是季节。。。");
    }
}
