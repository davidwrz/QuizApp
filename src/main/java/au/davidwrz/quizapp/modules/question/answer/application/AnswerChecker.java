package au.davidwrz.quizapp.modules.question.answer.application;

import au.davidwrz.quizapp.modules.question.answer.domain.Answer;
import au.davidwrz.quizapp.modules.question.answer.domain.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class AnswerChecker {

    AnswerResult checkAnswer(Question question, AnswerQuestionDto answerQuestionDto) {
        List<String> correctAnswers = getCorrectAnswers(question);
        List<String> answers = getAnswers(answerQuestionDto);

        boolean equalAnswers = correctAnswers.equals(answers);
        return AnswerResult.of(equalAnswers);
    }

    private static List<String> getAnswers(AnswerQuestionDto answerQuestionDto) {
        return answerQuestionDto.answers
                .stream()
                .map(AnswerQuestionDto.Answer::content)
                .toList();
    }

    private List<String> getCorrectAnswers(Question question) {
        return question.getAnswers()
                .stream()
                .filter(Answer::isCorrect)
                .map(Answer::getContent)
                .toList();
    }
}
