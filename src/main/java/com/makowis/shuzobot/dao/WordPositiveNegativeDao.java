package com.makowis.shuzobot.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface WordPositiveNegativeDao {

    @Select
    int GetWordsScore(List<String> words);
}
