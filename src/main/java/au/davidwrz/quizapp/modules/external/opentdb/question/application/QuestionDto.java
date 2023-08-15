package au.davidwrz.quizapp.modules.external.opentdb.question.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class QuestionDto {

    @JsonProperty("content")
    private String content;
    @JsonProperty("answers")
    private List<AnswerDto> answers;

    private QuestionDto(String content, List<AnswerDto> answers) {
        this.content = content;
        this.answers = answers;
    }

    public static QuestionDto of(String content, List<AnswerDto> answers) {
        return new QuestionDto(content, answers);
    }

    public record AnswerDto(String answer, boolean correct) {
    }
}
