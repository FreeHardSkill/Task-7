package ru.freehardskill.springmvctask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.freehardskill.springmvctask.DAO.UserDAO;
import ru.freehardskill.springmvctask.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userDAO.deleteUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUserFromId(Long id) {
        return userDAO.getUserFromId(id);
    }
}
