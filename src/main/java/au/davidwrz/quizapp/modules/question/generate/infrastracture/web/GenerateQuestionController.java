package au.davidwrz.quizapp.modules.question.generate.infrastracture.web;

import au.davidwrz.quizapp.modules.question.generate.application.GenerateQuestionDto;
import au.davidwrz.quizapp.modules.question.generate.application.GenerateQuestionFacade;
import au.davidwrz.quizapp.modules.user.register.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/question")
class GenerateQuestionController {

    private final GenerateQuestionFacade service;

    GenerateQuestionController(GenerateQuestionFacade service) {
        this.service = service;
    }

    @GetMapping("/generate")
    ResponseEntity<?> addQuestion(@RequestHeader("Authorization") String authorizationHeader) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        GenerateQuestionDto questionDto = service.generate(user, authorizationHeader.substring(7));
        return ResponseEntity.status(HttpStatus.CREATED).body(questionDto);
    }
}
