package au.davidwrz.quizapp.modules.question.create.infrastracture.web;

import au.davidwrz.quizapp.modules.question.create.application.AddQuestionDto;
import au.davidwrz.quizapp.modules.question.create.application.CreateQuestionFacade;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/questions")
class AddQuestionController {

    private final CreateQuestionFacade service;

    public AddQuestionController(CreateQuestionFacade service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<?> addQuestion(@Valid @RequestBody AddQuestionDto addQuestionDto) {
        service.add(addQuestionDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

