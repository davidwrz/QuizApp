package au.davidwrz.quizapp.modules.question.answer.domain;

public class Answer {

    private String content;
    private boolean correct;

    public Answer() {
    }

    private Answer(String content, boolean correct) {
        this.content = content;
        this.correct = correct;
    }

    public static Answer of(String content, boolean correct) {
        return new Answer(content, correct);
    }

    public String getContent() {
        return content;
    }

    public boolean isCorrect() {
        return correct;
    }
}
