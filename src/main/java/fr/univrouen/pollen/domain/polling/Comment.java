package fr.univrouen.pollen.domain.polling;

import fr.univrouen.pollen.domain.Identifiable;
import fr.univrouen.pollen.domain.social.User;
import fr.univrouen.pollen.dto.polling.CommentDto;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table
public class Comment implements Identifiable, Serializable {

    //General
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentId")
    private long id;
    @Column(nullable = false)
    private Timestamp postedAt;
    @Column(nullable = false)
    private Timestamp updatedAt;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String commentText;

    //Links
    @JoinColumn(nullable = false)
    @ManyToOne
    private User author;
    @ManyToOne
    private Poll poll;
    @ManyToOne
    private Question question;
    @ManyToOne
    private Answer answer;


    public Comment() {
        updatedAt = new Timestamp(new Date().getTime());
    }


    public Comment(User author, String commentText) {
        this();
        if (author == null || commentText == null) {
            throw new IllegalArgumentException("Author and comment should not be null.");
        }
        this.author = author;
        this.commentText = commentText;
        postedAt = new Timestamp(new Date().getTime());
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
        if (postedAt == null) {
            throw new IllegalArgumentException("Date should not be null.");
        }
        this.postedAt = postedAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        if (updatedAt == null) {
            throw new IllegalArgumentException("Date should not be null.");
        }
        this.updatedAt = updatedAt;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        if (commentText == null) {
            throw new IllegalArgumentException("Comment should not be null.");
        }
        this.commentText = commentText;
        updatedAt = new Timestamp(new Date().getTime());
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        if (author == null) {
            throw new IllegalArgumentException("Author should not be null.");
        }
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

    public CommentDto toDto() {
        CommentDto dto = new CommentDto();
        dto.setAuthor(author);
        dto.setUpdatedAt(updatedAt);
        dto.setAnswer(answer);
        dto.setCommentText(commentText);
        dto.setId(id);
        dto.setPoll(poll);
        dto.setPostedAt(postedAt);
        dto.setQuestion(question);
        return dto;
    }
}
