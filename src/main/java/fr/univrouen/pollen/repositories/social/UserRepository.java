package fr.univrouen.pollen.repositories.social;

import fr.univrouen.pollen.domain.social.User;
import fr.univrouen.pollen.repositories.BaseRepository;
import org.springframework.stereotype.Component;

@Component
public class UserRepository extends BaseRepository<User> {

    public User getByMail(String mail) {
        try {
            User entity = (User) session.createQuery
                            ("From " + classType.getSimpleName() + " U WHERE U.email = :mail")
                            .setParameter("mail", mail)
                            .uniqueResult();
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}