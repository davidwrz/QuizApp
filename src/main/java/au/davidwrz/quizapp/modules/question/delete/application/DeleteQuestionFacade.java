package au.davidwrz.quizapp.modules.question.delete.application;

import au.davidwrz.quizapp.modules.question.delete.infrastracture.db.RepositoryGateway;
import au.davidwrz.quizapp.modules.question.find.application.FindQuestionFacade;
import au.davidwrz.quizapp.modules.question.find.domain.Question;
import org.springframework.stereotype.Service;

@Service
public class DeleteQuestionFacade {

    private final FindQuestionFacade findQuestionFacade;
    private final RepositoryGateway repositoryGateway;

    public DeleteQuestionFacade(FindQuestionFacade findQuestionFacade, RepositoryGateway repositoryGateway) {
        this.findQuestionFacade = findQuestionFacade;
        this.repositoryGateway = repositoryGateway;
    }

    public void deleteQuestion(Integer id) {
        Question question = findQuestionFacade.findById(id);
        Integer questionId = question.getId();
        repositoryGateway.deleteQuestion(questionId);
    }
}
