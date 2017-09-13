package com.makowis.shuzobot.dao;

import com.makowis.shuzobot.entity.EncouragementWord;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Dao
@ConfigAutowireable
public interface EncouragementWordDao {
    @Select
    List<EncouragementWord> selectAll();

    @Select
    EncouragementWord selectRandom();

    @Insert
    @Transactional
    int insert(EncouragementWord encouragementWord);
}
