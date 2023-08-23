package au.davidwrz.quizapp.modules.question.eventpublisher;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DomainEvent {

    private String jwt;
    @Getter
    private LocalDateTime localDateTime;

    public DomainEvent(String jwt, LocalDateTime localDateTime) {
        this.jwt = jwt;
        this.localDateTime = localDateTime;
    }

}
