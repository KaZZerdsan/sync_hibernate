package ru.sfedu.Sync_Hiber.lr5.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Table
@Entity
public class Channel {

    @Id
    @GeneratedValue(generator = "increment")
    @Column
    private long id;

    @Column
    private String name;

    private String language;

    @Column(columnDefinition = "TINYINT")
    private Boolean status;

    @Column
    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Speaker> speakers;

    public Channel() {}

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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Channel channel = (Channel) o;
        return Objects.equals(language, channel.language) &&
                Objects.equals(speakers, channel.speakers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(language, speakers);
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", language=" + language +
                ", status=" + status +
                ", speakers=" + speakers +
                '}';
    }
}
