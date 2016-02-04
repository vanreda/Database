package fr.univrouen.pollen.dto.polling;

import fr.univrouen.pollen.domain.polling.ProposedChoice;
import fr.univrouen.pollen.domain.polling.Question;
import fr.univrouen.pollen.domain.polling.QuestionConditionType;
import fr.univrouen.pollen.dto.Dto;

import javax.persistence.*;


public class QuestionConditionDto implements Dto {
    private long id;
    private Question conditionQuestion;
    private ProposedChoice conditionChoice;
    private QuestionConditionType type;
    private Question nextQuestion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Question getConditionQuestion() {
        return conditionQuestion;
    }

    public void setConditionQuestion(Question conditionQuestion) {
        this.conditionQuestion = conditionQuestion;
    }

    public ProposedChoice getConditionChoice() {
        return conditionChoice;
    }

    public void setConditionChoice(ProposedChoice conditionChoice) {
        this.conditionChoice = conditionChoice;
    }

    public QuestionConditionType getType() {
        return type;
    }

    public void setType(QuestionConditionType type) {
        this.type = type;
    }

    public Question getNextQuestion() {
        return nextQuestion;
    }

    public void setNextQuestion(Question nextQuestion) {
        this.nextQuestion = nextQuestion;
    }
}
