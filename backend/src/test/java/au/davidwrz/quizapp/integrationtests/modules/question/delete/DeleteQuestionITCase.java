package au.davidwrz.quizapp.integrationtests.modules.question.delete;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class DeleteQuestionITCase {

    @Autowired
    private WebTestClient webTestClient;

    private static final String DELETE_QUESTION_URL = "/api/v1/questions/1";

    @Test
    @Sql(scripts = {"/db/integrationtests/createQuestion.sql"}, executionPhase = BEFORE_TEST_METHOD)
    @Sql(scripts = {"/db/integrationtests/deleteData.sql"}, executionPhase = AFTER_TEST_METHOD)
    void shouldCreateQuestion() {
        webTestClient.delete()
                .uri(DELETE_QUESTION_URL)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isNoContent();
    }
}
