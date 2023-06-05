package au.davidwrz.quizapp.modules.question.create.domain;

import jakarta.persistence.*;

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
}
