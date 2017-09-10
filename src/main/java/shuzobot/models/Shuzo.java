package shuzobot.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shuzobot.dao.EncouragementWordDao;
import shuzobot.entity.EncouragementWord;

import java.util.List;
import java.util.Random;

/**
 * Created by makoto on 2017/09/08.
 */
@Component
public class Shuzo {
    private List<EncouragementWord> 励ましの言葉集;

    @Autowired
    EncouragementWordDao encouragementWordDao;

    public String 励ます() {
        励ましの言葉集 = encouragementWordDao.selectAll();
        int index = new Random().nextInt(励ましの言葉集.size());
        return 励ましの言葉集.get(index).word;
    }

    public String 自己紹介する() {
        return "本気になれば自分が変わる！ 本気になれば全てが変わる！！松岡修造です！";
    }

    public String お礼を言う() {
        return "僕が偉そうに人に話してることは全部、これまで僕ができなかったこと";
    }
}
