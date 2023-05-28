package au.davidwrz.quizapp.modules.question.find.infrastracture.db;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
class QuestionNotFoundException extends RuntimeException {

    QuestionNotFoundException() {
        super("Question not found!");
    }
}
