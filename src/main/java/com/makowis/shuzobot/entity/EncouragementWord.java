package com.makowis.shuzobot.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;

@Entity(immutable = true)
public class EncouragementWord {

    @Id
    final public String word;

    public EncouragementWord(String word) {
        this.word = word;
    }
}
