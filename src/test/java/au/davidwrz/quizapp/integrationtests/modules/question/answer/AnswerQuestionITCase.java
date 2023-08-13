package au.davidwrz.quizapp.integrationtests.modules.question.answer;

import au.davidwrz.quizapp.integrationtests.helpers.RegisterUserHelper;
import au.davidwrz.quizapp.modules.question.answer.application.AnswerResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
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
    private RegisterUserHelper registerUserHelper;

    private static final String ANSWER_QUESTION_URL = "/api/v1/questions/1/solve";
    private String jwt;

    @BeforeEach
    void registerUser() {
        jwt = registerUserHelper.getJwtToken(webTestClient);
    }

    @Test
    @Sql(scripts = {"/db/integrationtests/createQuestion.sql"}, executionPhase = BEFORE_TEST_METHOD)
    @Sql(scripts = {"/db/integrationtests/deleteData.sql"}, executionPhase = AFTER_TEST_METHOD)
    void shouldReturnOkWhenAnswerIsCorrect() {
        String jsonRequest = "{ \"answers\": [ { \"content\": \"Canberra\" } ] }";

        AnswerResult answerResult = webTestClient.post()
                .uri(ANSWER_QUESTION_URL)
                .accept(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, jwt)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(jsonRequest), String.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<AnswerResult>() {
                }).returnResult()
                .getResponseBody();

        assertEquals(AnswerResult.Result.CORRECT, answerResult.result());
    }
}
