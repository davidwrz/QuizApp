package au.davidwrz.quizapp.modules.question.generate.application;

import au.davidwrz.quizapp.modules.question.generate.domain.GenerateQuestion;
import au.davidwrz.quizapp.modules.user.register.domain.User;
import org.springframework.stereotype.Service;

@Service
public class GenerateQuestionFacade {

    private final GenerateQuestion generateQuestion;

    public GenerateQuestionFacade(GenerateQuestion generateQuestion) {
        this.generateQuestion = generateQuestion;
    }

    public GenerateQuestionDto generate(User user, String token) {
        return generateQuestion.generateQuestionFromExternalApi(user, token);
    }
}
