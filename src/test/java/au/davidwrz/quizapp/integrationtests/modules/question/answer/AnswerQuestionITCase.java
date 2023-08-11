package au.davidwrz.quizapp.integrationtests.modules.question.answer;

import au.davidwrz.quizapp.integrationtests.user.register.RegisterUserHelper;
import au.davidwrz.quizapp.modules.question.answer.application.AnswerResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class AnswerQuestionITCase {

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private ObjectMapper objectMapper;

    private static final String ANSWER_QUESTION_URL = "/api/v1/questions/1/solve";

    @Test
    @Sql(scripts = {"/db/integrationtests/createQuestion.sql"}, executionPhase = BEFORE_TEST_METHOD)
    @Sql(scripts = {"/db/integrationtests/deleteData.sql"}, executionPhase = AFTER_TEST_METHOD)
    void shouldAnswerCorrectly() {
        String jsonRequest = "{ \"answers\": [ { \"content\": \"Canberra\" } ] }";

        webTestClient.post()
                .uri(ANSWER_QUESTION_URL)
                .accept(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, RegisterUserHelper.getJwtToken(webTestClient))
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(jsonRequest), String.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(responseBody -> {
                    AnswerResult answerResult;
                    try {
                        answerResult = objectMapper.readValue(responseBody, AnswerResult.class);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                    assertEquals(AnswerResult.Result.CORRECT, answerResult.result());
                });
    }
}
