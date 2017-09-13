package com.makowis.shuzobot.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.makowis.shuzobot.dao.EncouragementWordDao;
import com.makowis.shuzobot.entity.EncouragementWord;

/**
 * Created by makoto on 2017/09/08.
 */
@Component
public class Shuzo {

    @Autowired
    EncouragementWordDao encouragementWordDao;

    public String 励ます() {
        EncouragementWord 励ましの言葉 = encouragementWordDao.selectRandom();
        return 励ましの言葉.word;
    }

    public String 自己紹介する() {
        return "本気になれば自分が変わる！ 本気になれば全てが変わる！！松岡修造です！";
    }

    public String お礼を言う() {
        return "僕が偉そうに人に話してることは全部、これまで僕ができなかったこと";
    }
}
