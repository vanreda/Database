package fr.univrouen.pollen.domain.social;
/*
This is a list of Hobbies. This list can be completed with a lot of things.
It's easy to update.
 */
public enum Hobbies {
    READ("Lecture"),
    PLAY_VIDEO_GAMES("Jouer au jeux vidéos"),
    PLAY_CHESS("Jouer aux echecs"),
    PLAY_BOARD_GAME("Jouer au jeu de plateau"),
    PAINTING("Peindre"),
    PHOTOGRAPHY("Faire des photos"),
    DANCING("Dancer"),
    SINGING("Chanter"),
    DRAWING("Dessiner"),
    SCULPTING("Sculpter"),
    COOKING("Cuisiner"),
    COLLECTING("Collectionner"),
    SPORT("Faire du sport"),
    CINEMA("Aller au Cinema"),
    THEATER("Aller au theatre"),
    CONCERT("Aller a des concerts"),
    DECORATE("Decorer"),
    POTTERY("Faire de la poterie"),
    LISTEN_MUSIC("Ecouter de la musique"),
    PLAY_MUSIC("Jouer de la musique"),
    GARDEN("Jardiner"),
    TRAVEL("Voyager"),
    TELEVISION("Regarder la tele"),
    TINKER("Bricoler"),
    TOURISM("Faire du tourisme");


    private String text;

    Hobbies(String text) {
        this.text = text;
    }

}