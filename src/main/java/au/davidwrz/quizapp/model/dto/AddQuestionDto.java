package au.davidwrz.quizapp.model.dto;

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

    private record AnswerRequestDto(String answer, boolean correct) {
    }
}
