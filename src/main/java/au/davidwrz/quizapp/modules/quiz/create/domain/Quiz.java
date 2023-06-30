package au.davidwrz.quizapp.modules.quiz.create.domain;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "quiz_questions",
            joinColumns = @JoinColumn(name = "quiz_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions;

    public Category getCategory() {
        return category;
    }

    public List<Question> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

    public List<Answer> getAllAnswers() {
        return questions.stream()
                .flatMap(question -> question.getAnswers().stream())
                .collect(Collectors.toList());
    }

    public Quiz() {
    }

    private Quiz(Category category, List<Question> questions) {
        this.category = category;
        this.questions = questions;
    }

    public static Quiz of(Category category, List<Question> questions) {
        return new Quiz(category, questions);
    }
}
