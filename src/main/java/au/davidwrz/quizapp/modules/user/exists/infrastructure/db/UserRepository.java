package au.davidwrz.quizapp.modules.user.exists.infrastructure.db;

import au.davidwrz.quizapp.modules.user.exists.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("existsUserRepository")
interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByName(String name);
}
