package fr.univrouen.pollen.dto.social;

import fr.univrouen.pollen.domain.social.FollowingState;

public class FollowingRequestDto {

    private long id;
    private long requesterUserId;
    private long requestedUserId;
    private FollowingState state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FollowingState getState() {
        return state;
    }

    public void setState(FollowingState state) {
        this.state = state;
    }

    public long getRequesterUserId() {
        return requesterUserId;
    }

    public void setRequesterUserId(long requesterUserId) {
        this.requesterUserId = requesterUserId;
    }

    public long getRequestedUserId() {
        return requestedUserId;
    }

    public void setRequestedUserId(long requestedUserId) {
        this.requestedUserId = requestedUserId;
    }
}
