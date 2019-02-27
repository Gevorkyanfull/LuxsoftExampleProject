package com.guzichenko.services;

public class ClientData {
    public String name;
    public String surname;
    public int age;
    public String phoneNumber;
    public String email;
    public ClientData(String name, String surname, int age, String phoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public ClientData(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }
}