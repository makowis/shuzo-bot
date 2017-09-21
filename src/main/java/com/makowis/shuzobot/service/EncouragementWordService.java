package com.makowis.shuzobot.service;

import java.util.List;

import org.seasar.doma.jdbc.Result;
import org.seasar.doma.jdbc.UniqueConstraintException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.makowis.shuzobot.dao.EncouragementWordDao;
import com.makowis.shuzobot.entity.EncouragementWord;

@Service
public class EncouragementWordService {

    @Autowired
    EncouragementWordDao encouragementWordDao;

    public List<EncouragementWord> allWordList() {
        return encouragementWordDao.selectAll();
    }

    public boolean addWord(String word) {
        try {
            Result<EncouragementWord> result = encouragementWordDao.insert(new EncouragementWord(word));
            return result.getCount() == 1;
        } catch (DuplicateKeyException | UniqueConstraintException e) {
            // 一意制約違反の場合は追加不可とみなす
            return false;
        }
    }
}
