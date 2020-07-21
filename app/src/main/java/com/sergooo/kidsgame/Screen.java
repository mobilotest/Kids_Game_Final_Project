package com.sergooo.kidsgame;

public class Screen {
    private String image;
    private String answer;
    private String button_1;
    private String button_2;
    private String button_3;
    private String button_4;
    private String button_5;
    private String button_6;
    private String button_7;
    private String button_8;

    public Screen(String image, String answer, String button_1, String button_2, String button_3, String button_4, String button_5, String button_6, String button_7, String button_8) {
        this.image = image;
        this.answer = answer;
        this.button_1 = button_1;
        this.button_2 = button_2;
        this.button_3 = button_3;
        this.button_4 = button_4;
        this.button_5 = button_5;
        this.button_6 = button_6;
        this.button_7 = button_7;
        this.button_8 = button_8;
    }

    public String getImage() {
        return image;
    }

    public String getAnswer() {
        return answer;
    }

    public String getButton_1() {
        return button_1;
    }

    public String getButton_2() {
        return button_2;
    }

    public String getButton_3() {
        return button_3;
    }

    public String getButton_4() {
        return button_4;
    }

    public String getButton_5() {
        return button_5;
    }

    public String getButton_6() {
        return button_6;
    }

    public String getButton_7() {
        return button_7;
    }

    public String getButton_8() {
        return button_8;
    }
}
