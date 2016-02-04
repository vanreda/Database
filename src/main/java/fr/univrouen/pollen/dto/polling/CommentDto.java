package fr.univrouen.pollen.dto.polling;

import fr.univrouen.pollen.domain.polling.Answer;
import fr.univrouen.pollen.domain.polling.Poll;
import fr.univrouen.pollen.domain.polling.Question;
import fr.univrouen.pollen.domain.social.User;
import fr.univrouen.pollen.dto.Dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * Created by ludovic on 01/02/16.
 */
public class CommentDto implements Dto {
    private long id;
    @NotNull
    private Timestamp postedAt;
    @NotNull
    private Timestamp updatedAt;
    @NotNull
    private String commentText;
    private User author;
    private Poll poll;
    private Question question;
    private Answer answer;

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

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
