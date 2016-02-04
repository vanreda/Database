package fr.univrouen.pollen.domain.social;


import fr.univrouen.pollen.domain.Identifiable;
import fr.univrouen.pollen.domain.polling.Answer;
import fr.univrouen.pollen.domain.polling.Campaign;
import fr.univrouen.pollen.domain.polling.Comment;
import fr.univrouen.pollen.domain.polling.Poll;
import fr.univrouen.pollen.domain.uploads.Media;
import fr.univrouen.pollen.dto.social.FollowingRequestDto;
import fr.univrouen.pollen.dto.social.NewUserDto;
import fr.univrouen.pollen.dto.social.NotificationDto;
import fr.univrouen.pollen.dto.social.UserDto;
import fr.univrouen.pollen.repositories.social.NotificationRepository;
import fr.univrouen.pollen.repositories.social.UserRepository;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="UserPollen")
public class User implements Identifiable {

    // ATTRIBUTES

    //General
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private long id;

    @Column(nullable = false)
    private String username;

    private String firstname;

    private String lastname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String reminderToken;

    private Date birthday;

    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Enumerated(EnumType.STRING)
    private Civility civility;

    //Dates
    private Timestamp lastConnectedAt;  //Ne pas mettre a null

    private Timestamp activityAt;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    //Medias
    @OneToOne
    private Media profilePicture;

    //classification
    @Enumerated(EnumType.STRING)
    private SocialProfessionalCategory socioProfessionalCategory;


    @ElementCollection(targetClass = Profession.class)
    private List<Profession> detailedProfession;

    @ElementCollection(targetClass = Hobbies.class)
    private List<Hobbies> hobbies;

    @ManyToOne
    @Cascade(value = {CascadeType.SAVE_UPDATE })
    private Location location;

    //Roles and access
    private boolean isBanned;
    private boolean isAdmin;

    private AccountVisibility visibility;

    //Social
    @ManyToMany
    private List<User> followers;

    @ManyToMany
    private List<User> following;

    @OneToMany
    private List<Notification> notifications;

    @OneToMany
    private List<FollowingRequest> followingRequests;

    //Links
    @OneToMany
    private List<Answer> answers;
    @OneToMany
    private List<Poll> polls;

    @ManyToMany
    private List<Campaign> campaigns;

    @OneToMany
    private List<Comment> comments;


    // Constructors
    public User() {
    }

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, String username){
        this(email, password);
        this.username = username;
    }

    public User(String email, String password, String username, String firstname, String lastname){
        this(email, password, username);
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public User(String email, String password, String username, String firstname, String lastname,
                Date birthday, MaritalStatus maritalStatus, Civility civility){
        this(email, password, username, firstname, lastname);
        this.birthday = birthday;
        this.maritalStatus = maritalStatus;
        this.civility = civility;
    }

    public User(String email, String password, String username, String firstname, String lastname,
                Date birthday, MaritalStatus maritalStatus, Civility civility, Media profilePicture,
                SocialProfessionalCategory socialProfessionalCategory, Location location,
                boolean isAdmin, AccountVisibility visibility){
        this(email, password, username, firstname, lastname, birthday, maritalStatus, civility);
        this.profilePicture = profilePicture;
        this.socioProfessionalCategory = socialProfessionalCategory;
        this.location = location;
        this.visibility = visibility;
        this.isAdmin = isAdmin;

    }

    public User(NewUserDto newUserDto) {
        username = newUserDto.getUsername();
        firstname = newUserDto.getFirstname();
        lastname = newUserDto.getLastname();
        email = newUserDto.getEmail();
        password = newUserDto.getPassword();
        birthday = newUserDto.getBirthday();
        maritalStatus = newUserDto.getMaritalStatus();
        civility = newUserDto.getCivility();
    }

    public User(UserDto userDto) {
        UserRepository userRepository = new UserRepository();
        NotificationRepository notificationRepository = new NotificationRepository();

        username = userDto.getUsername();
        firstname = userDto.getFirstname();
        lastname = userDto.getLastname();
        email = userDto.getEmail();
        birthday = userDto.getBirthday();
        maritalStatus = userDto.getMaritalStatus();
        civility = userDto.getCivility();
        profilePicture = new Media(userDto.getProfilePicture());
        socioProfessionalCategory = userDto.getSocioProfessionalCategory();
        detailedProfession = userDto.getDetailedProfession();
        hobbies = userDto.getHobbies();
        location = userDto.getLocation();
        isBanned = userDto.isBanned();
        isAdmin = userDto.isAdmin();
        visibility = userDto.getVisibility();

        followers = new ArrayList<User>();
        if(userDto.getFollowersId() != null){
            for (long userId : userDto.getFollowersId()) {
                User user = userRepository.getById(userId);
                if(user != null )
                    followers.add(user);
            }
        }

        following = new ArrayList<User>();
        if(userDto.getFollowingId() != null){
            for (long userId : userDto.getFollowingId()) {
                User user = userRepository.getById(userId);
                if(user != null )
                    following.add(user);
            }
        }

        notifications = new ArrayList<Notification>();
        if(userDto.getNotifications() != null){
            for (NotificationDto dto : userDto.getNotifications()) {
                notifications.add(new Notification(dto));
            }
        }

        followingRequests = new ArrayList<FollowingRequest>();
        if(userDto.getFollowingRequests() != null){
            for (FollowingRequestDto dto : userDto.getFollowingRequests()) {
                followingRequests.add(new FollowingRequest(dto));
            }
        }

        //TODO add all other fields
        //answers, polls, and perhaps dates fields
    }

    // GETTERS & SETTERS


    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReminderToken() {
        return reminderToken;
    }

    public void setReminderToken(String reminderToken) {
        this.reminderToken = reminderToken;
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

    public Timestamp getLastConnectedAt() {
        return lastConnectedAt;
    }

    public void setLastConnectedAt(Timestamp lastConnectedAt) {
        this.lastConnectedAt = lastConnectedAt;
    }

    public Timestamp getActivityAt() {
        return activityAt;
    }

    public void setActivityAt(Timestamp activityAt) {
        this.activityAt = activityAt;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Media getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Media profilePicture) {
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

    public void setIsBanned(boolean isBanned) {
        this.isBanned = isBanned;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public AccountVisibility getVisibility() {
        return visibility;
    }

    public void setVisibility(AccountVisibility visibility) {
        this.visibility = visibility;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<FollowingRequest> getFollowingRequests() {
        return followingRequests;
    }

    public void setFollowingRequests(List<FollowingRequest> followingRequests) {
        this.followingRequests = followingRequests;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Poll> getPolls() {
        return polls;
    }

    public void setPolls(List<Poll> polls) {
        this.polls = polls;
    }

    public void setBanned(boolean isBanned) {
        this.isBanned = isBanned;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }


    public UserDto toDto() {
        UserDto dto = new UserDto();

        dto.setId(id);
        dto.setUsername(username);
        dto.setFirstname(firstname);
        dto.setLastname(lastname);
        dto.setEmail(email);
        dto.setBirthday(birthday);
        dto.setMaritalStatus(maritalStatus);
        dto.setCivility(civility);
        if(profilePicture != null){
            dto.setProfilePicture(profilePicture.toDto());
        }
        dto.setSocioProfessionalCategory(socioProfessionalCategory);
        dto.setDetailedProfession(detailedProfession);
        dto.setHobbies(hobbies);
        dto.setLocation(location);
        dto.setBanned(isBanned);
        dto.setAdmin(isAdmin);
        dto.setVisibility(visibility);

        List<Long> followersId = new ArrayList<>();
        if(followers != null){
            for (User user : followers) {
                followersId.add(user.getId());
            }
        }
        dto.setFollowersId(followersId);

        List<Long> followingId = new ArrayList<>();
        if(followers != null){
            for (User user : following) {
                followingId.add(user.getId());
            }
        }
        dto.setFollowingId(followingId);

        List<NotificationDto> notificationsDto = new ArrayList<>();
        if(followers != null){
            for (Notification notification : notifications) {
                notificationsDto.add(notification.toDto());
            }
        }
        dto.setNotifications(notificationsDto);

        List<FollowingRequestDto> followingRequestsDto = new ArrayList<>();
        if(followers != null){
            for (FollowingRequest followingRequest : followingRequests) {
                followingRequestsDto.add(followingRequest.toDto());
            }
        }
        dto.setFollowingRequests(followingRequestsDto);

        //TODO add all other fields
        //answers, polls, and perhaps dates fields

        return dto;
    }



    // Utilities Methods
    public static List<User> dtosToEntities (List<UserDto> dtos){
        UserRepository userRepository = new UserRepository();

        List<User> entities = new ArrayList<>();

        for(UserDto dto : dtos){
            entities.add(new User(dto));
        }
        return entities;
    }

    public static List<UserDto> entitiesToDtos (List<User> entities){
        List<UserDto> dtos = new ArrayList<>();

        for(User entity : entities){
            dtos.add(entity.toDto());
        }
        return dtos;
    }
}
