package au.davidwrz.quizapp.modules.user.exists.application;

import au.davidwrz.quizapp.modules.user.exists.infrastructure.db.RepositoryGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ExistsUserFacade {

    @Qualifier("existsUserRepositoryGateway")
    private final RepositoryGateway repositoryGateway;

    ExistsUserFacade(RepositoryGateway repositoryGateway) {
        this.repositoryGateway = repositoryGateway;
    }

    public boolean existsUser(String name) {
        return repositoryGateway.existsUser(name);
    }
}
