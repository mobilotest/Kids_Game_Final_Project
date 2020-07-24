package com.sergooo.kidsgame;

public class Screen {
    private String image;
    private String answer;
    private String[] buttons;

    public Screen(String image, String answer, String button_1, String button_2, String button_3, String button_4, String button_5, String button_6, String button_7, String button_8) {
        this.image = image;
        this.answer = answer;
        this.buttons = new String[]{
                button_1,
                button_2,
                button_3,
                button_4,
                button_5,
                button_6,
                button_7,
                button_8
        };
    }

    public String getImage() {
        return image;
    }
    public String getAnswer() {
        return answer;
    }

    public String getButton(int index) {
        return buttons[index];
    }
}
