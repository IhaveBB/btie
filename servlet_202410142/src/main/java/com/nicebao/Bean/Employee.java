package com.nicebao.Bean;

/** 
* @description: 
* @param: 
* @return: 
* @author: IhaveBB
* @date: 2024/11/6
**/
public class Employee {

    private String name = null;
    private String password = null;
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
