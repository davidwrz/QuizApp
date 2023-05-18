package au.davidwrz.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public
class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private Integer answer;

    public Answer() {
    }

    public Answer(Integer answer) {
        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAnswer() {
        return answer;
    }
}
