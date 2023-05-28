package au.davidwrz.quizapp.modules.question.answer.infrastracture.db;

import org.springframework.stereotype.Service;

@Service
public class RepositoryGateway {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public RepositoryGateway(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }
}
