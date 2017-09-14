package com.makowis.shuzobot.slack;

import com.makowis.shuzobot.models.Shuzo;
import me.ramswaroop.jbot.core.slack.Bot;
import me.ramswaroop.jbot.core.slack.Controller;
import me.ramswaroop.jbot.core.slack.EventType;
import me.ramswaroop.jbot.core.slack.models.Event;
import me.ramswaroop.jbot.core.slack.models.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;
import com.makowis.shuzobot.service.WordPositiveNegativeCheckerService;

/**
 * A Slack Bot sample. You can create multiple bots by just
 * extending {@link Bot} class like this one.
 *
 * @author ramswaroop
 * @version 1.0.0, 05/06/2016
 */
@Component
public class SlackBot extends Bot {

    private static final Logger logger = LoggerFactory.getLogger(SlackBot.class);

    /**
     * Slack token from application.properties file. You can get your slack token
     * next <a href="https://my.slack.com/services/new/bot">creating a new bot</a>.
     */
    @Value("${slackBotToken}")
    private String slackToken;

    @Override
    public String getSlackToken() {
        return slackToken;
    }

    @Override
    public Bot getSlackBot() {
        return this;
    }

    @Autowired
    Shuzo 修造;

    @Autowired
    WordPositiveNegativeCheckerService ネガポジ判別機;

    /**
     * Invoked when the bot receives a direct mention (@botname: message)
     * or a direct message. NOTE: These two event types are added by jbot
     * to make your task easier, Slack doesn't have any direct way to
     * determine these type of events.
     *
     * @param session
     * @param event
     */
    @Controller(events = {EventType.DIRECT_MENTION, EventType.DIRECT_MESSAGE})
    public void onReceiveDM(WebSocketSession session, Event event) {
        reply(session, event, new Message(修造.自己紹介する()));
    }

    /**
     *
     *
     * @param session
     * @param event
     */
    @Controller(events = EventType.MESSAGE)
    public void onReceiveMessage(WebSocketSession session, Event event) {
        if (ネガポジ判別機.isNegative(event.getText())){
            reply(session, event, new Message(修造.励ます()));
        }
    }

    /**
     *
     *
     * @param session
     * @param event
     */
    @Controller(events = EventType.MESSAGE, pattern = "^(([Hh]i|[Ss]ay|[Hh]ey)[ 　]*修造)$", next = "confirmCallShuzo")
    public void onCallShuzo(WebSocketSession session, Event event) {
        startConversation(event, "confirmCallShuzo");   // start conversation
        reply(session, event, new Message("呼んでくれてありがとう！"));
    }

    @Controller
    public void confirmCallShuzo(WebSocketSession session, Event event) {
        if (event.getText().contains("はい")
                || event.getText().contains("呼んだ")) {
            reply(session, event, new Message("もっと熱くなれよ！！！！"));
        } else if(event.getText().contains("いいえ")
                || event.getText().contains("呼んでない")) {
            reply(session, event, new Message("崖っぷちありがとう！！最高だ！！"));
        } else {
            onReceiveMessage(session,event);
        }
        stopConversation(event);    // stop conversation
    }

    /**
     * Invoked when an item is pinned in the channel.
     *
     * @param session
     * @param event
     */
    @Controller(events = EventType.PIN_ADDED)
    public void onPinAdded(WebSocketSession session, Event event) {
        reply(session, event, new Message(修造.お礼を言う()));
    }

}