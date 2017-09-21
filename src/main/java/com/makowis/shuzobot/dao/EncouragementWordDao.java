package com.makowis.shuzobot.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

import org.springframework.transaction.annotation.Transactional;

import com.makowis.shuzobot.entity.EncouragementWord;

@Dao
@ConfigAutowireable
public interface EncouragementWordDao {
    @Select
    List<EncouragementWord> selectAll();

    @Select
    EncouragementWord selectRandom();

    @Insert
    @Transactional
    Result<EncouragementWord> insert(EncouragementWord encouragementWord);
}
