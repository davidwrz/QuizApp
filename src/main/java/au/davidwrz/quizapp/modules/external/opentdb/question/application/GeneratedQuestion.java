package au.davidwrz.quizapp.modules.external.opentdb.question.application;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GeneratedQuestion(
        @JsonProperty("question") String question,
        @JsonProperty("correct_answer") String correctAnswer,
        @JsonProperty("incorrect_answers") String[] incorrectAnswers
) {
}