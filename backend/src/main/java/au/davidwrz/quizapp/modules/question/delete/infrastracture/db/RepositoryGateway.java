package au.davidwrz.quizapp.modules.question.delete.infrastracture.db;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("deleteRepositoryGateway")
public class RepositoryGateway {

    @Qualifier("deleteRepositoryGateway")
    private final QuestionRepository questionRepository;

    public RepositoryGateway(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void deleteQuestion(Integer id) {
        questionRepository.deleteById(id);
    }
}
