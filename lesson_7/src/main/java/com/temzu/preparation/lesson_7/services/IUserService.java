package com.temzu.preparation.lesson_7.services;

import com.temzu.preparation.lesson_7.model.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    User findByLogin(String login);

    User findByLoginAndPassword(String login, String password);

    User saveUser(User user);
}
