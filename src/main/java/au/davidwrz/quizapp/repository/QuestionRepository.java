package au.davidwrz.quizapp.repository;

import au.davidwrz.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findAll();

    Optional<Question> findById(Integer id);

}