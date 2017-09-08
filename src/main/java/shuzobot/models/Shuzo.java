package shuzobot.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by makoto on 2017/09/08.
 */
@Component
public class Shuzo {
    private List<String> 励ましの言葉集;

    public Shuzo() {
        励ましの言葉集 = new ArrayList<String>(){
            {
                add("何言ってんだよ！！ \nその崖っぷちが最高のチャンスなんだぜ！！");
                add("諦めんなよ！\n諦めんなよ、お前！！");
                add("一番になるっつったよな？ ナンバー1になるっつったよな！？");
                add("100回叩くと壊れる壁があったとする。\nでもみんな何回叩けば壊れるかわからないから、\n90回まで来ていても途中であきらめてしまう。");
                add("本気になれば自分が変わる！ 本気になれば全てが変わる！！");
            }
        };
    }

    public String 励ます() {
        int index = new Random().nextInt(励ましの言葉集.size());
        return 励ましの言葉集.get(index);
    }

    public String 自己紹介する() {
        return "本気になれば自分が変わる！ 本気になれば全てが変わる！！松岡修造です！";
    }

    public String お礼を言う() {
        return "僕が偉そうに人に話してることは全部、これまで僕ができなかったこと";
    }
}
