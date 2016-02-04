package fr.univrouen.pollen.dto.social;

import fr.univrouen.pollen.domain.social.*;
import fr.univrouen.pollen.dto.Dto;
import fr.univrouen.pollen.dto.upload.MediaDto;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

public class UserDto implements Dto {

    //General
    @NotNull
    private long id;
    @NotNull
    private String username;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;

    @NotNull
    private String email;
    @NotNull
    private Date birthday;
    @NotNull
    private MaritalStatus maritalStatus;
    @NotNull
    private Civility civility;

    //Medias
    private MediaDto profilePicture;

    //classification
    private SocialProfessionalCategory socioProfessionalCategory;
    private List<Profession> detailedProfession;
    private List<Hobbies> hobbies;
    private Location location;

    //Roles and access
    private boolean isBanned;
    private boolean isAdmin;
    private AccountVisibility visibility;

    //Social
    private List<Long> followersId;
    private List<Long> followingId;
    private List<NotificationDto> notifications;
    private List<FollowingRequestDto> followingRequests;

    //Links
    //TODO replace entities by DTOs
    //private List<Answer> answers;
    //private List<Poll> polls;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Civility getCivility() {
        return civility;
    }

    public void setCivility(Civility civility) {
        this.civility = civility;
    }

    public MediaDto getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(MediaDto profilePicture) {
        this.profilePicture = profilePicture;
    }

    public SocialProfessionalCategory getSocioProfessionalCategory() {
        return socioProfessionalCategory;
    }

    public void setSocioProfessionalCategory(SocialProfessionalCategory socioProfessionalCategory) {
        this.socioProfessionalCategory = socioProfessionalCategory;
    }

    public List<Profession> getDetailedProfession() {
        return detailedProfession;
    }

    public void setDetailedProfession(List<Profession> detailedProfession) {
        this.detailedProfession = detailedProfession;
    }

    public List<Hobbies> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobbies> hobbies) {
        this.hobbies = hobbies;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public AccountVisibility getVisibility() {
        return visibility;
    }

    public void setVisibility(AccountVisibility visibility) {
        this.visibility = visibility;
    }

    public void setIsBanned(boolean isBanned) {
        this.isBanned = isBanned;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public List<Long> getFollowersId() {
        return followersId;
    }

    public void setFollowersId(List<Long> followersId) {
        this.followersId = followersId;
    }

    public List<Long> getFollowingId() {
        return followingId;
    }

    public void setFollowingId(List<Long> followingId) {
        this.followingId = followingId;
    }

    public List<NotificationDto> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationDto> notifications) {
        this.notifications = notifications;
    }

    public List<FollowingRequestDto> getFollowingRequests() {
        return followingRequests;
    }

    public void setFollowingRequests(List<FollowingRequestDto> followingRequests) {
        this.followingRequests = followingRequests;
    }
}
