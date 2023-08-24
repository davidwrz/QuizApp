package au.davidwrz.quizapp.modules.external.competition.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    @Getter
    @OneToMany(mappedBy = "competition", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<Attempt> attempts = new HashSet<>();

    public Competition() {
    }

    private Competition(Integer userId) {
        this.userId = userId;
    }

    public static Competition of(Integer userId) {
        return new Competition(userId);
    }

    public void addAttempt(Attempt attempt) {
        attempts.add(attempt);
    }
}
