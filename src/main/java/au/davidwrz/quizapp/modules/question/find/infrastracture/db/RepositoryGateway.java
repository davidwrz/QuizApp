package au.davidwrz.quizapp.modules.question.find.infrastracture.db;

import au.davidwrz.quizapp.modules.question.find.domain.Question;
import org.springframework.stereotype.Service;

@Service
public class RepositoryGateway {

    private final QuestionRepository questionRepository;

    private RepositoryGateway(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question findById(Integer id) {
        return questionRepository.findById(id).orElseThrow(QuestionNotFoundException::new);
    }
}
