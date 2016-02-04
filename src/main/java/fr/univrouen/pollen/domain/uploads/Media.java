package fr.univrouen.pollen.domain.uploads;

import javax.persistence.*;

import fr.univrouen.pollen.domain.Identifiable;
import fr.univrouen.pollen.domain.polling.Poll;
import fr.univrouen.pollen.domain.social.User;
import fr.univrouen.pollen.dto.upload.MediaDto;

import java.sql.Timestamp;

@Entity
@Table
public class Media implements Identifiable {
    //General

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="mediaId")
    private long id;
    private String originalName;
    private String generatedName;
    private MediaType type;

    //Dates
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @OneToOne
    private Poll poll;

    @OneToOne
    private User user;

    public Media() {
    }

    public Media(MediaDto dto) {
        this.id = dto.getId();
        this.originalName = dto.getOriginalName();
        this.generatedName = dto.getGeneratedName();
        this.type = dto.getType();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getGeneratedName() {
        return generatedName;
    }

    public void setGeneratedName(String generatedName) {
        this.generatedName = generatedName;
    }

    public MediaType getType() {
        return type;
    }

    public void setType(MediaType type) {
        this.type = type;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public MediaDto toDto() {
        MediaDto dto = new MediaDto();
        dto.setId(id);
        dto.setOriginalName(originalName);
        dto.setGeneratedName(generatedName);
        dto.setType(type);
        return dto;
    }
}
