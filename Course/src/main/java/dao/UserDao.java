package dao;

import model.User;

public interface UserDao {
    User findByName(String name);
    void save(User user);
}


