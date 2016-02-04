package fr.univrouen.pollen.repositories.social;

import fr.univrouen.pollen.domain.social.Notification;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class NotificationRepositoryTest extends TestCase {

    @Test
    public void testHibernate() {
        NotificationRepository repository = new NotificationRepository();

        Notification notification = new Notification();
        notification.setNotificationText("lala");
        notification.setLinkTo("coucou");

        repository.insert(notification);

        assertTrue(repository.getAll().size() > 0);

        repository.delete(notification);

        assertTrue(repository.getAll().size() == 0);

        notification = new Notification();
        notification.setNotificationText("lala");
        repository.insert(notification);
        List<Notification> notifications = repository.getAll();

        long id = notifications.get(0).getId();

        assertTrue(repository.getById(id) != null);
    }
}
