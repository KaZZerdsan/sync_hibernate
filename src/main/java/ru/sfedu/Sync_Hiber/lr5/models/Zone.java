package ru.sfedu.Sync_Hiber.lr5.models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "zone")
public class Zone {
    @Id
    @GeneratedValue(generator = "increment")
    @Column
    private long id;

    @Column
    private String name;

    @Column
    private long dateStart;

    @Column
    private long dateEnd;

    @Column
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Channel> channelList = new ArrayList<>();

    @Column()
    private Boolean status;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "man_id", referencedColumnName = "id")
    private Manager manager = new Manager();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "ZONE_GUESTS",
            joinColumns = @JoinColumn(name = "Zone_id"),
            inverseJoinColumns = @JoinColumn(name = "Guest_id")
    )
    private List<Guest> guests = new ArrayList<>();

    public Zone() {}

    public long getId() {
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

    public long getDateStart() {
        return dateStart;
    }

    public void setDateStart(long dateStart) {
        this.dateStart = dateStart;
    }

    public long getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(long dateEnd) {
        this.dateEnd = dateEnd;
    }

    public List<Channel> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<Channel> channelList) {
        this.channelList = channelList;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zone zone = (Zone) o;
        return dateStart == zone.dateStart &&
                dateEnd == zone.dateEnd &&
                status == zone.status &&
                Objects.equals(channelList, zone.channelList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateStart, dateEnd, channelList, status);
    }

    @Override
    public String toString() {
        return "Zone{" +
                "id=" + id +
//                ", manager=" + manager +
                ", name='" + name + '\'' +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", channelList=" + channelList +
                ", status=" + status +
                '}';
    }
}
