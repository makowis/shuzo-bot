package com.makowis.shuzobot.controller;

import com.makowis.shuzobot.form.UserPasswordChangeForm;
import com.makowis.shuzobot.service.UserPasswordChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserPasswordChangeController {

    @Autowired
    UserPasswordChangeService userPasswordChangeService;

    @RequestMapping(value = "/passwordChange", method = RequestMethod.GET)
    public String passwordChange(UserPasswordChangeForm form, Model model){
        return "/user/passwordChange";
    }

    @RequestMapping(value = "/passwordChange",method = RequestMethod.POST)
    public String doPasswordChange(@Validated @ModelAttribute UserPasswordChangeForm form, BindingResult result, Model model, @AuthenticationPrincipal User user){

        if (result.hasErrors()) {
            model.addAttribute("validationError", "不正な値が入力されました。");
        }

        Optional<String> errorMsg = userPasswordChangeService.change(user.getUsername(), form.getOldPassword(), form.getNewPassword());
        if (errorMsg.isPresent()) {
            model.addAttribute("validationError", errorMsg.get());
        }

        return "/user/passwordChange";
    }
}
