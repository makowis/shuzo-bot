package com.makowis.shuzobot.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class EncouragementWordAddForm {

    @NotEmpty(message = "励ましの言葉を入力してください")
    @Size(max = 255, message = "励ましの言葉は255文字以下で入力してください")
    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
