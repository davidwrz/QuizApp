package au.davidwrz.quizapp.modules.question.answer.application;

public record AnswerResult(Result message) {

    public static AnswerResult of(boolean equalAnswers) {
        if (equalAnswers) {
            return new AnswerResult(Result.CORRECT);
        } else {
            return new AnswerResult(Result.FALSE);
        }

    }

    private enum Result {
        CORRECT("Congratulations! Correct answer!"), FALSE("Wrong! Please try again!");

        Result(String message) {
        }
    }
}


