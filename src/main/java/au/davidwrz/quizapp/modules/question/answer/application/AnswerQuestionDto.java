package au.davidwrz.quizapp.modules.question.answer.application;

import java.util.List;

public class AnswerQuestionDto {

    private List<Answer> answers;

    public List<String> getAnswers() {
        return answers.stream()
                .map(Answer::content)
                .toList();
    }

    record Answer(String content) {
    }
}
