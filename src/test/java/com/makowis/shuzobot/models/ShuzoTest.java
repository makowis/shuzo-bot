package com.makowis.shuzobot.models;

import com.makowis.shuzobot.dao.EncouragementWordDao;
import com.makowis.shuzobot.entity.EncouragementWord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Shuzo.class})
class ShuzoTest {

    @MockBean
    EncouragementWordDao encouragementWordDao;

    @Autowired
    Shuzo shuzo;

    @Test
    void 励ます() {
        String expected = "元気出せよ";

        EncouragementWord word = new EncouragementWord();
        word.word = expected;

        when(encouragementWordDao.selectRandom()).thenReturn(word);

        assertEquals( expected, shuzo.励ます());
    }

    @Test
    void 自己紹介する() {
        String expected = "本気になれば自分が変わる！ 本気になれば全てが変わる！！松岡修造です！";
        assertEquals(expected, shuzo.自己紹介する());
    }

    @Test
    void お礼を言う() {
        String expected = "僕が偉そうに人に話してることは全部、これまで僕ができなかったこと";
        assertEquals(expected, shuzo.お礼を言う());
    }

}