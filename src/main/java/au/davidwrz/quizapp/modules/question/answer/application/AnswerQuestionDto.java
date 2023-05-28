package au.davidwrz.quizapp.modules.question.answer.application;

import java.util.List;

public class AnswerQuestionDto {
    List<Answer> answers;

     record Answer(String content) {
    }
}
