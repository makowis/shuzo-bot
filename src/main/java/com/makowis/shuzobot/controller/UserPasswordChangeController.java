package com.makowis.shuzobot.controller;

import com.makowis.shuzobot.form.UserPasswordChangeForm;
import com.makowis.shuzobot.service.UserPasswordChangeService;
import com.makowis.shuzobot.validation.PasswordEqualsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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

    @Autowired
    PasswordEqualsValidator passwordEqualsValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(passwordEqualsValidator); // (2)
    }

    @RequestMapping(value = "/passwordChange", method = RequestMethod.GET)
    public String passwordChange(){
        return "/user/passwordChange";
    }

    @RequestMapping(value = "/passwordChange",method = RequestMethod.POST)
    public String doPasswordChange(@Validated @ModelAttribute UserPasswordChangeForm userPasswordChangeForm,
                                   BindingResult result,
                                   Model model,
                                   @AuthenticationPrincipal User user){

        if (result.hasErrors()) {
            model.addAttribute("validationError", "不正な値が入力されました。");
            return "/user/passwordChange";
        }

        Optional<String> errorMsg = userPasswordChangeService.change(user.getUsername(), userPasswordChangeForm.getOldPassword(), userPasswordChangeForm.getNewPassword());
        errorMsg.ifPresent(s -> model.addAttribute("validationError", s));

        return "/user/passwordChange";
    }
}
