package au.davidwrz.quizapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class QuizResponseDto {

    private Integer id;
    private String title;
    private String text;
    private String[] options;
    @JsonIgnore
    private int[] answer;

    public QuizResponseDto(Integer id, String title, String text, String[] options, int[] answer) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int[] getAnswer() {
        return answer;
    }

    public void setAnswer(int[] answer) {
        this.answer = answer;
    }
}
