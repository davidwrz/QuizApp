package au.davidwrz.quizapp.integrationtests.modules.question.create;

import au.davidwrz.quizapp.integrationtests.helpers.RegisterUserHelper;
import au.davidwrz.quizapp.modules.question.create.application.AddQuestionDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class CreateQuestionITCase {

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private RegisterUserHelper registerUserHelper;

    private static final String CREATE_QUESTION_URL = "/api/v1/questions";
    private String jwt;

    @BeforeEach
    void registerUser() {
        jwt = registerUserHelper.getJwtToken(webTestClient);
    }

    @Test
    @Sql(scripts = {"/db/integrationtests/deleteData.sql"}, executionPhase = AFTER_TEST_METHOD)
    void shouldCreateQuestion() {
        List<AddQuestionDto.AddAnswerDto> answers = List.of(
                new AddQuestionDto.AddAnswerDto("Melbourne", false),
                new AddQuestionDto.AddAnswerDto("Sydney", false),
                new AddQuestionDto.AddAnswerDto("Canberra", true),
                new AddQuestionDto.AddAnswerDto("Brisbane", false)
        );
        AddQuestionDto question = new AddQuestionDto("What is the capital of Australia?", answers);

        webTestClient.post()
                .uri(CREATE_QUESTION_URL)
                .accept(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, jwt)
                .body(Mono.just(question), AddQuestionDto.class)
                .exchange()
                .expectStatus()
                .isCreated();
    }
}
