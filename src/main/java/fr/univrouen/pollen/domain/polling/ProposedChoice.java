package fr.univrouen.pollen.domain.polling;

import fr.univrouen.pollen.domain.Identifiable;
import fr.univrouen.pollen.dto.polling.ProposedChoiceDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * A choice proposed by the poller or by another user to a given question
 */
@Entity
@Table
public class ProposedChoice implements Serializable, Identifiable {

    //General
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pollNotificationId")
    private long id;
    private String text;
    private boolean isUserSubmitted;

    //Links
    @ManyToOne
    private Question question;

    @ManyToMany
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

    public void setIsUserSubmitted(boolean isUserSubmitted) {
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

    public ProposedChoiceDto toDto() {
        ProposedChoiceDto proposedChoiceDto = new ProposedChoiceDto();

        proposedChoiceDto.setId(id);
        proposedChoiceDto.setQuestion(question);
        proposedChoiceDto.setAnswers(answers);
        proposedChoiceDto.setText(text);
        proposedChoiceDto.setUserSubmitted(isUserSubmitted);

        return proposedChoiceDto;
    }
}
