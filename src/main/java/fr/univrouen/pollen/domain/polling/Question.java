package fr.univrouen.pollen.domain.polling;

import fr.univrouen.pollen.domain.Identifiable;
import fr.univrouen.pollen.domain.uploads.Media;
import fr.univrouen.pollen.dto.polling.QuestionDto;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Question implements Serializable, Identifiable {

    //General
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionId")
    private long id;
    private String text;

    @OneToOne
    private Media media;

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    //Commenting
    @OneToMany
    private List<Comment> comments; //List of comments

    //Ordering
    private int orderNumber;

    //Answers to that question
    @OneToMany
    private List<Answer> answers;

    @ManyToOne
    //@JoinColumn(nullable = false)
    private Poll poll;

    //Answering options
    private boolean allowNoAnswer;    //Allow no answer (optionnal question)
    private boolean allowAddAnswer;    //Allow an user to add a proposed answer

    @OneToMany
    private List<ProposedChoice> proposedChoices;  //List of all proposed choices (including user's ones)

    @OneToMany
    private List<QuestionCondition> conditions; //Condition used when answered (used when only one answer is possible)

    public void addAnswers(Answer[] answers) {
        if (answers == null) {
            throw new IllegalArgumentException("answers can not be null");
        }
        List<Long> ltest = new ArrayList<Long>();
        for (int i = 0; i < answers.length; i++) {
            if (ltest.contains(answers[i].getId())) {
                throw new IllegalArgumentException("two answers can not have the same id");
            }
            ltest.add(answers[i].getId());
        }
        if (this.answers != null) {
            for (int i = 0; i < answers.length; i++) {
                for (int y = 0; y < this.answers.size(); y++) {
                    if (answers[i].getId() == this.answers.get(y).getId()) {
                        throw new IllegalArgumentException("there is already a answers in the Question with the same id");
                    }
                }
            }
        }
        if (this.answers == null) {
            this.answers = new ArrayList<Answer>();
        }
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == null) {
                throw new IllegalArgumentException("an answer can not be null");
            }
            this.answers.add(answers[i]);
        }
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id can not be negative or 0");
        }
        this.id = id;
    }

    /**
     * @return the allowNoAnswer
     */
    public boolean isAllowNoAnswer() {
        return allowNoAnswer;
    }

    /**
     * @param isOptionnal the allowNoAnswer to set
     */
    public void setAllowNoAnswer(boolean isOptionnal) {
        this.allowNoAnswer = isOptionnal;
    }

    /**
     * @return the type
     */
    public QuestionType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(QuestionType type) {
        this.type = type;
    }

    /**
     * @return the orderNumber
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * @param orderNumber the orderNumber to set
     */
    public void setOrderNumber(int orderNumber) {
        if (orderNumber <= 0) {
            throw new IllegalArgumentException("order number can not be negative or 0");
        }
        this.orderNumber = orderNumber;
    }

    /**
     * @return the answers
     */
    public List<Answer> getAnswers() {
        return answers;
    }

    /**
     * @param answers the answers to set
     */
    //vérifier les ids
    public void setAnswers(List<Answer> answers) {
        List<Long> ltest = new ArrayList<Long>();
        for (int i = 0; i < answers.size(); i++) {
            if (ltest.contains(answers.get(i).getId())) {
                throw new IllegalArgumentException("two aswers can not have the same id");
            }
            ltest.add(answers.get(i).getId());
        }
        this.answers = answers;
    }

    /**
     * @return the proposedChoices
     */
    public List<ProposedChoice> getProposedChoices() {
        return proposedChoices;
    }

    /**
     * @param proposedChoices the proposedChoices to set
     */
    //vérifier les ids
    public void setProposedChoices(List<ProposedChoice> proposedChoices) {
        List<Long> ltest = new ArrayList<Long>();
        for (int i = 0; i < proposedChoices.size(); i++) {
            if (ltest.contains(proposedChoices.get(i).getId())) {
                throw new IllegalArgumentException("two choices can not have the same id");
            }
            ltest.add(proposedChoices.get(i).getId());
        }
        this.proposedChoices = proposedChoices;
    }

    /**
     * @return the conditions
     */
    public List<QuestionCondition> getConditions() {
        return conditions;
    }

    /**
     * @param conditions the conditions to set
     */
    //vérifier les ids
    public void setConditions(List<QuestionCondition> conditions) {
        List<Long> ltest = new ArrayList<Long>();
        for (int i = 0; i < conditions.size(); i++) {
            if (ltest.contains(conditions.get(i).getId())) {
                throw new IllegalArgumentException("two conditions can not have the same id");
            }
            ltest.add(conditions.get(i).getId());
        }
        this.conditions = conditions;
    }

    public void deleteAnswer(int answerId) {
        if (answerId <= 0) {
            throw new IllegalArgumentException("answerId can not be negative or 0");
        }
        if (this.answers != null) {
            for (int i = 0; i < this.answers.size(); i++) {
                if (this.answers.get(i).getId() == i) {
                    this.answers.remove(i);
                }
            }
        }
    }

    public void addProposedChoices(ProposedChoice[] proposedChoices) {
        if (proposedChoices == null) {
            throw new IllegalArgumentException("proposedChoice Id can not be null");
        }
        List<Long> ltest = new ArrayList<Long>();
        for (int i = 0; i < proposedChoices.length; i++) {
            if (ltest.contains(proposedChoices[i].getId())) {
                throw new IllegalArgumentException("two proposedChoice can not have the same id");
            }
            ltest.add(proposedChoices[i].getId());
        }
        if (this.proposedChoices != null) {
            for (int i = 0; i < proposedChoices.length; i++) {
                for (int y = 0; y < this.proposedChoices.size(); y++) {
                    if (proposedChoices[i].getId() == this.proposedChoices.get(y).getId()) {
                        throw new IllegalArgumentException("there is already a proposedChoise in the Question with the same id");
                    }
                }
            }
        }
        if (this.proposedChoices == null) {
            this.proposedChoices = new ArrayList<ProposedChoice>();
        }
        for (int i = 0; i < proposedChoices.length; i++) {
            this.proposedChoices.add(proposedChoices[i]);
        }
    }

    public void deleteProposedChoice(int proposedChoiceId) {
        if (proposedChoiceId <= 0) {
            throw new IllegalArgumentException("proposedChoiceId can not be null");
        }
        if (this.proposedChoices != null) {
            for (int i = 0; i < proposedChoices.size(); i++) {
                if (proposedChoices.get(i).getId() == proposedChoiceId) {
                    proposedChoices.remove(i);
                }
            }
        }
    }


    public void addComment(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException("comment can not be null");
        }
        if (comment != null) {
            for (int i = 0; i < comments.size(); i++) {
                if (comments.get(i).getId() == comment.getId()) {
                    throw new IllegalArgumentException("there is already a comment with the same id in Question");
                }
            }
        } else {
            comments = new ArrayList<Comment>();
            comments.add(comment);
        }


    }

    public void deleteComment(int commentId) {
        if (commentId <= 0) {
            throw new IllegalArgumentException("commentId can not be null");
        }
        if (this.comments != null) {
            for (int i = 0; i < comments.size(); i++) {
                if (comments.get(i).getId() == commentId) {
                    comments.remove(i);
                }
            }
        }
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

    public boolean isAllowAddAnswer() {
        return allowAddAnswer;
    }

    public void setAllowAddAnswer(boolean allowAddAnswer) {
        this.allowAddAnswer = allowAddAnswer;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public List<Comment> getComments() {
        return comments;
    }

    //vérifier les ids
    public void setComments(List<Comment> comments) {
        List<Long> ltest = new ArrayList<Long>();
        for (int i = 0; i < comments.size(); i++) {
            if (ltest.contains(comments.get(i).getId())) {
                throw new IllegalArgumentException("two comments can not have the same id");
            }
            ltest.add(comments.get(i).getId());
        }
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        return id == question.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    public QuestionDto toDto() {
        QuestionDto dto = new QuestionDto();
        dto.setPoll(poll);
        dto.setId(id);
        dto.setMedia(media);
        dto.setAllowAddAnswer(allowAddAnswer);
        dto.setAllowNoAnswer(allowNoAnswer);
        dto.setAnswers(answers);
        dto.setComments(comments);
        dto.setConditions(conditions);
        dto.setOrderNumber(orderNumber);
        dto.setText(text);
        dto.setType(type);
        dto.setProposedChoices(proposedChoices);
        return dto;
    }
}
