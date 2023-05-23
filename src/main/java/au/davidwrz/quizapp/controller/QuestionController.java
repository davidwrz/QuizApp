package au.davidwrz.quizapp.controller;

import au.davidwrz.quizapp.model.dto.AddQuestionDto;
import au.davidwrz.quizapp.model.dto.GetQuestionDto;
import au.davidwrz.quizapp.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/questions")
class QuestionController {

    private final QuestionService service;

    public QuestionController(QuestionService service) {
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

    @DeleteMapping("{id}")
    ResponseEntity<?> deleteQuestionById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
