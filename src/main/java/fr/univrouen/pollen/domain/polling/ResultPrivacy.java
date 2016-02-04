package fr.univrouen.pollen.domain.polling;

public enum ResultPrivacy {
    PUBLIC,     //Tout le monde peut voir le résultat
    FROM_LIST,  //Tous les utilisateurs d'un liste peuvent voir le résultat
    PRIVATE     //Seulement le créateur peut voir le résultat
}
