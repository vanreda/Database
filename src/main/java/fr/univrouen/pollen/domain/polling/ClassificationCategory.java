package fr.univrouen.pollen.domain.polling;

public enum ClassificationCategory {
    UNDEFINED("non definie"),
    OTHER("autre"),
    CINEMA("cinema"),
    COOKING("cuisine"),
    ENVIRONMENT("environnement"),
    HEALTH("sante"),
    MUSIC("musique"),
    POLITIC("politique"),
    SCIENCES("sciences"),
    SPORT("sport");

    private String catName;

    private ClassificationCategory(String cat) {
        catName = cat;
    }

    public static ClassificationCategory getByCat(String cat) {
        for(ClassificationCategory c : values()) {
            if (c.catName.equals(cat)) {
                return c;
            }
        }
        return UNDEFINED;
    }
    
    public String getCatName() {
    	return catName;
    }
}
