package au.davidwrz.quizapp.modules.user.register.infrastructure.db;

import au.davidwrz.quizapp.modules.user.register.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<User, Integer> {

}
