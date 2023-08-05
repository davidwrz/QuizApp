package au.davidwrz.quizapp.modules.question.create.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (!Objects.equals(id, question.id)) return false;
        if (!Objects.equals(content, question.content)) return false;
        return Objects.equals(answers, question.answers);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (answers != null ? answers.hashCode() : 0);
        return result;
    }
}
