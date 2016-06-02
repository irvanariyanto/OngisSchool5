package com.example.bay.ongisschool5;

/**
 * Created by BAY on 6/1/2016.
 */
public class Person {
    Integer id;
    String name;
    String address;

    public Person(){

    }

    public Person(String name, String address) {
//        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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


}
