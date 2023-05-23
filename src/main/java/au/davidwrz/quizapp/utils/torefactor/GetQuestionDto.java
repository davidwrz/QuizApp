package au.davidwrz.quizapp.utils.torefactor;

import java.util.List;

public record GetQuestionDto(String content, List<AnswerDto> answers) {

    public static GetQuestionDto of(String content, List<String> answers) {
        return new GetQuestionDto(content,
                answers.stream()
                        .map(AnswerDto::new)
                        .toList());
    }

    private record AnswerDto(String content) {
    }
}
