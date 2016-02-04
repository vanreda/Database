package fr.univrouen.pollen.dto.polling;

import fr.univrouen.pollen.domain.analyse.Polarity;
import fr.univrouen.pollen.domain.polling.Campaign;
import fr.univrouen.pollen.domain.polling.Comment;
import fr.univrouen.pollen.domain.polling.ProposedChoice;
import fr.univrouen.pollen.domain.polling.Question;
import fr.univrouen.pollen.domain.social.User;
import fr.univrouen.pollen.domain.uploads.Media;
import fr.univrouen.pollen.dto.Dto;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by thibault on 01/02/16.
 */
public class AnswerDto implements Dto {
    private long id;
    @NotNull
    private Timestamp postedAt;
    @NotNull
    private Timestamp updatedAt;
    @NotNull
    private Campaign campaign;
    @NotNull
    private Question question;
    @NotNull
    private User user;
    private List<Comment> comments;
    private String text;
    private Media media;
    private List<ProposedChoice> choices;
    private Polarity polarity;

    public List<ProposedChoice> getChoices() {
        return choices;
    }

    public void setChoices(List<ProposedChoice> choices) {
        this.choices = choices;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Polarity getPolarity() {
        return polarity;
    }

    public void setPolarity(Polarity polarity) {
        this.polarity = polarity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Timestamp postedAt) {
        this.postedAt = postedAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
