package au.davidwrz.quizapp.modules.question.generate.application;

import java.util.List;

public record GenerateQuestionDto(String content, List<GenerateAnswerDto> answers) {
     record GenerateAnswerDto(String answer, boolean correct) {
    }
}
