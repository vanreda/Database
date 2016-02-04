package fr.univrouen.pollen.domain.polling;

import fr.univrouen.pollen.domain.social.Notification;
import fr.univrouen.pollen.dto.polling.PollNotificationDto;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table
public class PollNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pollNotificationId")
    private long id;

    @ManyToOne
    private Campaign campaigns;

    public Notification notifyInvitation(int idPoll, int idUser) {
        return null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Campaign getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(Campaign campaigns) {
        this.campaigns = campaigns;
    }

    public PollNotificationDto toDto() {
        PollNotificationDto pollNotificationDto = new PollNotificationDto();

        pollNotificationDto.setCampaigns(campaigns);
        pollNotificationDto.setId(id);

        return pollNotificationDto;
    }
}
