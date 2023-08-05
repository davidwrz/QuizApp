package au.davidwrz.quizapp.modules.question.create.application;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class AddQuestionDto {

    @NotBlank(message = "Content cannot be empty!")
    private String content;
    @NotNull(message = "Question must have answers!")
    private List<AddAnswerDto> answers;

    public String getContent() {
        return content;
    }

    @Size(min = 4, max = 4, message = "There has to be exactly four answers!")
    public List<AddAnswerDto> getAnswers() {
        return answers;
    }

    public record AddAnswerDto(String answer, boolean correct) {
    }
}
