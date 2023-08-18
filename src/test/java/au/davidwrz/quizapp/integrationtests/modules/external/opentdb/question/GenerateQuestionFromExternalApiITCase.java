package au.davidwrz.quizapp.integrationtests.modules.external.opentdb.question;

import au.davidwrz.quizapp.integrationtests.helpers.RegisterUserHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class GenerateQuestionFromExternalApiITCase {

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private RegisterUserHelper registerUserHelper;

    private static final String GENERATE_QUESTION_URL = "/api/v1/external/opentdb/generate";
    private String jwt;

    @BeforeEach
    void registerUser() {
        jwt = registerUserHelper.getJwtToken(webTestClient);
    }

    @Test
    @Sql(scripts = {"/db/integrationtests/deleteData.sql"}, executionPhase = AFTER_TEST_METHOD)
    void shouldGenerateQuestion() {
        webTestClient.get()
                .uri(GENERATE_QUESTION_URL)
                .accept(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, jwt)
                .exchange()
                .expectStatus()
                .isOk();
    }
}
