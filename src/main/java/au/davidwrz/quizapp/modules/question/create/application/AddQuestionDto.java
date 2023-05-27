package au.davidwrz.quizapp.modules.question.create.infrastracture.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class AddQuestionDto {

    @NotBlank
    private String content;
    @NotNull
    private List<AddAnswerDto> answers;

    public String getContent() {
        return content;
    }

    public List<AddAnswerDto> getAnswers() {
        return answers;
    }

    public record AddAnswerDto(String answer, boolean correct) {
    }
}
