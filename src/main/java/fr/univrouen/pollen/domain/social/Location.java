package fr.univrouen.pollen.domain.social;

import fr.univrouen.pollen.domain.Identifiable;

import javax.persistence.*;

@Entity
@Table
public class Location implements Identifiable {

    // ATTRIBUTES

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="locationId")
    private long id;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    private String state;

    @Column(nullable = false)
    private int zipcode;


    // GETTERS & SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}
