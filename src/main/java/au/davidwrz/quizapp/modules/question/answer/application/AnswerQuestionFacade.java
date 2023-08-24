package au.davidwrz.quizapp.modules.question.answer.application;

import au.davidwrz.quizapp.modules.question.answer.domain.AnswerQuestion;
import au.davidwrz.quizapp.modules.question.find.application.FindQuestionFacade;
import org.springframework.stereotype.Service;

@Service
public class AnswerQuestionFacade {

    private final FindQuestionFacade findQuestionFacade;
    private final QuestionMapper questionMapper;
    private final AnswerQuestion answerQuestion;

    public AnswerQuestionFacade(FindQuestionFacade findQuestionFacade, QuestionMapper questionMapper, AnswerQuestion answerQuestion) {
        this.findQuestionFacade = findQuestionFacade;
        this.questionMapper = questionMapper;
        this.answerQuestion = answerQuestion;
    }

    public AnswerResult answer(Integer userId, Integer questionId, AnswerQuestionDto answerQuestionDto, String jwt) {
        var questionFindDomain = findQuestionFacade.findById(questionId);
        var question = questionMapper.mapQuestion(questionFindDomain);
        return answerQuestion.checkAnswer(userId, questionId, question, answerQuestionDto, jwt);
    }

}
