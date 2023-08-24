package au.davidwrz.quizapp.modules.question.answer.domain;

import au.davidwrz.quizapp.modules.question.eventpublisher.DomainEvent;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
class AnswerQuestionEvent extends DomainEvent {

    private Integer userId;
    private Integer questionId;
    private boolean correct;

    public AnswerQuestionEvent(Integer userId, Integer questionId, boolean correct, String jwt, LocalDateTime localDateTime) {
        super(jwt, localDateTime);
        this.userId = userId;
        this.questionId = questionId;
        this.correct = correct;
    }

}
