package shuzobot.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;
import shuzobot.entity.EncouragementWord;

import java.util.List;

@ConfigAutowireable
@Dao
public interface EncouragementWordDao {
    @Select
    List<EncouragementWord> selectAll();

    @Insert
    @Transactional
    int insert(EncouragementWord encouragementWord);
}
