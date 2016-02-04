package fr.univrouen.pollen.dto.polling;

import fr.univrouen.pollen.domain.polling.Answer;
import fr.univrouen.pollen.domain.polling.Question;
import fr.univrouen.pollen.dto.Dto;

import java.util.List;

/**
 * Created by thibault on 01/02/16.
 */
public class ProposedChoiceDto implements Dto {
    private long id;
    private String text;
    private boolean isUserSubmitted;
    private Question question;
    private List<Answer> answers;

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

    public boolean isUserSubmitted() {
        return isUserSubmitted;
    }

    public void setUserSubmitted(boolean isUserSubmitted) {
        this.isUserSubmitted = isUserSubmitted;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
