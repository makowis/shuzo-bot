package com.makowis.shuzobot.models

import com.makowis.shuzobot.dao.EncouragementWordDao
import com.makowis.shuzobot.entity.EncouragementWord
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.{
  ContextConfiguration,
  TestContextManager
}
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.mockito.Mockito.when
import org.scalatest.{DiagrammedAssertions, FlatSpec}
import org.springframework.test.context.support.AnnotationConfigContextLoader

@ExtendWith(Array(classOf[SpringExtension]))
@ContextConfiguration(
  classes = Array(classOf[Shuzo]),
  loader = classOf[AnnotationConfigContextLoader]
)
class ShuzoTest extends FlatSpec with DiagrammedAssertions {

  @MockBean
  val encouragementWordDao: EncouragementWordDao = null

  @Autowired
  val shuzo: Shuzo = null

  new TestContextManager(this.getClass).prepareTestInstance(this)

  it must "励ます" in {
    val expected = "元気出せよ"

    val word = new EncouragementWord(expected)

    when(encouragementWordDao.selectRandom).thenReturn(word)
    assert(expected == shuzo.励ます)
  }

  it must "自己紹介する" in {
    val expected = "本気になれば自分が変わる！ 本気になれば全てが変わる！！松岡修造です！"
    assert(expected == shuzo.自己紹介する)
  }

  it must "お礼を言う" in {
    val expected = "僕が偉そうに人に話してることは全部、これまで僕ができなかったこと"
    assert(expected == shuzo.お礼を言う)
  }
}
