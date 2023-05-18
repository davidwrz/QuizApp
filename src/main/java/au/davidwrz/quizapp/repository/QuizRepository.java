package au.davidwrz.quizapp.repository;

import au.davidwrz.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

    List<Quiz> findAll();

    Optional<Quiz> findById(Integer id);

}