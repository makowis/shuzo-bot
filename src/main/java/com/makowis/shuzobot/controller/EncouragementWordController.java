package com.makowis.shuzobot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.makowis.shuzobot.dao.EncouragementWordDao;
import com.makowis.shuzobot.entity.EncouragementWord;
import com.makowis.shuzobot.form.EncouragementWordAddForm;

@Controller
@RequestMapping("/encouragementWords")
public class EncouragementWordController {
    @Autowired
    EncouragementWordDao encouragementWordDao;

    @GetMapping
    public String index(Model model) {
        List<EncouragementWord> encouragementWords = encouragementWordDao.selectAll();
        model.addAttribute("encouragementWords", encouragementWords);
        return "encouragementWords/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@ModelAttribute EncouragementWordAddForm encouragementWordAddForm, Model model) {
        return "encouragementWords/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String doAdd(@Validated @ModelAttribute EncouragementWordAddForm encouragementWordAddForm,
            BindingResult result, Model model, @AuthenticationPrincipal User user) {

        if (!result.hasErrors()) {
            model.addAttribute("successMessage", String.format("「%s」を追加しました。", encouragementWordAddForm.getWord()));
        }
        return "encouragementWords/add";
    }

}
