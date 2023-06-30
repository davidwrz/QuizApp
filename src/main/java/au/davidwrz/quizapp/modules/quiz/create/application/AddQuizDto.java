package au.davidwrz.quizapp.modules.quiz.create.application;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record AddQuizDto(@NotNull String category, @NotEmpty List<AddQuestionDto> questions) {
}
