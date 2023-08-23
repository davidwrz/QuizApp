package au.davidwrz.quizapp.modules.question.generate.domain;

import au.davidwrz.quizapp.modules.question.generate.application.GenerateQuestionDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
class ExternalApiCaller {

    private final WebClient webClient;

    private static final String GENERATE_QUESTION_URL = "http://localhost:8081/api/v1/external/opentdb/generate";

    public ExternalApiCaller(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(GENERATE_QUESTION_URL).build();
    }

    public GenerateQuestionDto generateQuestion(String token) {
        return webClient.get()
                .uri(GENERATE_QUESTION_URL)
                .accept(APPLICATION_JSON)
                .header(AUTHORIZATION, String.format("Bearer %s", token))
                .retrieve()
                .bodyToMono(GenerateQuestionDto.class)
                .block();
    }
}
