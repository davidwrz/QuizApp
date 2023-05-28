package au.davidwrz.quizapp.modules.question.delete.infrastracture.web;

import au.davidwrz.quizapp.modules.question.delete.application.DeleteQuestionFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/questions")
class DeleteQuestionController {

    private final DeleteQuestionFacade service;

    public DeleteQuestionController(DeleteQuestionFacade service) {
        this.service = service;
    }

    @DeleteMapping("{id}")
    ResponseEntity<?> deleteQuestionById(@PathVariable Integer id) {
        service.deleteQuestion(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
