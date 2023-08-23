package au.davidwrz.quizapp.modules.question.create.infrastracture.web;

import au.davidwrz.quizapp.modules.question.create.application.AddQuestionDto;
import au.davidwrz.quizapp.modules.question.create.application.CreateQuestionFacade;
import au.davidwrz.quizapp.modules.user.register.domain.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/questions")
class AddQuestionController {

    private final CreateQuestionFacade service;

    public AddQuestionController(CreateQuestionFacade service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<?> addQuestion(@Valid @RequestBody AddQuestionDto addQuestionDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        service.add(addQuestionDto, user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

