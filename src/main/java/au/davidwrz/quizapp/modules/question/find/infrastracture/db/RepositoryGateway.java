package au.davidwrz.quizapp.modules.question.find.infrastracture.db;

import au.davidwrz.quizapp.modules.question.find.domain.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("findQuestionRepositoryGateway")
public class RepositoryGateway {

    @Qualifier("findQuestionRepository")
    private final QuestionRepository questionRepository;

    private RepositoryGateway(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question findById(Integer id) {
        return questionRepository.findById(id).orElseThrow(QuestionNotFoundException::new);
    }
}
