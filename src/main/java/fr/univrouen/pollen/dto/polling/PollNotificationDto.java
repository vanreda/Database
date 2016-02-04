package fr.univrouen.pollen.dto.polling;

import fr.univrouen.pollen.domain.polling.Campaign;
import fr.univrouen.pollen.dto.Dto;

/**
 * Created by thibault on 01/02/16.
 */
public class PollNotificationDto implements Dto {
    private long id;
    private Campaign campaigns;

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
}
