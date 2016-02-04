package fr.univrouen.pollen.dto.polling;

import fr.univrouen.pollen.domain.polling.*;
import fr.univrouen.pollen.domain.social.User;
import fr.univrouen.pollen.dto.Dto;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by thibault on 01/02/16.
 */
public class CampaignDto implements Dto {
    private long id;
    @NotNull
    private Timestamp startingAt;
    @NotNull
    private Timestamp endingAt;
    private int votes;
    private int maxVotes;
    @NotNull
    private CampaignClosingModality closingModality;
    @NotNull
    private CampaignRecurrence frequency;
    private ResultAvailability resultAvailability;
    @NotNull
    private CampaignVisibility visibility;
    private List<User> allowedUsers;
    @NotNull
    private CampaignResultVisibility resultVisibility;
    private List<User> allowedResultsUsers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getStartingAt() {
        return startingAt;
    }

    public void setStartingAt(Timestamp startingAt) {
        this.startingAt = startingAt;
    }

    public Timestamp getEndingAt() {
        return endingAt;
    }

    public void setEndingAt(Timestamp endingAt) {
        this.endingAt = endingAt;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public int getMaxVotes() {
        return maxVotes;
    }

    public void setMaxVotes(int maxVotes) {
        this.maxVotes = maxVotes;
    }

    public CampaignClosingModality getClosingModality() {
        return closingModality;
    }

    public void setClosingModality(CampaignClosingModality closingModality) {
        this.closingModality = closingModality;
    }

    public CampaignRecurrence getFrequency() {
        return frequency;
    }

    public void setFrequency(CampaignRecurrence frequency) {
        this.frequency = frequency;
    }

    public ResultAvailability getResultAvailability() {
        return resultAvailability;
    }

    public void setResultAvailability(ResultAvailability resultAvailability) {
        this.resultAvailability = resultAvailability;
    }

    public CampaignVisibility getVisibility() {
        return visibility;
    }

    public void setVisibility(CampaignVisibility visibility) {
        this.visibility = visibility;
    }

    public List<User> getAllowedUsers() {
        return allowedUsers;
    }

    public void setAllowedUsers(List<User> allowedUsers) {
        this.allowedUsers = allowedUsers;
    }

    public CampaignResultVisibility getResultVisibility() {
        return resultVisibility;
    }

    public void setResultVisibility(CampaignResultVisibility resultVisibility) {
        this.resultVisibility = resultVisibility;
    }

    public List<User> getAllowedResultsUsers() {
        return allowedResultsUsers;
    }

    public void setAllowedResultsUsers(List<User> allowedResultsUsers) {
        this.allowedResultsUsers = allowedResultsUsers;
    }
}
