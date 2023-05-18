package au.davidwrz.quizapp.controller;

import au.davidwrz.quizapp.model.QuizAnswerDto;
import au.davidwrz.quizapp.model.QuizRequestDto;
import au.davidwrz.quizapp.model.QuizResponseDto;
import au.davidwrz.quizapp.service.QuizService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/quizzes")
class QuizController {

    private final QuizService service;

    public QuizController(QuizService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<QuizResponseDto>> getAllQuizzes() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getAllQuizzes());
    }

    @GetMapping("{id}")
    public ResponseEntity<QuizResponseDto> getQuiz(@PathVariable Integer id) {
        Optional<QuizResponseDto> optionalQuiz = service.getQuizById(id);
        return optionalQuiz
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .build());
    }

    @PostMapping("/{id}/solve")
    public ResponseEntity<?> answerQuestion(@PathVariable Integer id, @RequestBody QuizAnswerDto quizAnswer) {
        Optional<QuizResponseDto> quizById = service.getQuizById(id);
        return quizById.map(quizResponseDto -> ResponseEntity.ok(service.checkAnswer(quizResponseDto, quizAnswer)))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<QuizResponseDto> addQuiz(@Valid @RequestBody QuizRequestDto dto) {
        QuizRequestDto savedQuiz = new QuizRequestDto(dto.getTitle(), dto.getText(), dto.getOptions(), dto.getAnswer());
        QuizResponseDto responseDto = service.addQuiz(savedQuiz);
        return ResponseEntity.ok().body(responseDto);
    }
}
