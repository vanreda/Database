package fr.univrouen.pollen.repositories.social;

import fr.univrouen.pollen.domain.social.Notification;
import fr.univrouen.pollen.repositories.BaseRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotificationRepository extends BaseRepository<Notification> {

    public List<Notification> getAllByUser(long userid, int start, int nb) {
        List<Notification> entities =
                session.createQuery("From " + getClass().getSimpleName() + " N WHERE N.USERID = :userid")
                        .setFirstResult(start)
                        .setMaxResults(nb)
                        .list();

        return entities;
    }
}
