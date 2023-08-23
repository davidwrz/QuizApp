package au.davidwrz.quizapp.modules.external.competition.infrastructure.web;

import au.davidwrz.quizapp.modules.external.competition.application.CompetitionDto;
import au.davidwrz.quizapp.modules.external.competition.application.CompetitionFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/external/competition")
class CompetitionController {

    private final CompetitionFacade competitionFacade;

    CompetitionController(CompetitionFacade competitionFacade) {
        this.competitionFacade = competitionFacade;
    }

    @PostMapping("/save")
    ResponseEntity<?> saveCompetition(@RequestBody CompetitionDto competitionDto) {
        competitionFacade.save(competitionDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
