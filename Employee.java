package org.example;
import java.io.Serializable;
import java.util.*;
public class Employee implements Serializable {
    private String name;
    private String email;
    private String phone_number;
    private int age;

    private String post;

    private Employee employee;

    private String password;

    public Employee(String name,String email,String phone_number,int age,String post,String password) {
        this.name=name;
        this.email=email;
        this.phone_number=phone_number;
        this.age=age;
        this.post=post;
        this.password=password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
