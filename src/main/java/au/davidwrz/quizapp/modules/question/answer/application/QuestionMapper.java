package au.davidwrz.quizapp.modules.question.answer.application;

import au.davidwrz.quizapp.modules.question.answer.domain.Answer;
import au.davidwrz.quizapp.modules.question.answer.domain.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class QuestionMapper {

    Question mapQuestion(au.davidwrz.quizapp.modules.question.find.domain.Question question) {
        return Question.of(question.getContent(), mapAnswer(question.getAnswers()));
    }

    private List<Answer> mapAnswer(List<au.davidwrz.quizapp.modules.question.create.domain.Answer> answers) {
        return answers.stream()
                .map(a -> Answer.of(a.getContent(), a.isCorrect()))
                .toList();
    }
}
