package fr.univrouen.pollen.domain;

import java.io.Serializable;

public interface Identifiable extends Serializable {

    long getId();
    void setId(long id);

}
