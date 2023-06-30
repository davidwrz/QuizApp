package au.davidwrz.quizapp.modules.quiz.create.domain;

import jakarta.persistence.*;
import org.springframework.data.annotation.Immutable;

import java.util.Collections;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    @OneToMany(
            mappedBy = "question",
            cascade = CascadeType.REMOVE)
    private List<Answer> answers;
    @ManyToMany(mappedBy = "questions")
    private List<Category> categories;

    public Question() {
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    private Question(String content) {
        this.content = content;
    }

    public static Question of(String content) {
        return new Question(content);
    }
}
