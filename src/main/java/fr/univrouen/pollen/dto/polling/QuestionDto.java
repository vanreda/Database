package fr.univrouen.pollen.dto.polling;

import fr.univrouen.pollen.domain.polling.*;
import fr.univrouen.pollen.domain.uploads.Media;
import fr.univrouen.pollen.dto.Dto;

import java.util.List;


public class QuestionDto implements Dto {

    private long id;
    private String text;
    private Media media;
    private QuestionType type;
    private List<Comment> comments;
    private int orderNumber;
    private List<Answer> answers;
    private Poll poll;
    private boolean allowNoAnswer;
    private boolean allowAddAnswer;
    private List<ProposedChoice> proposedChoices;
    private List<QuestionCondition> conditions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public boolean isAllowNoAnswer() {
        return allowNoAnswer;
    }

    public void setAllowNoAnswer(boolean allowNoAnswer) {
        this.allowNoAnswer = allowNoAnswer;
    }

    public boolean isAllowAddAnswer() {
        return allowAddAnswer;
    }

    public void setAllowAddAnswer(boolean allowAddAnswer) {
        this.allowAddAnswer = allowAddAnswer;
    }

    public List<ProposedChoice> getProposedChoices() {
        return proposedChoices;
    }

    public void setProposedChoices(List<ProposedChoice> proposedChoices) {
        this.proposedChoices = proposedChoices;
    }

    public List<QuestionCondition> getConditions() {
        return conditions;
    }

    public void setConditions(List<QuestionCondition> conditions) {
        this.conditions = conditions;
    }
}
