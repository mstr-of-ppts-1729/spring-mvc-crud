package web.Dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.Model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    private EntityManager entityManager;


    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> index() {
        return entityManager.createQuery("SELECT user FROM User user").getResultList();

    }

    @Override
    public User show(int id) {
        return (User) entityManager.createQuery(
                "SELECT user from User user where user.id = :id").
                setParameter("id", id).getSingleResult();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(int id, User user) {
        entityManager.createQuery(
                "UPDATE User user SET user.name=:name, user.email=:email, user.age=:age WHERE user.id=:id")
                .setParameter("name", user.getName())
                .setParameter("age", user.getAge())
                .executeUpdate();
    }

    @Override
    public void delete(int id) {
        entityManager.createQuery(
                "DELETE FROM User user WHERE user.id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
