package com.xp.po;

import java.util.Objects;

/**
 * @Author xp
 * @CreateTime 2019/04/14  18:11
 * @Function ${VAR}
 */
public class Employee {

    private Integer id;
    private String name;
    private Integer age;
    private Integer salary;

    public Employee(Integer id, String name, Integer age, Integer salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(getId(), employee.getId()) &&
                Objects.equals(getName(), employee.getName()) &&
                Objects.equals(getAge(), employee.getAge()) &&
                Objects.equals(getSalary(), employee.getSalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getSalary());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
