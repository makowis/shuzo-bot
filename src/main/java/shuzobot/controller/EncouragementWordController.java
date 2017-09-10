package shuzobot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import shuzobot.dao.EncouragementWordDao;
import shuzobot.entity.EncouragementWord;

import java.util.List;

@Controller
public class EncouragementWordController {
    @Autowired
    EncouragementWordDao encouragementWordDao;

    @GetMapping("/encouragementWord")
    public String index(Model model) {
        List<EncouragementWord> encouragementWords = encouragementWordDao.selectAll();
        model.addAttribute("encouragementWords", encouragementWords);
        return "encouragementWord";
    }
}
