package au.davidwrz.quizapp.modules.question.answer.domain;

import au.davidwrz.quizapp.modules.question.answer.application.AnswerQuestionDto;
import au.davidwrz.quizapp.modules.question.answer.application.AnswerResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerChecker {

    AnswerResult checkAnswer(Question question, AnswerQuestionDto answerQuestionDto) {
        List<String> correctAnswers = getCorrectAnswers(question);
        List<String> answers = getAnswers(answerQuestionDto);

        boolean equalAnswers = correctAnswers.equals(answers);
        return AnswerResult.of(equalAnswers);
    }

    private static List<String> getAnswers(AnswerQuestionDto answerQuestionDto) {
        return answerQuestionDto.getAnswers();
    }

    private List<String> getCorrectAnswers(Question question) {
        return question.getAnswers()
                .stream()
                .filter(Answer::isCorrect)
                .map(Answer::getContent)
                .toList();
    }
}
