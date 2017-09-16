package com.makowis.shuzobot.models

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import com.makowis.shuzobot.dao.EncouragementWordDao

@Component
class Shuzo {

    @Autowired
    lateinit var encouragementWordDao: EncouragementWordDao

    fun 励ます(): String {
        val 励ましの言葉 = encouragementWordDao.selectRandom()
        return 励ましの言葉.word
    }

    fun 自己紹介する(): String = "本気になれば自分が変わる！ 本気になれば全てが変わる！！松岡修造です！"

    fun お礼を言う(): String = "僕が偉そうに人に話してることは全部、これまで僕ができなかったこと"
}
