package au.davidwrz.quizapp.model;

import jakarta.persistence.*;

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

    public Question() {
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    private Question(String content, List<Answer> answers) {
        this.content = content;
        this.answers = answers;
    }

    static Question of(String content, List<Answer> answers) {
        return new Question(content,answers);
    }

    public List<String> getAnswers() {
        return answers.stream()
                .map(Answer::getContent)
                .toList();
    }
}
