package au.davidwrz.quizapp.modules.quiz.create.infrastracture.db;

import au.davidwrz.quizapp.modules.quiz.create.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
