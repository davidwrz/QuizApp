package au.davidwrz.quizapp.modules.quiz.create.domain;

import jakarta.persistence.*;

@Entity
class Category {

    @Id
    @GeneratedValue
    private Integer id;
    @Enumerated(value = EnumType.STRING)
    private Type type;

}
