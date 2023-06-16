package au.davidwrz.quizapp.modules.question.create.application;

class InvalidQuestionException extends RuntimeException {

    public InvalidQuestionException(String message) {
        super(message);
    }
}
