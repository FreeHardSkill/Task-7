package ru.freehardskill.springmvctask.service;

import ru.freehardskill.springmvctask.model.User;

import java.util.List;

public interface UserService {

    void createUser(User user);
    void updateUser(User user);
    void deleteUserById(Long id);
    List<User> getAllUsers();
    User getUserFromId(Long id);
}
