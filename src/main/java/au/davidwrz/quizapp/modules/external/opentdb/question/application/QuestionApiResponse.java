package au.davidwrz.quizapp.modules.external.opentdb.question.application;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionApiResponse {

    @JsonProperty("results")
    private List<GeneratedQuestion> generatedQuestions;

    public GeneratedQuestion getGeneratedQuestion() {
        return generatedQuestions.get(0);
    }
}