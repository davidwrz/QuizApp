package au.davidwrz.quizapp.modules.user.exists.infrastructure.db;

import au.davidwrz.quizapp.modules.user.exists.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByName(String name);
}
