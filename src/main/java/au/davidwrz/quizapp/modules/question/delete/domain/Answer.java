package au.davidwrz.quizapp.modules.question.delete.domain;

import jakarta.persistence.*;

@Entity(name = "delelteAnswer")
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer() {
    }
}
