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
    private List<AnswerRequestDto> answers;

    public String getContent() {
        return content;
    }

    public List<AnswerRequestDto> getAnswers() {
        return answers;
    }

    public record AnswerRequestDto(String answer, boolean correct) {
    }
}
