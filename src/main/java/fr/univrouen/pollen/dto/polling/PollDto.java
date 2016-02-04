package fr.univrouen.pollen.dto.polling;

import fr.univrouen.pollen.domain.polling.Campaign;
import fr.univrouen.pollen.domain.polling.ClassificationCategory;
import fr.univrouen.pollen.domain.polling.Comment;
import fr.univrouen.pollen.domain.polling.Question;
import fr.univrouen.pollen.domain.social.User;
import fr.univrouen.pollen.domain.uploads.Media;
import fr.univrouen.pollen.dto.Dto;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;


public class PollDto implements Dto {

    private long id;
    @NotNull
    private String title;
    @NotNull
    private String description;
    //Dates
    @NotNull
    private Timestamp createdAt;
    @NotNull
    private Timestamp updatedAt;
    //Medias
    private String website;
    private Media logo;
    private Media media;
    private List<Campaign> campaigns;
    private List<Question> questions;
    @NotNull
    private User author;
    private boolean allowComment;   //Allow commenting or not of a question
    private List<Comment> comments; //List of comments
    @NotNull
    private ClassificationCategory classification = ClassificationCategory.UNDEFINED;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Media getLogo() {
        return logo;
    }

    public void setLogo(Media logo) {
        this.logo = logo;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public boolean isAllowComment() {
        return allowComment;
    }

    public void setAllowComment(boolean allowComment) {
        this.allowComment = allowComment;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public ClassificationCategory getClassification() {
        return classification;
    }

    public void setClassification(ClassificationCategory classification) {
        this.classification = classification;
    }
}
