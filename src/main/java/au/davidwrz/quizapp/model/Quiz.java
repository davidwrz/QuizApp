package au.davidwrz.quizapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String text;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Option> options;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Answer> answer;

    public Quiz() {
    }

    public Quiz(String title, String text, List<Option> options, List<Answer> answer) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public List<Option> getOptions() {
        return options;
    }
}
