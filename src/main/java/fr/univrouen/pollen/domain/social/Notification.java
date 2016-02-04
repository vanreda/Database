package fr.univrouen.pollen.domain.social;

import fr.univrouen.pollen.domain.Identifiable;
import fr.univrouen.pollen.dto.social.NotificationDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Notification implements Identifiable {

    // Controllers
    public Notification(long userId, String notificationText, String linkTo){
        this.userId = userId;
        this.notificationText = notificationText;
        this.linkTo = linkTo;
    }

    // ATTRIBUTES
    @Id
    @GeneratedValue
    @Column(name="notificationId")
    private long id;
    private long userId;

    @Column(nullable = false)
    private String notificationText;
    private String linkTo;
    private boolean isViewed;


    // GETTERS & SETTERS

    public Notification() {
    }

    public Notification(NotificationDto dto) {
        this.id = dto.getId();
        this.notificationText = dto.getNotificationText();
        this.linkTo = dto.getLinkTo();
        this.isViewed = dto.isViewed();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }

    public String getLinkTo() {
        return linkTo;
    }

    public void setLinkTo(String linkTo) {
        this.linkTo = linkTo;
    }

    public boolean isViewed() {
        return isViewed;
    }

    public void setIsViewed(boolean viewed) {
        isViewed = viewed;
    }

    public NotificationDto toDto() {
        NotificationDto dto = new NotificationDto();
        dto.setId(id);
        dto.setNotificationText(notificationText);
        dto.setLinkTo(linkTo);
        dto.setViewed(isViewed);
        return dto;
    }

    // Utilities Methods
    public static List<Notification> dtosToEntities(List<NotificationDto> dtos){
        List<Notification> entities = new ArrayList<>();
        for(NotificationDto dto : dtos){
            entities.add(new Notification(dto));
        }
        return entities;
    }

    public static List<NotificationDto> entitiesToDtos(List<Notification> entities){
        List<NotificationDto> dtos = new ArrayList<>();

        for(Notification entity : entities){
            dtos.add(entity.toDto());
        }
        return dtos;
    }

}
