package fr.univrouen.pollen.repositories.polling;

import fr.univrouen.pollen.domain.polling.Answer;
import fr.univrouen.pollen.domain.polling.Poll;
import fr.univrouen.pollen.domain.social.Notification;
import fr.univrouen.pollen.domain.social.User;
import fr.univrouen.pollen.repositories.social.NotificationRepository;
import fr.univrouen.pollen.repositories.social.UserRepository;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class NotificationRepositoryTest extends TestCase {

    @Test
    public void testHibernate() {
        try (NotificationRepository repository = new NotificationRepository()) {
            Notification notification = new Notification();
            notification.setNotificationText("A test Notification");

            //Test insert
            repository.insert(notification);
            assertTrue(repository.getAll().size() > 0);

            //Test delete
            repository.delete(notification);
            assertTrue(repository.getAll().size() == 0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_CRUD_with_differents_repositories() {
        UserRepository userRep = new UserRepository();
        PollRepository pollRep = new PollRepository();
        // Create and insert a user
        User u = new User();
        u.setEmail("");
        u.setPassword("");
        u.setUsername("");
        userRep.insert(u);
        // Create and insert a poll
        Poll p = new Poll(u);
        pollRep.insert(p);
    }


    public void testMultiHibernate() {
        //Create a fake notification
        Notification notification = new Notification();
        notification.setNotificationText("A test Notification");

        try (NotificationRepository repository = new NotificationRepository()) {
            repository.insert(notification);                //Insert it
            assertEquals(repository.getAll().size(), 1);    //Insertion is visible

            try (NotificationRepository repository2 = new NotificationRepository()) {
                assertEquals(repository.getAll().size(), 1);    //Insertion is visible
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (NotificationRepository repository = new NotificationRepository()) {
            assertEquals(repository.getAll().size(), 1);    //Insertion is visible
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (NotificationRepository repository = new NotificationRepository()) {
            try (NotificationRepository repository2 = new NotificationRepository()) {
                repository2.delete(notification);               //Delete notification
                assertEquals(repository.getAll().size(), 1);    //Notif is still visible because repo2 isn't terminated
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            assertEquals(repository.getAll().size(), 0);    //Notif is deleted (because repo2 was validated)
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
