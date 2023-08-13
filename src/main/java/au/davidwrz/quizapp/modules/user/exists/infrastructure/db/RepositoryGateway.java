package au.davidwrz.quizapp.modules.user.exists.infrastructure.db;

import au.davidwrz.quizapp.modules.user.exists.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("existsUserRepositoryGateway")
public class RepositoryGateway {

    @Qualifier("existsUserRepository")
    private final UserRepository repository;

    RepositoryGateway(UserRepository repository) {
        this.repository = repository;
    }

    public boolean existsUser(String name) {
        return repository.findByName(name).isPresent();
    }

    public Optional<User> findUserByName(String name) {
        return repository.findByName(name);
    }
}
