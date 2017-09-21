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

import com.makowis.shuzobot.entity.EncouragementWord;
import com.makowis.shuzobot.form.EncouragementWordAddForm;
import com.makowis.shuzobot.service.EncouragementWordService;

@Controller
@RequestMapping("/encouragementWords")
public class EncouragementWordController {
    @Autowired
    EncouragementWordService encouragementWordService;

    @GetMapping
    public String index(Model model) {
        List<EncouragementWord> encouragementWords = encouragementWordService.allWordList();
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

        String page = "encouragementWords/add";
        if (result.hasErrors()) {
            return page;
        }

        boolean addResult = encouragementWordService.addWord(encouragementWordAddForm.getWord());
        if (addResult) {
            model.addAttribute("successMessage", String.format("「%s」を追加しました。", encouragementWordAddForm.getWord()));
        } else {
            model.addAttribute("errorMessage",
                    String.format("「%s」の追加に失敗しました。すでに追加済みの可能性があります。", encouragementWordAddForm.getWord()));
        }
        return "encouragementWords/add";
    }

}
