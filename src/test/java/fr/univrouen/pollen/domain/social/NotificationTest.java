package fr.univrouen.pollen.domain.social;

import fr.univrouen.pollen.dto.social.NotificationDto;
import fr.univrouen.pollen.repositories.social.NotificationRepository;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NotificationTest extends TestCase {

    @Test
    public void test_insert_Notification_Empty(){

        //GIVEN WHEN
        Notification notification=new Notification();

        NotificationRepository notificationRepository =new NotificationRepository();
        try{
            notificationRepository.insert(notification);
            fail("Notification empty should'nt be insert");
        }catch(Exception e){
            assertTrue(true);
        }

    }

    @Test
    public void test_inser_the_notigfication_no_Empty(){

        String text="exemple de sondage";
        String url="CEci est un lien";
        boolean visibilite=false;

        Notification notification=new Notification();

        notification.setNotificationText("exemple de sondage");
        notification.setLinkTo("CEci est un lien");
        notification.setIsViewed(false);

        NotificationRepository notificationRepository =new NotificationRepository();
        notificationRepository.insert(notification);

        List<Notification> notificationList = new ArrayList<Notification>();
        notificationList = notificationRepository.getAll();
        assertTrue(notificationList.size() == 1);
       // System.out.println("notification :"+ notification.getId());

        Notification notificationInBdd = notificationList.get(0);


        assertEquals(notificationInBdd.getNotificationText(),text);
        assertEquals(notificationInBdd.getLinkTo(),url);
        assertEquals(notificationInBdd.isViewed(),visibilite);

        notificationRepository.delete(notification);
        assertTrue(notificationRepository.getAll().size()==0);
    }
}