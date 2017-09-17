package com.makowis.shuzobot.service;

import com.atilika.kuromoji.TokenBase;
import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.makowis.shuzobot.dao.WordPositiveNegativeDao;

import java.util.List;
import io.vavr.collection.Stream;

@Service
public class WordPositiveNegativeCheckerService {

    @Autowired
    WordPositiveNegativeDao wordPositiveNegativeDao;

    public boolean isPositive(String word) {

        Tokenizer tokenizer = new Tokenizer() ;
        List<Token> tokens = tokenizer.tokenize(word);

        List<String> splitWords = Stream.ofAll(tokens).map(TokenBase::getSurface).asJava();

        int score = wordPositiveNegativeDao.GetWordsScore(splitWords);

        return  score >= 0;
    }

    public boolean isNegative(String word) {
        return !this.isPositive(word);
    }
}
