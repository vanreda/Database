package fr.univrouen.pollen.domain.polling;

public enum QuestionType {
    SIMPLE_CHOICE,      //One inside proposed choices
    MULTIPLE_CHOICE,    //Many inside proposed choice
    ORDERED_CHOICE,     //Order between proposed choices
    FREE_ANSWER         //Answer as we go
}
