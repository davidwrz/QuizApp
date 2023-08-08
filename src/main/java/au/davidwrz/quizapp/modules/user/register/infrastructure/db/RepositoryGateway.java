package au.davidwrz.quizapp.modules.user.register.infrastructure.db;

import au.davidwrz.quizapp.modules.user.register.domain.User;
import org.springframework.stereotype.Service;

@Service("createUserRepositoryGateway")
public class RepositoryGateway {

    private final UserRepository repository;

    RepositoryGateway(UserRepository repository) {
        this.repository = repository;
    }

    public void registerUser(User user) {
        repository.save(user);
    }
}
