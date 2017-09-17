package com.makowis.shuzobot.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface UsersDao {
    @Select
    String selectPassword(String userId);

    @Update(sqlFile = true)
    int updatePassword(String userId, String newPassword);
}
