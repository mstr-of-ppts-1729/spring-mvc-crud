package web.Dao;

import web.Model.User;

import java.util.List;

public interface UserDao {

    List<User> index();

    User show(int id);

    void save(User user);

    void update(int id, User user);

    void delete(int id);
}
