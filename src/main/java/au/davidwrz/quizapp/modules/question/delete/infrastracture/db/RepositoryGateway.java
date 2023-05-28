package au.davidwrz.quizapp.modules.question.delete.infrastracture.db;

import org.springframework.stereotype.Service;

@Service
public class RepositoryGateway {

    private final QuestionRepository questionRepository;

    public RepositoryGateway(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void deleteQuestion(Integer id) {
        questionRepository.deleteById(id);
    }
}
