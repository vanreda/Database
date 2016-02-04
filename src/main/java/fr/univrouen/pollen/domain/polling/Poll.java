package fr.univrouen.pollen.domain.polling;

import fr.univrouen.pollen.domain.Identifiable;
import fr.univrouen.pollen.domain.social.User;
import fr.univrouen.pollen.domain.uploads.Media;
import fr.univrouen.pollen.dto.polling.PollDto;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Poll implements Serializable, Identifiable {
    public static final String PATTERN_WEBSITE = "^((http|https)://){1}(www[.])?([a-zA-Z0-9]|-)+([.][a-zA-Z0-9(-|/|=|?)?]+)+$";

    //public static final String PATTERN_WEBSITE = "^(https?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    //public static final String PATTERN_WEBSITE = "((https?):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";


    //General
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pollId")
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    //Dates
    @Column(nullable = false) // Think to modify at the creation of poll
    private Timestamp createdAt;
    @Column(nullable = false)
    private Timestamp updatedAt;

    //Medias
    private String website;
    @OneToOne
    private Media logo;
    @OneToOne
    private Media media;

    //Links to others data objects

    @OneToMany
    private List<Campaign> campaigns;




    //@JoinColumn(nullable = false)
    @ManyToOne
    private User author;

    //Commenting
    private boolean allowComment;   //Allow commenting or not of a question

    @OneToMany
    private List<Comment> comments; //List of comments

    @OneToMany
    private List<Question> questions;

    @ElementCollection
    @CollectionTable(joinColumns = @JoinColumn(name = "poll_id"))
    @Column(name = "keyword")
    private List<String> keywords;



    //Analyse
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ClassificationCategory classification = ClassificationCategory.UNDEFINED;

    public Poll(User author) {
        if (author == null) {
            throw new IllegalArgumentException("Author can't be null");
        }
        this.author = author;
        title = "";
        description = "";
        createdAt = new Timestamp(new Date().getTime());
        updatedAt = new Timestamp(new Date().getTime());
    }
    public Poll() {
        title = "";
        description = "";
        createdAt = new Timestamp(new Date().getTime());
        updatedAt = new Timestamp(new Date().getTime());
    }

    public long getId() { return id; }
    public void setId(long id) {
        throwExceptionIfCampaignProcessing();
        if (id <= 0) {
            throw new IllegalArgumentException("Id can not be negative or 0");
        }
        this.id = id;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) {
        throwExceptionIfCampaignProcessing();
        if (title == null) {
            throw new IllegalArgumentException("Title shouldn't be null.");
        }
        this.title = title;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        throwExceptionIfCampaignProcessing();
        if (description == null) {
            throw new IllegalArgumentException("Description shouldn't be null.");
        }
        this.description = description;
    }

    public boolean isAllowComment() { return allowComment; }
    public void setAllowComment(boolean allowComment) {
        throwExceptionIfCampaignProcessing();
        this.allowComment = allowComment;
    }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) {
        throwExceptionIfCampaignProcessing();
        long actualTime = new Date().getTime();
        if (createdAt == null || createdAt.compareTo(new Timestamp(actualTime)) > 1) {
            throw new IllegalArgumentException("Creation date shouldn't be null or in the future");
        }
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Timestamp updatedAt) {
        throwExceptionIfCampaignProcessing();
        long actualTime = new Date().getTime();
        if (updatedAt == null || updatedAt.compareTo(new Timestamp(actualTime)) > 1) {
            throw new IllegalArgumentException("Update date shouldn't be null or in the future");
        }
        this.updatedAt = updatedAt;
    }

    public String getWebsite() { return website; }

    /**
     *  Update the website address of the poll. This value can
     * be null because this parameter is optional.
     * @param website The website or null
     */
    public void setWebsite(String website) {
        throwExceptionIfCampaignProcessing();
        if (website != null) {
            Pattern patt = Pattern.compile(PATTERN_WEBSITE);
            Matcher matcher = patt.matcher(website);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("Website URL should be correct to the pattern.");
            }
        }
        this.website = website;
    }

    public Media getLogo() { return logo; }

    /**
     * The optional logo of the poll.
     */
    public void setLogo(Media logo) {
        throwExceptionIfCampaignProcessing();
        this.logo = logo;
    }

    public Media getMedia() { return media; }

    /**
     * The optional multimedia element of the poll.
     */
    public void setMedia(Media media) {
        throwExceptionIfCampaignProcessing();
        this.media = media;
    }


    public List<Campaign> getCampaigns() { return campaigns; }

    /**
     *  Mets à jour les campagnes du sondage. Les campagnes passées en arguement
     * ne doivent pas se chevaucher et le sondage ne doit pas avoir de campagne en
     * cours.
     * @param campaigns Les nouvelles campagnes
     */
    //vérifier les ids de la liste
    public void setCampaigns(List<Campaign> campaigns) {
        throwExceptionIfCampaignProcessing();
        if (hasProcessingCampaign()) {
            throw new IllegalArgumentException(
                    "Can't set campaigns when a campaign is processing.");
        }
        if (Campaign.campaignsOverlap(campaigns)) {
            throw new IllegalArgumentException("Campaigns shouldn't overlap.");
        }

        this.campaigns = campaigns;
    }

    public List<Question> getQuestions() { return questions; }

    //vérifier les ids de la liste
    public void setQuestions(List<Question> questions) {
        throwExceptionIfCampaignProcessing();

        List<Long> ltest = new ArrayList<Long>();
        for (int i = 0; i < questions.size(); i++) {
            if (ltest.contains(questions.get(i).getId())) {
                throw new IllegalArgumentException("two questions can not have the same id");
            }
            ltest.add(questions.get(i).getId());
        }

        this.questions = questions;
    }

    public List<Comment> getComments() { return comments; }

    //vérifier les ids de la liste
    public void setComments(List<Comment> comments) {
        throwExceptionIfCampaignProcessing();
        List<Long> ltest = new ArrayList<Long>();
        for (int i = 0; i < comments.size(); i++) {
            if (ltest.contains(comments.get(i).getId())) {
                throw new IllegalArgumentException("two questions can not have the same id");
            }
            ltest.add(comments.get(i).getId());
        }
        this.comments = comments;
    }

    public ClassificationCategory getClassification() { return classification; }
    public void setClassification(ClassificationCategory classification) {
        throwExceptionIfCampaignProcessing();
        this.classification = classification;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        throwExceptionIfCampaignProcessing();
        this.author = author;
    }

    public static String getPatternWebsite() {
        return PATTERN_WEBSITE;
    }

    /**
     * Indique si le sondage possède une campagne qui est en cours.
     */
    public boolean hasProcessingCampaign() {
       if (campaigns == null) return false;
        for (Campaign c : campaigns) {
            if (c.isProcessing()) {
                return true;
            }
        }
        return false;
    }

    public List<String> getKeywords() {
        return keywords;
    }
    public void setKeywords(List<String> keywords) {
        if (keywords == null) {
            throw new IllegalArgumentException("The keywords list should not be null.");
        }
        throwExceptionIfCampaignProcessing();
        this.keywords = keywords;
    }
    public boolean addKeyword(String keyword) {
        if (keyword == null) {
            throw new IllegalArgumentException("The keyword should not be null.");
        }
        throwExceptionIfCampaignProcessing();
        return keywords.add(keyword);
    }
    public boolean removeKeyword(String keyword) {
        if (keyword == null) {
            throw new IllegalArgumentException("The keyword should not be null.");
        }
        throwExceptionIfCampaignProcessing();
        return keywords.remove(keyword);
    }

    private void throwExceptionIfCampaignProcessing() {
        if (hasProcessingCampaign()) {
            throw new IllegalArgumentException("A campaign is processing.");
        }
    }

    public PollDto toDto() {
        PollDto dto = new PollDto();
        dto.setAllowComment(allowComment);
        dto.setAuthor(author);
        dto.setCampaigns(campaigns);
        dto.setClassification(classification);
        dto.setComments(comments);
        dto.setCreatedAt(createdAt);
        dto.setDescription(description);
        dto.setId(id);
        dto.setLogo(logo);
        dto.setMedia(media);
        dto.setQuestions(questions);
        dto.setTitle(title);
        dto.setUpdatedAt(updatedAt);
        dto.setWebsite(website);

        return dto;
    }
}
