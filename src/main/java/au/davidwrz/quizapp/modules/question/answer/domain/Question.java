package au.davidwrz.quizapp.modules.question.answer.domain;

import java.util.List;

public class Question {

    private final String content;
    private final List<Answer> answers;

    private Question(String content, List<Answer> answers) {
        this.content = content;
        this.answers = answers;
    }

    public static Question of(String content, List<Answer> answers) {
        return new Question(content, answers);
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
