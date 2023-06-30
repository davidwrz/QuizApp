package au.davidwrz.quizapp.modules.quiz.create.infrastracture.web;

import au.davidwrz.quizapp.modules.quiz.create.application.AddQuizDto;
import au.davidwrz.quizapp.modules.quiz.create.application.CreateQuizFacade;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/quiz")
class CreateQuizController {

    private final CreateQuizFacade service;

    CreateQuizController(CreateQuizFacade service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> addQuiz(@Valid @RequestBody AddQuizDto addQuizDto) {
        service.add(addQuizDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
