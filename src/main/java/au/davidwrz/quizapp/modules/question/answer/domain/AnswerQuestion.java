package au.davidwrz.quizapp.modules.question.answer.domain;

import au.davidwrz.quizapp.modules.question.answer.application.AnswerQuestionDto;
import au.davidwrz.quizapp.modules.question.answer.application.AnswerResult;
import au.davidwrz.quizapp.modules.question.eventpublisher.DomainEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AnswerQuestion {

    private final AnswerChecker answerChecker;
    private final ApplicationEventPublisher eventPublisher;

    public AnswerQuestion(AnswerChecker answerChecker, ApplicationEventPublisher eventPublisher) {
        this.answerChecker = answerChecker;
        this.eventPublisher = eventPublisher;
    }

    public AnswerResult checkAnswer(Integer userId, Integer questionId, Question question, AnswerQuestionDto answerQuestionDto, String jwt) {
        AnswerResult answerResult = answerChecker.checkAnswer(question, answerQuestionDto);
        publishEvent(userId, questionId, isAnswerCorrect(answerResult), jwt);
        return answerResult;
    }

    private boolean isAnswerCorrect(AnswerResult answerResult) {
        return answerResult.result() == AnswerResult.Result.CORRECT;
    }

    private void publishEvent(Integer userId, Integer questionId, boolean correct, String jwt) {
        DomainEvent event = new AnswerQuestionEvent(userId, questionId, correct, jwt, LocalDateTime.now());
        eventPublisher.publishEvent(event);
    }
}
