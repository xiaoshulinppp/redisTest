package com.liu.redisTest.domain;

import java.io.Serializable;

 
public class UserVO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int id;
    private String username;
    private String password;
    private int age;
    
    public UserVO(){
        super(); 
    }
    
    public UserVO(int id, String username, String password, int age) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserVO [id=" + id + ", username=" + username + ", password="
                + password + ", age=" + age + "]";
    }

}