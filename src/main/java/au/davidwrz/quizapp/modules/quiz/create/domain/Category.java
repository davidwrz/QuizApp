package au.davidwrz.quizapp.modules.quiz.create.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(value = EnumType.STRING)
    private Type type;
    @ManyToMany
    @JoinTable(
            name = "question_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions;

    public Category() {
    }

    private Category(Type type, List<Question> questions) {
        this.type = type;
        this.questions = questions;
    }

    public static Category of(Type type, List<Question> questions) {
        return new Category(type,questions);
    }
}
