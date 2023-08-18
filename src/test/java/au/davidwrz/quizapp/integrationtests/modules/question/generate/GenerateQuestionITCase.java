package au.davidwrz.quizapp.integrationtests.modules.question.generate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class GenerateQuestionITCase {

    @Autowired
    private WebTestClient webTestClient;

    private static final String GENERATE_QUESTION_URL = "/api/v1/questions/generate";

    @Test
    @Sql(scripts = {"/db/integrationtests/deleteData.sql"}, executionPhase = AFTER_TEST_METHOD)
    void shouldNotGenerateQuestionWhenUserNotRegistered() {
        webTestClient.get()
                .uri(GENERATE_QUESTION_URL)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isForbidden();
    }
}
