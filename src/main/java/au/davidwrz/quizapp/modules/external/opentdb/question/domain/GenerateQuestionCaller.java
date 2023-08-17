package au.davidwrz.quizapp.modules.external.opentdb.question.domain;

import au.davidwrz.quizapp.modules.external.opentdb.question.application.QuestionApiResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
class GenerateQuestionCaller {

    private final WebClient webClient;

    private static final String GENERATE_QUESTION_URL = "https://opentdb.com/api.php?amount=1&type=multiple";

    GenerateQuestionCaller(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(GENERATE_QUESTION_URL).build();
    }

    QuestionApiResponse generateQuestionFromOpenTDB() {
        return webClient.get()
                .uri(GENERATE_QUESTION_URL)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(QuestionApiResponse.class)
                .block();
    }
}
