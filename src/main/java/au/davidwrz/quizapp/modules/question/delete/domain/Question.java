package au.davidwrz.quizapp.modules.question.delete.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(
            mappedBy = "question",
            cascade = CascadeType.REMOVE)
    private List<Answer> answers;

    public Question() {
    }

    public Integer getId() {
        return id;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

}
