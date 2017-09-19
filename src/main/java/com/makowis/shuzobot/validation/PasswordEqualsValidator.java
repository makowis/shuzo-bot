package com.makowis.shuzobot.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.makowis.shuzobot.form.UserPasswordChangeForm;

@Component
public class PasswordEqualsValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserPasswordChangeForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserPasswordChangeForm form = (UserPasswordChangeForm) target;
        String password = form.getNewPassword();
        String confirmPassword = form.getNewPasswordConfirm();

        if (password == null || confirmPassword == null) {
            // must be checked by @NotNull
            return;
        }
        if (!password.equals(confirmPassword)) {
            errors.rejectValue("newPassword", "PasswordEqualsValidator.userPasswordChangeForm.password",
                    "新・パスワードが一致しません。");
        }
    }
}