package fr.univrouen.pollen.dto.filter;
import fr.univrouen.pollen.domain.social.*;
import fr.univrouen.pollen.dto.Dto;

public class UserFilter implements Dto {


    private long idFilter;

    private MaritalStatus maritalStatus;

    //For age interval
    private int beginAge;

    private int endAge;

    //classification
    private SocialProfessionalCategory socioProfessionalCategory;
    private Profession detailedProfession;
    private Hobbies hobbies;
    private Location location;

    public long getIdFilter() {
        return idFilter;
    }

    public void setIdFilter(long idFilter) {
        this.idFilter = idFilter;
    }

    public int getBeginAge() {
        return beginAge;
    }

    public void setBeginAge(int beginAge) {
        this.beginAge = beginAge;
    }

    public int getEndAge() {
        return endAge;
    }

    public void setEndAge(int endAge) {
        this.endAge = endAge;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public SocialProfessionalCategory getSocioProfessionalCategory() {
        return socioProfessionalCategory;
    }

    public void setSocioProfessionalCategory(SocialProfessionalCategory socioProfessionalCategory) {
        this.socioProfessionalCategory = socioProfessionalCategory;
    }

    public Profession getDetailedProfession() {
        return detailedProfession;
    }

    public void setDetailedProfession(Profession detailedProfession) {
        this.detailedProfession = detailedProfession;
    }

    public Hobbies getHobbies() {
        return hobbies;
    }

    public void setHobbies(Hobbies hobbies) {
        this.hobbies = hobbies;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
