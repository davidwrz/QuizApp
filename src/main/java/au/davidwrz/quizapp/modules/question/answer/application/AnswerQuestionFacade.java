package au.davidwrz.quizapp.modules.question.answer.application;

import au.davidwrz.quizapp.modules.question.find.application.FindQuestionFacade;
import org.springframework.stereotype.Service;

@Service
public class AnswerQuestionFacade {

    private final AnswerChecker answerChecker;
    private final FindQuestionFacade findQuestionFacade;
    private final QuestionMapper questionMapper;

    public AnswerQuestionFacade(AnswerChecker answerChecker, FindQuestionFacade findQuestionFacade, QuestionMapper questionMapper) {
        this.answerChecker = answerChecker;
        this.findQuestionFacade = findQuestionFacade;
        this.questionMapper = questionMapper;
    }

    public AnswerResult answer(Integer questionId, AnswerQuestionDto answerQuestionDto) {
        var questionFindDomain = findQuestionFacade.findById(questionId);
        var question = questionMapper.mapQuestion(questionFindDomain);
        return answerChecker.checkAnswer(question, answerQuestionDto);
    }

}
