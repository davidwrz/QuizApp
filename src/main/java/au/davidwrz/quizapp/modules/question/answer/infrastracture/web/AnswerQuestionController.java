package au.davidwrz.quizapp.modules.question.answer.infrastracture.web;

import au.davidwrz.quizapp.modules.question.answer.application.AnswerQuestionDto;
import au.davidwrz.quizapp.modules.question.answer.application.AnswerQuestionFacade;
import au.davidwrz.quizapp.modules.question.answer.application.AnswerResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/questions")
class AnswerQuestionController {

    private final AnswerQuestionFacade service;

    public AnswerQuestionController(AnswerQuestionFacade service) {
        this.service = service;
    }

    @PostMapping("{id}/solve")
    ResponseEntity<AnswerResult> answerQuestion(@PathVariable Integer id, @RequestBody AnswerQuestionDto answerQuestionDto) {
        return ResponseEntity.ok(service.answer(id, answerQuestionDto));
    }
}
