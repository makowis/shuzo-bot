package com.makowis.shuzobot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.makowis.shuzobot.dao.UsersDao;

@Service
public class UserPasswordChangeService {

    @Autowired
    UsersDao usersDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    public boolean isValidPassword(String userId, String oldPassword) {
        String password = usersDao.selectPassword(userId);
        return passwordEncoder.matches(oldPassword, password);
    }

    public void change(String userId, String newPassword) {

        usersDao.updatePassword(userId, passwordEncoder.encode(newPassword));
    }

}
