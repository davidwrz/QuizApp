package au.davidwrz.quizapp.integrationtests.modules.external.competition;

import au.davidwrz.quizapp.integrationtests.helpers.RegisterUserHelper;
import au.davidwrz.quizapp.modules.external.competition.application.CompetitionDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class SaveCompetitionITCase {

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private RegisterUserHelper registerUserHelper;

    private static final String SAVE_COMPETITION_URL = "/api/v1/external/competition/save";
    private String jwt;

    @BeforeEach
    void registerUser() {
        jwt = registerUserHelper.getJwtToken(webTestClient);
    }

    @Test
    @Sql(scripts = {"/db/integrationtests/deleteData.sql"}, executionPhase = AFTER_TEST_METHOD)
    void shouldGenerateQuestion() {
        CompetitionDto competitionDto = new CompetitionDto(1,1,true, LocalDateTime.now());

        webTestClient.post()
                .uri(SAVE_COMPETITION_URL)
                .accept(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, jwt)
                .body(Mono.just(competitionDto), CompetitionDto.class)
                .exchange()
                .expectStatus()
                .isCreated();
    }

}
