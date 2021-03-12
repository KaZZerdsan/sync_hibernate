package ru.sfedu.Sync_Hiber.lr3.joined.models;


import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Admin extends User {

    @Column
    private int age;

    public Admin() {}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Admin{" + super.toString() +
                "age=" + age +
                '}';
    }
}
