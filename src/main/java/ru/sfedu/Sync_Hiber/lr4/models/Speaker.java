package ru.sfedu.Sync_Hiber.lr4.models;

import javax.persistence.*;

@Embeddable
public class Speaker {

    @Column
    private String name;

    public Speaker() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Speaker{" +
                "name='" + name + '\'' +
                '}';
    }
}
