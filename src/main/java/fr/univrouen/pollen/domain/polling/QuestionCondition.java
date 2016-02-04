package fr.univrouen.pollen.domain.polling;

import fr.univrouen.pollen.domain.Identifiable;
import fr.univrouen.pollen.dto.polling.QuestionConditionDto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class QuestionCondition implements Serializable, Identifiable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionConditionId")
    private long id;

    @OneToOne
    private Question conditionQuestion;

    @OneToOne
    private ProposedChoice conditionChoice;

    @Enumerated(EnumType.STRING)
    private QuestionConditionType type;

    @OneToOne
    private Question nextQuestion;

    @ManyToOne
    private Question question;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

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

    public QuestionConditionDto toDto() {
        QuestionConditionDto dto = new QuestionConditionDto();
        dto.setConditionChoice(conditionChoice);
        dto.setConditionQuestion(conditionQuestion);
        dto.setId(id);
        dto.setNextQuestion(nextQuestion);
        dto.setType(type);
        return dto;
    }
}
