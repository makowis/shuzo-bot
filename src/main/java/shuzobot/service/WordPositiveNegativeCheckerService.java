package shuzobot.service;

import com.atilika.kuromoji.TokenBase;
import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shuzobot.dao.WordPositiveNegativeDao;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordPositiveNegativeCheckerService {

    @Autowired
    WordPositiveNegativeDao wordPositiveNegativeDao;

    public boolean isPositive(String word) {

        Tokenizer tokenizer = new Tokenizer() ;
        List<Token> tokens = tokenizer.tokenize(word);

        List<String> splitWords = tokens.stream().map(TokenBase::getSurface).collect(Collectors.toList());

        int score = wordPositiveNegativeDao.GetWordsScore(splitWords);

        return  score >= 0;
    }

    public boolean isNegative(String word) {
        return !this.isPositive(word);
    }
}
