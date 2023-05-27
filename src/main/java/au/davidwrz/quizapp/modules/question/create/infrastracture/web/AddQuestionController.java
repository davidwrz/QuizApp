package au.davidwrz.quizapp.modules.question.create.infrastracture.web;

import au.davidwrz.quizapp.utils.torefactor.GetQuestionDto;
import au.davidwrz.quizapp.modules.question.create.application.QuestionFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/questions")
class QuestionController {

    private final QuestionFacade service;

    public QuestionController(QuestionFacade service) {
        this.service = service;
    }


    @PostMapping
    ResponseEntity<?> addQuestion(@RequestBody AddQuestionDto addQuestionDto) {
        service.add(addQuestionDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("{id}")
    ResponseEntity<GetQuestionDto> getQuestion(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    ResponseEntity<List<GetQuestionDto>> getAllQuestions() {
        return ResponseEntity.ok(service.findAll());
    }
    
}
