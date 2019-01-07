package ru.neofr.demo;

import ru.neofr.demo.entity.User;
import ru.neofr.demo.exception.ServerNotResponding;
import ru.neofr.demo.exception.UserExistsException;

interface UserRepository {
    void save(User user) throws ServerNotResponding, UserExistsException;
    User findOne(String name) throws ServerNotResponding;
    boolean checkToken(User user) throws ServerNotResponding;
}
