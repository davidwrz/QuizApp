package au.davidwrz.quizapp.modules.question.create.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "createQuestion")
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    @OneToMany(
            mappedBy = "question",
            cascade = CascadeType.REMOVE)
    private List<Answer> answers;

    public Question() {
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
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
