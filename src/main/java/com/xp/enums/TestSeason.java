package com.xp.enums;

/**
 * @Author xp
 * @CreateTime 2019/04/17  22:35
 * @Function 自定义枚举类：内的对象个数确定,对象在类的内部创建好
 */
public class TestSeason {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
        spring.show();
        System.out.println(spring.getName()+" ----------- "+spring.getDesc());
    }

}

//枚举类
class Season{

    //1.提供类的属性,声明为 private final
    private final String name;
    private final String desc;

    //2.构造器中初始化final属性
    public Season(String name, String desc) {
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

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }


    //4.内部创建枚举类的对象,通过类名调用
    public static final Season SPRING = new Season("spring","春天");
    public static final Season SUMMER = new Season("summer","夏天");
    public static final Season FALL = new Season("fall","秋天");
    public static final Season WINTER = new Season("winter","冬天");


    //自定义方法
    public void show(){
        System.out.println("这是季节。。。");
    }
}
