package au.davidwrz.quizapp.modules.question.find.application;

import au.davidwrz.quizapp.modules.question.find.domain.Question;
import au.davidwrz.quizapp.modules.question.find.infrastracture.db.RepositoryGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FindQuestionFacade {

    @Qualifier("findQuestionRepositoryGateway")
    private final RepositoryGateway repositoryGateway;

    public FindQuestionFacade(RepositoryGateway repositoryGateway) {
        this.repositoryGateway = repositoryGateway;
    }

    public Question findById(Integer id) {
        return repositoryGateway.findById(id);
    }
}
