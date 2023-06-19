package au.davidwrz.quizapp.modules.quiz.create.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
class Quiz {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private Category category;
    @OneToMany
    private List<Question> questions;
}
