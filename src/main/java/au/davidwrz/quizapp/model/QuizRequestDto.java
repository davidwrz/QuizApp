package au.davidwrz.quizapp.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class QuizRequestDto {

    @NotBlank
    private String title;
    @NotBlank
    private String text;
    @NotNull
    private String[] options;
    private int[] answer;

    public QuizRequestDto() {
    }

    public QuizRequestDto(Integer id, String title, String text, String[] options, int[] answer) {
//        this.id = id;
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }

    public QuizRequestDto(String title, String text, String[] options, int[] correctAnswer) {
//        this.id = index++;
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = correctAnswer;
    }

//    public Integer getId() {
//        return id;
//    }

    public int[] getAnswer() {
        return answer;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String[] getOptions() {
        return options;
    }


}
