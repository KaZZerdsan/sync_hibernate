package ru.sfedu.Sync_Hiber.lr2.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
    public Address(){}

    @Column
    private String streetName;

    @Column
    private String city;

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
