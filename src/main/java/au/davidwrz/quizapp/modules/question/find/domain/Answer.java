package au.davidwrz.quizapp.modules.question.find.domain;

import au.davidwrz.quizapp.modules.question.create.domain.Question;
import jakarta.persistence.*;

@Entity
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

}
