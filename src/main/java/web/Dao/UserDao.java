package web.Dao;

import org.springframework.stereotype.Component;
import web.Model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {
    private static int USERS_COUNT;
    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(++USERS_COUNT, "D'Vorah", 500));
        users.add(new User(++USERS_COUNT, "Kabal", 100));
        users.add(new User(++USERS_COUNT, "Kenshi Takahashi", 300));
    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++USERS_COUNT);
        users.add(user);
    }

    public void update(int id, User updUser) {
        User userToBeUpd = show(id);
        userToBeUpd.setName(updUser.getName());
        userToBeUpd.setAge(updUser.getAge());
    }
    public void delete(int id){
        users.removeIf(i -> i.getId() == id);
    }
}
