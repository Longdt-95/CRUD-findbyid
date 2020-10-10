/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jdbc.model;



/**
 *
 * @author Admin
 */
public class EmployeeModel {
    
    private String id;
    private String name;
    private int gerder;
    private int age;
    private String Address;

    public EmployeeModel() {
    }

    public EmployeeModel(String id, String name, int gerder, int age, String Address) {
        this.id = id;
        this.name = name;
        this.gerder = gerder;
        this.age = age;
        this.Address = Address;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGerder() {
        return gerder;
    }

    public void setGerder(int gerder) {
        this.gerder = gerder;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

   

    
}
