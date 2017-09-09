package shuzobot.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;

@Entity
public class EncouragementWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer wordId;
    public String word;
}
