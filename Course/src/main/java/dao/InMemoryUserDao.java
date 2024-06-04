package dao;

import java.util.HashMap;
import java.util.Map;

import model.User;


public class InMemoryUserDao implements UserDao {
    private Map<String, User> users = new HashMap<>();

    public InMemoryUserDao() {
        users.put("user1", new User("user1", "password1"));
        users.put("user2", new User("user2", "password2"));
        users.put("user3", new User("user3", "password3"));
    }

    @Override
    public User findByName(String name) {
        return users.get(name);
    }

    @Override
    public void save(User user) {
        users.put(user.getName(), user);
    }
}

