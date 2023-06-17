package au.davidwrz.quizapp.modules.question.create.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "createAnswer")
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private String content;
    private boolean correct;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer() {
    }

    private Answer(String content, boolean correct) {
        this.content = content;
        this.correct = correct;
    }

    public static Answer of(String content, boolean correct) {
        return new Answer(content, correct);
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        if (correct != answer.correct) return false;
        if (!Objects.equals(id, answer.id)) return false;
        if (!Objects.equals(content, answer.content)) return false;
        return Objects.equals(question, answer.question);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (correct ? 1 : 0);
        result = 31 * result + (question != null ? question.hashCode() : 0);
        return result;
    }
}
