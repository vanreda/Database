package fr.univrouen.pollen.repositories.social;

import fr.univrouen.pollen.domain.social.*;
import junit.framework.TestCase;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserRepositoryTest extends TestCase {

    private String[] usernames = {"Rodeo", "DvD", "Levivou", "Attrakeur", "Aku", "Lotto", "Universe", "Kmyong", "DouxJMdoux", "Alphonse"};
    private String[] firstnames = {"Alexandre", "Damien", "Vivien", "Valentin", "Steeven", "Kevin", "Armand", "Un chinois", "Jean", "Alphonse"};
    private String[] lastnames = {"Nom1", "Nom2", "Nom3", "Nom4", "Nom5", "Nom6", "Nom7", "Nom8", "Nom9", "Nom10"};

    @Test
    public void test_create_multiple_users(){
        try(UserRepository userRepository = new UserRepository()) {
            for (int i = 0; i < usernames.length; i++) {
                userRepository.insert(new User(usernames[i] + "@aol.fr", "password", usernames[i], firstnames[i], lastnames[i]));
            }

            assertTrue(userRepository.getAll().size() == usernames.length);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


    @Test
    public void test_create_valid_user() throws Exception {
        try(UserRepository repository = new UserRepository()) {

            Timestamp timestamp = new Timestamp(new Date().getTime());
            User user = new User();
            user.setCivility(Civility.MME);
            user.setEmail("EMAIL");
            user.setActivityAt(timestamp);
            user.setBirthday(new java.sql.Date(10));
            user.setCreatedAt(timestamp);
            user.setFirstname("Alexandre");
            user.setLastname("Pétré");
            user.setLastConnectedAt(timestamp);
            user.setMaritalStatus(MaritalStatus.SINGLE);
            user.setUsername("Rodeo");
            user.setVisibility(AccountVisibility.PRIVATE);
            user.setPassword("superpassword");
            user.setSocioProfessionalCategory(SocialProfessionalCategory.FORMER_MEDIUM);

            Location location = new Location();
            location.setCity("Rouen");
            location.setCountry("Fr");
            location.setZipcode(76);
            user.setLocation(location);

            List<Profession> professionList = new ArrayList<>();
            professionList.add(Profession.PSYCHIATRIST);
            user.setDetailedProfession(professionList);

            List<Hobbies> hobbiesList = new ArrayList<>();
            hobbiesList.add(Hobbies.SPORT);
            user.setHobbies(hobbiesList);

            repository.insert(user);

            assertTrue(repository.getAll().size() > 0);

            repository.delete(user);

            LocationRepository locationRepository = new LocationRepository();
            List<Location> locationList = locationRepository.getAll();
            assertEquals(locationList.size(), 1);

        } catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }

    }

    @Test
    public void test_insert_user_empty_should_fail(){
        User user = new User();

        UserRepository userRepository = new UserRepository();

        try{
            userRepository.insert(user);
            fail("User with no attribute should'nt be insert");
            userRepository.close();
        }catch (Exception ex){
            assertTrue(true);
        }
    }


}
