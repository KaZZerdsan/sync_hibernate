package ru.sfedu.Sync_Hiber.lr5.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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
    @OneToMany(cascade = CascadeType.ALL)
    private List<Channel> channelList;

    @Column(columnDefinition = "TINYINT")
    private Boolean status;

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

    public void setDateStart(Long dateStart) {
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
                ", name='" + name + '\'' +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", channelList=" + channelList +
                ", status=" + status +
                '}';
    }
}
