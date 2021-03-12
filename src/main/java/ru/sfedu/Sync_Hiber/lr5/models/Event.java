package ru.sfedu.Sync_Hiber.lr5.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

public class Event {
    @Id
    @GeneratedValue(generator = "increment")
    @Column
    private long id;

    @Column
    private String name;

    @Column
    @OneToOne
    private Manager manager;

    @Column
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Zone> zoneList;

    public Event() {}

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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }


    public List<Zone> getZoneList() {
        return zoneList;
    }

    public void setZoneList(List<Zone> zoneList) {
        this.zoneList = zoneList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(manager, event.manager) &&
                Objects.equals(zoneList, event.zoneList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manager, zoneList);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manager=" + manager +
                ", zoneList=" + zoneList +
                '}';
    }
}
