package au.davidwrz.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private String option;

    public Option() {
    }

    public Option(String option) {
        this.option = option;
    }

    public Integer getId() {
        return id;
    }

    public String getOption() {
        return option;
    }
}
