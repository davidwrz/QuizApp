package au.davidwrz.quizapp.modules.external.competition.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer questionId;
    boolean correct;
    @ManyToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;
    @Column(name = "attempt_timestamp")
    private LocalDateTime attemptTimestamp;

    public Attempt() {
    }

    private Attempt(Integer questionId, boolean correct, LocalDateTime attemptTimestamp) {
        this.questionId = questionId;
        this.correct = correct;
        this.attemptTimestamp = attemptTimestamp;
    }

    public static Attempt of(Integer questionId, boolean correct, LocalDateTime attemptTimestamp) {
        return new Attempt(questionId, correct, attemptTimestamp);
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attempt attempt = (Attempt) o;

        return Objects.equals(questionId, attempt.questionId);
    }

    @Override
    public int hashCode() {
        return questionId != null ? questionId.hashCode() : 0;
    }
}
