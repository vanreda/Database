package fr.univrouen.pollen.domain.social;

import fr.univrouen.pollen.repositories.social.FollowingRequestRepository;
import fr.univrouen.pollen.repositories.social.NotificationRepository;
import fr.univrouen.pollen.repositories.social.UserRepository;
import junit.framework.TestCase;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class FollowingRequestTest extends TestCase {

    @Test
    public void test_insert_delete_following(){

        FollowingRequestRepository followingRequestRepository=new FollowingRequestRepository();
        UserRepository repository = new UserRepository();


        Timestamp timestamp = new Timestamp(new Date().getTime());

        User user=new User();
        user.setCivility(Civility.MME);
        user.setEmail("EMAIL");
        user.setActivityAt(timestamp);
        user.setBirthday(new java.sql.Date(10));
        user.setCreatedAt(timestamp);
        user.setFirstname("Ousmane");
        user.setLastname("DIOP");
        user.setLastConnectedAt(timestamp);
        user.setMaritalStatus(MaritalStatus.SINGLE);
        user.setUsername("Mouche");
        user.setVisibility(AccountVisibility.PRIVATE);
        user.setPassword("passpass");
        user.setSocioProfessionalCategory(SocialProfessionalCategory.FORMER_MEDIUM);

        Location location = new Location();
        location.setCity("Rouen");
        location.setCountry("Fr");
        location.setZipcode(76);
        user.setLocation(location);

        List<Profession> professionList = new ArrayList<Profession>();
        professionList.add(Profession.PSYCHIATRIST);
        user.setDetailedProfession(professionList);

        List<Hobbies> hobbiesList = new ArrayList<Hobbies>();
        hobbiesList.add(Hobbies.SPORT);
        user.setHobbies(hobbiesList);


        repository.insert(user);

        User users=new User();
        users.setCivility(Civility.MME);
        users.setEmail("EMAIL");
        users.setActivityAt(timestamp);
        users.setBirthday(new java.sql.Date(10));
        users.setCreatedAt(timestamp);
        users.setFirstname("Marie");
        users.setLastname("VICTOIRE");
        users.setLastConnectedAt(timestamp);
        users.setMaritalStatus(MaritalStatus.SINGLE);
        users.setUsername("Moucha");
        users.setVisibility(AccountVisibility.PRIVATE);
        users.setPassword("passpass");
        users.setSocioProfessionalCategory(SocialProfessionalCategory.FORMER_MEDIUM);

        Location locations = new Location();
        locations.setCity("Rouen");
        locations.setCountry("Fr");
        locations.setZipcode(76);
        users.setLocation(locations);

        List<Profession> professionLists = new ArrayList<Profession>();
        professionLists.add(Profession.ACTOR);
        users.setDetailedProfession(professionLists);

        List<Hobbies> hobbiesLists = new ArrayList<Hobbies>();
        hobbiesLists.add(Hobbies.SPORT);
        users.setHobbies(hobbiesLists);


        repository.insert(users);

        List<User> userList = new ArrayList<User>();
        userList = repository.getAll();

        FollowingRequest followingRequest=new FollowingRequest();
        followingRequest.setCreatedAt(timestamp);
        followingRequest.setState(FollowingState.ACCEPTED);
        followingRequest.setRequestedUser(userList.get(0));
        followingRequest.setRequesterUser(userList.get(1));

        followingRequestRepository.insert(followingRequest);

        followingRequest.setCreatedAt(timestamp);
        followingRequest.setState(FollowingState.REJECTED);
        followingRequest.setRequestedUser(userList.get(0));
        followingRequest.setRequesterUser(userList.get(1));

        followingRequestRepository.insert(followingRequest);

    }

    public void test_insert_folloowing_Empty(){
        FollowingRequest followingRequest=new FollowingRequest();

        FollowingRequestRepository followingRequestRepository=new FollowingRequestRepository();
        try{
            followingRequestRepository.insert(followingRequest);
            fail("following empty should'nt be insert");
        }catch(Exception e){
            assertTrue(true);
        }
    }
}