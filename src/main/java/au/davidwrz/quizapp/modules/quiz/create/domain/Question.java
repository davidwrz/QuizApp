package au.davidwrz.quizapp.modules.quiz.create.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
class Question {

    @Id
    @GeneratedValue
    private Integer id;
    private String content;
    @OneToMany(
            mappedBy = "question",
            cascade = CascadeType.REMOVE)
    private List<Answer> answers;
}
