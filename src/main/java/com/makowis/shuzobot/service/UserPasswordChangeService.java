package com.makowis.shuzobot.service;

import com.makowis.shuzobot.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserPasswordChangeService {

    @Autowired
    UsersDao usersDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Optional<String> change(String userId, String oldPassword, String newPassword) {
        String password = usersDao.selectPassword(userId);
        if (!passwordEncoder.matches(oldPassword,password)) {
            return Optional.of("パスワードが違います。");
        }

        return Optional.empty();
    }

}
