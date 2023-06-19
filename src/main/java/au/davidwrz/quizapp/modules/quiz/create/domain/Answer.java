package au.davidwrz.quizapp.modules.quiz.create.domain;

import jakarta.persistence.*;

@Entity
class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private boolean correct;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
