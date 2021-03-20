package ru.sfedu.Sync_Hiber.lr4.models;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Table
@Entity
public class Channel {

    @Id
    @GeneratedValue(generator = "increment")
    @Column
    private long id;

    @Column
    private String name;

    @ElementCollection
    @CollectionTable(name = "Languages")
    @Column
    private Set<String> language;

    @Column()
    private Boolean status;

    @ElementCollection
    @CollectionTable(name = "Speakers")
    @OrderColumn
    @Column
    private List<String> speakers;

    @ElementCollection
    @CollectionTable(name = "Features")
    @MapKeyColumn(name = "Feature")
    @Column
    private Map<String, String> features;

    @ElementCollection
    @CollectionTable(name = "SpeakerList")
    @AttributeOverride(
            name = "name",
            column = @Column(name = "spk_name")
    )
    private Set<Speaker> speakerList;

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

    public Set<String> getLanguage() {
        return language;
    }

    public void setLanguage(Set<String> language) {
        this.language = language;
    }

    public List<String> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<String> speakers) {
        this.speakers = speakers;
    }

    public Map<String, String> getFeatures() {
        return features;
    }

    public void setFeatures(Map<String, String> features) {
        this.features = features;
    }

    public Set<Speaker> getSpeakerList() {
        return speakerList;
    }

    public void setSpeakerList(Set<Speaker> speakerList) {
        this.speakerList = speakerList;
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
                ", features=" + features +
                ", speakerList=" + speakerList +
                '}';
    }
}
