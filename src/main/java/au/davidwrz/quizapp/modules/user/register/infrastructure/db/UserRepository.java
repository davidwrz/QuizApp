package au.davidwrz.quizapp.modules.user.register.infrastructure.db;

import au.davidwrz.quizapp.modules.user.register.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("registerUserRepository")
interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByName(String name);
}
