package fr.univrouen.pollen.domain.polling;

import fr.univrouen.pollen.domain.Identifiable;
import fr.univrouen.pollen.domain.analyse.Polarity;
import fr.univrouen.pollen.domain.social.User;
import fr.univrouen.pollen.domain.uploads.Media;
import fr.univrouen.pollen.dto.polling.AnswerDto;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table
public class Answer implements Serializable, Identifiable {

    // General
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answerId")
    private long id;

    // Dates
    //@Column(nullable = false)
    private Timestamp postedAt;
    //@Column(nullable = false)
    private Timestamp updatedAt;

    // Links
    @ManyToOne
    //@JoinColumn(nullable = false)
    private Campaign campaign;
    @ManyToOne
    //@JoinColumn(nullable = false)
    private Question question;
    @ManyToOne
    //@JoinColumn(nullable = false)
    private User user;

    //Commenting
    @OneToMany
    private List<Comment> comments;

    //Content
    private String text;                    //If question type free
    @OneToOne
    private Media media;                    //If question type free
    @ManyToMany
    private List<ProposedChoice> choices;    //List of selected choices (ordered, only one or not)

    // Analyse
    @Enumerated(EnumType.STRING)
    private Polarity polarity;


    /*public Answer() {
        comments = new LinkedList<Comment>();
        choices = new LinkedList<ProposedChoice>();
    }*/


    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    //TODO : test et throw
    public void setId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id can not be negative or 0");
        }
        this.id = id;
    }

    /**
     * @return the postedAt
     */
    public Timestamp getPostedAt() {
        return postedAt;
    }

    /**
     * @param postedAt the postedAt to set
     */
    //TODO : test
    public void setPostedAt(Timestamp postedAt) {
        if (postedAt == null) {
            throw new IllegalArgumentException("Date should not be null.");
        }
        this.postedAt = postedAt;
    }

    /**
     * @return the updatedAt
     */
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt the updatedAt to set
     */
    //TODO : test
    public void setUpdatedAt(Timestamp updatedAt) {
        if (updatedAt == null) {
            throw new IllegalArgumentException("Date should not be null.");
        }
        this.updatedAt = updatedAt;
    }

    /**
     * @return the media
     */
    public Media getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    //TODO : test
    public void setMedia(Media media) {
        this.media = media;
    }

    /**
     * @return the polarity
     */
    public Polarity getPolarity() {
        return polarity;
    }

    /**
     * @param polarity the polarity to set
     */
    //TODO : test et throw
    public void setPolarity(Polarity polarity) {
        this.polarity = polarity;
    }

    public Question getQuestion() {
        return question;
    }

    //TODO : test
    public void setQuestion(Question question) {
        if (question == null) {
            throw new IllegalArgumentException("Question should not be null.");
        }
        this.question = question;
    }

    public User getUser() {
        return user;
    }

    //TODO : test et throw
    public void setUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User should not be null.");
        }
        this.user = user;
    }

    public String getText() {
        return text;
    }

    //TODO : test et throw
    public void setText(String text) {
        this.text = text;
    }

    public List<ProposedChoice> getChoices() {
        return choices;
    }

    //TODO : test et throw
    public void setChoices(List<ProposedChoice> choices) {
        this.choices = choices;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    //TODO : test
    public void setCampaign(Campaign campaign) {
        if (campaign == null) {
            throw new IllegalArgumentException("Campaign should not be null.");
        }
        this.campaign = campaign;
    }

    public List<Comment> getComments() {
        return comments;
    }

    //TODO : test
    public void setComments(List<Comment> comments) {
        if (comments == null) {
            throw new IllegalArgumentException("The comments list should not be null.");
        }
        this.comments = comments;
    }

    //TODO : test
    public void addComment(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException("Comment should not be null.");
        }
        comments.add(comment);
    }

    //TODO : test
    public void deleteComment(long commentId) {
        for (Comment c : comments) {
            if (c.getId() == commentId) {
                comments.remove(c);
                return;
            }
        }
        throw new IllegalStateException("The answer don't contain the comment.");
    }


    public AnswerDto toDto() {
        AnswerDto answerDto = new AnswerDto();

        answerDto.setId(id);
        answerDto.setCampaign(campaign);
        answerDto.setChoices(choices);
        answerDto.setComments(comments);
        answerDto.setMedia(media);
        answerDto.setPolarity(polarity);
        answerDto.setPostedAt(postedAt);
        answerDto.setQuestion(question);
        answerDto.setText(text);
        answerDto.setUpdatedAt(updatedAt);
        answerDto.setUser(user);

        return answerDto;
    }
}
