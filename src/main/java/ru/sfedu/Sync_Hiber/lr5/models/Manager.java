package ru.sfedu.Sync_Hiber.lr5.models;

import javax.persistence.*;

@Entity
@Table
public class Manager {
    @Id
    @GeneratedValue(generator = "increment")
    @Column
    private long id;

    @Column
    private String name;

    @OneToOne(mappedBy = "manager", cascade = CascadeType.ALL)
    private Zone zone;

    public Manager() {}

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", zone=" + zone +
                '}';
    }
}
