package fr.univrouen.pollen.domain.polling;

import fr.univrouen.pollen.domain.Identifiable;
import fr.univrouen.pollen.domain.social.User;
import fr.univrouen.pollen.dto.polling.CampaignDto;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * The campaign for a poll.
 */
@Entity
@Table
public class Campaign implements Serializable, Identifiable {

    //General
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "campaignId")
    private long id;
    @Column(nullable = false)
    private Timestamp startingAt;
    @Column(nullable = false)
    private Timestamp endingAt;
    private int votes;
    private int maxVotes;

    //Modality when closing campaign :
    // null : open
    // other : enum
    @Enumerated(EnumType.STRING)
    private CampaignClosingModality closingModality;


    //When we should create a new campaign
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CampaignRecurrence frequency;

    //Privacy and access
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ResultAvailability resultAvailability;    //Mode de disponibilité du résultat (quand et comment)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CampaignVisibility visibility;                //Visibility of the campagn

    @ManyToMany
    private List<User> allowedUsers;                    //Users that can view campaign (visibility == Targeted)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CampaignResultVisibility resultVisibility;  //Visibility of the rest

    @ManyToMany
    private List<User> allowedResultsUsers;                //Users that can view resultst (visibility == Targeted)

    @OneToMany
    private List<Answer> answers;

    @OneToMany
    private List<PollNotification> pollNotifications;

    public List<PollNotification> getPollNotifications() {
        return pollNotifications;
    }

    public void setPollNotifications(List<PollNotification> pollNotifications) {
        this.pollNotifications = pollNotifications;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void closeCampaign(CampaignClosingModality modality) {
        this.closingModality = modality;
    }

    public void addComment(Comment comment) {
    }

    public void deleteComment(int commentId) {
    }

    /**
     * Indicates whether a campaign is in progress (if the current date
     * is included between the start date of the campaign and its end date).
     *
     * @return boolean
     */
    public boolean isProcessing() {
        if (startingAt == null || endingAt == null) {
            return false;
        }
        long actualTime = new Date().getTime();
        return actualTime >= startingAt.getTime()
                && actualTime < endingAt.getTime();
    }

    public Date getEndingAt() {
        return endingAt;
    }

    public Date getStartingAt() {
        return startingAt;
    }

    /**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id can not be negative or 0");
        }
		this.id = id;
	}
	/**
	 * @return the resultAvailability
	 */
	public ResultAvailability getResultAvailability() {
		return resultAvailability;
	}
	/**
	 * @param resultAvailability the resultAvailability to set
	 */
	public void setResultAvailability(ResultAvailability resultAvailability) {
        if (resultAvailability == null) {
            throw new IllegalArgumentException("resultAvailability can not be null");
        }
		this.resultAvailability = resultAvailability;
	}
	/**
	 * @return the allowedResultsUsers
	 */
	public List<User> getAllowedResultsUsers() {
		return allowedResultsUsers;
	}
	/**
	 * @param allowedResultsUsers the allowedResultsUsers to set
	 */
	public void setAllowedResultsUsers(List<User> allowedResultsUsers) {
		this.allowedResultsUsers = allowedResultsUsers;
	}
	/**
	 * @param startingAt the startingAt to set
	 */
	public void setStartingAt(Timestamp startingAt) {
		if (startingAt == null) {
            throw new IllegalArgumentException("startingat can not be null");
        }
        this.startingAt = startingAt;
	}
	/**
	 * @param endingAt the endingAt to set
	 */
	public void setEndingAt(Timestamp endingAt) {
        if (endingAt == null) {
            throw new IllegalArgumentException("endingAt can not be null");
        }
        this.endingAt = endingAt;
	}
	/**
     * Indicates whether the current campaign is included in another campaign.
     *
     * @param other Another campaign
     */
    public boolean isInclude(Campaign other) {
        long currentStart = startingAt.getTime();
        long otherStart = other.getStartingAt().getTime();
        long currentEnd = endingAt.getTime();
        long otherEnd = other.getEndingAt().getTime();
        return currentStart >= otherStart
                && currentStart < otherEnd
                && currentEnd > otherStart
                && currentEnd <= otherEnd;
    }


    /**
     * Indicates whether there are overlaps between the campaigns of the list provided.
     *
     * @param campaigns Une liste de campagnes
     * @return true si deux campagnes se chevauchent, false sinon
     */
    public static boolean campaignsOverlap(List<Campaign> campaigns) {
        // Pour chaque campagne
        for (Campaign campaign : campaigns) {
            // On regarde chaque campagne
            for (Campaign c : campaigns) {
                // Si les campagnes sont différentes
                if (campaign != c) {
                    long campaignStart = campaign.getStartingAt().getTime();
                    long cStart = c.getStartingAt().getTime();
                    long campaignEnd = campaign.getEndingAt().getTime();
                    long cEnd = c.getEndingAt().getTime();
                    // Si la date de début de la première campagne est incluse dans la seconde campagne
                    if (campaignStart >= cStart && campaignStart <= cEnd) {
                        return true;
                    }
                    // Si la date de fin de la première campagne est incluse dans la seconde campagne
                    if (campaignEnd >= cStart && campaignEnd <= cEnd) {
                        return true;
                    }
                    // Si la première campagn est incluse dans la seconde
                    if (campaign.isInclude(c)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public CampaignClosingModality getClosingModality() {
        return closingModality;
    }

    public void setClosingModality(CampaignClosingModality closingModality) {
        this.closingModality = closingModality;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        if (votes < 0) {
            throw new IllegalArgumentException("Votes can not be negative");
        }
        this.votes = votes;
    }

    public int getMaxVotes() {
        return maxVotes;
    }

    public void setMaxVotes(int maxVotes) {
        if (maxVotes <= 0) {
            throw new IllegalArgumentException("maxVotes can not be negative");
        }
        this.maxVotes = maxVotes;
    }

    public CampaignRecurrence getFrequency() {
        return frequency;
    }

    public void setFrequency(CampaignRecurrence frequency) {
        throwExceptionIfCampaignProcessing();
        if (frequency == null) {
            throw new IllegalArgumentException("frequency can not be null");
        }
        this.frequency = frequency;
    }

    private void throwExceptionIfCampaignProcessing() {
        if (isProcessing()) {
            throw new IllegalArgumentException("A campaign is processing.");
        }
    }

    public CampaignVisibility getVisibility() {
        return visibility;
    }

    public void setVisibility(CampaignVisibility visibility) {
        if (visibility == null) {
            throw new IllegalArgumentException("visibility can not be null");
        }
        this.visibility = visibility;
    }

    public CampaignResultVisibility getResultVisibility() {
        return resultVisibility;
    }

    public void setResultVisibility(CampaignResultVisibility resultVisibility) {
        if (resultVisibility == null) {
            throw new IllegalArgumentException("resultVisibility can not be null");
        }
        this.resultVisibility = resultVisibility;
    }

    public List<User> getAllowedUsers() {
        return allowedUsers;
    }

    public void setAllowedUsers(List<User> allowedUsers) {
        if (allowedUsers == null) {
            throw new IllegalArgumentException("allowedUsers can not be null");
        }
        this.allowedUsers = allowedUsers;
    }

    public CampaignDto toDto() {
        CampaignDto campaignDto = new CampaignDto();

        campaignDto.setId(id);
        campaignDto.setAllowedResultsUsers(allowedResultsUsers);
        campaignDto.setAllowedUsers(allowedUsers);
        campaignDto.setClosingModality(closingModality);
        campaignDto.setEndingAt(endingAt);
        campaignDto.setFrequency(frequency);
        campaignDto.setMaxVotes(maxVotes);
        campaignDto.setResultAvailability(resultAvailability);
        campaignDto.setResultVisibility(resultVisibility);
        campaignDto.setStartingAt(startingAt);
        campaignDto.setVisibility(visibility);
        campaignDto.setVotes(votes);

        return campaignDto;
    }
}
