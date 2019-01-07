package ru.neofr.demo;

import ru.neofr.demo.entity.User;
import ru.neofr.demo.exception.ServerNotResponding;
import ru.neofr.demo.exception.UserExistsException;

public class UserRepositoryImpl implements  UserRepository {
    //@Resource
    ChatServer chatServer;
    @Override
    public void save(User user) throws ServerNotResponding, UserExistsException {

    }

    @Override
    public User findOne(String name) throws ServerNotResponding {
        return null;
    }

    @Override
    public boolean checkToken(User user) throws ServerNotResponding {
        return true;
    }
}
