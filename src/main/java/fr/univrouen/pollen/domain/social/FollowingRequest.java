package fr.univrouen.pollen.domain.social;

import fr.univrouen.pollen.domain.Identifiable;

import javax.persistence.*;
import fr.univrouen.pollen.dto.social.FollowingRequestDto;
import fr.univrouen.pollen.repositories.social.UserRepository;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table
public class FollowingRequest implements Identifiable {

    // ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="followingRequestId")
    private long id;

    @OneToOne
    @JoinColumn(nullable = false)
    private User requesterUser;

    @OneToOne
    @JoinColumn(nullable = false)
    private User requestedUser;

    private Timestamp createdAt;

    @Enumerated(EnumType.STRING)
    private FollowingState state;
    
    public FollowingRequest() {
    }

    public FollowingRequest(FollowingRequestDto dto) {
        UserRepository userRepository = new UserRepository();
        this.id = dto.getId();
        this.requesterUser = userRepository.getById(dto.getRequesterUserId());
        this.requestedUser = userRepository.getById(dto.getRequestedUserId());
        this.state = dto.getState();
    }


    // GETTERS & SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getRequesterUser() {
        return requesterUser;
    }

    public void setRequesterUser(User requesterUser) {
        this.requesterUser = requesterUser;
    }

    public User getRequestedUser() {
        return requestedUser;
    }

    public void setRequestedUser(User requestedUser) {
        this.requestedUser = requestedUser;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public FollowingState getState() {
        return state;
    }

    public void setState(FollowingState state) {
        this.state = state;
    }
    
    public FollowingRequestDto toDto() {
        FollowingRequestDto dto = new FollowingRequestDto();
        dto.setId(id);
        dto.setRequesterUserId(requesterUser.getId());
        dto.setRequestedUserId(requestedUser.getId());
        dto.setState(state);
        return dto;
    }

    // Constructors
    public FollowingRequest(User sender, User target){
        requestedUser = target;
        requesterUser = sender;
        createdAt = new Timestamp(new Date().getTime() );
        state = FollowingState.WAITING;
    }

}
