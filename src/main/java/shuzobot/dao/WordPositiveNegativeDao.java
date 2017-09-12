package shuzobot.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface WordPositiveNegativeDao {

    @Select
    int GetWordsScore(List<String> words);
}
