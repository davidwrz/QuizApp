package au.davidwrz.quizapp.modules.external.opentdb.question.infrastructure.web;

import au.davidwrz.quizapp.modules.external.opentdb.question.domain.QuestionGenerator;
import au.davidwrz.quizapp.modules.external.opentdb.question.application.QuestionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/external/opentdb")
class GenerateExternalQuestionController {

    private final QuestionGenerator questionGenerator;

    GenerateExternalQuestionController(QuestionGenerator questionGenerator) {
        this.questionGenerator = questionGenerator;
    }

    @GetMapping("/generate")
    ResponseEntity<QuestionDto> generateQuestion() {
        return ResponseEntity.status(HttpStatus.OK).body(questionGenerator.generate());
    }
}
