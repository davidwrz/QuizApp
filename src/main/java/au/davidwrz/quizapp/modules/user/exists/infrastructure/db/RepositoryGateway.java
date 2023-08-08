package au.davidwrz.quizapp.modules.user.exists.infrastructure.db;

import org.springframework.stereotype.Service;

@Service("existsUserRepositoryGateway")
public class RepositoryGateway {

    private final UserRepository repository;

    RepositoryGateway(UserRepository repository) {
        this.repository = repository;
    }

    public boolean existsUser(String name) {
        return repository.existsByName(name);
    }
}
