package au.davidwrz.quizapp.modules.question.answer.infrastracture.web;

import au.davidwrz.quizapp.modules.question.answer.application.AnswerQuestionDto;
import au.davidwrz.quizapp.modules.question.answer.application.AnswerQuestionFacade;
import au.davidwrz.quizapp.modules.question.answer.application.AnswerResult;
import au.davidwrz.quizapp.modules.user.register.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/questions")
class AnswerQuestionController {

    private final AnswerQuestionFacade service;

    public AnswerQuestionController(AnswerQuestionFacade service) {
        this.service = service;
    }

    @PostMapping("{id}/solve")
    ResponseEntity<AnswerResult> answerQuestion(@PathVariable Integer id,
                                                @RequestBody AnswerQuestionDto answerQuestionDto,
                                                @RequestHeader("Authorization") String authorizationHeader) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        String jwt = authorizationHeader.substring(7);
        return ResponseEntity.ok(service.answer(user.getId(), id, answerQuestionDto, jwt));
    }
}
