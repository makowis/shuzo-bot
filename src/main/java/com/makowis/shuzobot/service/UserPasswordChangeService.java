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

    public Optional<String> change(String userId, String oldPassword, String newPassword) {
        int aaa = usersDao.checkPassword(userId, oldPassword);

        if (aaa < 1) {
            return Optional.of("パスワードが違うよ");
        }

        return Optional.empty();
    }

}
