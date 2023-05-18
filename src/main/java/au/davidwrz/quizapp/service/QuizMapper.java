package au.davidwrz.quizapp.service;

import au.davidwrz.quizapp.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizMapper {

    public Quiz toEntity(QuizRequestDto quizDto) {
        return new Quiz(quizDto.getTitle(),
                quizDto.getText(),
                optionsToEntity(quizDto.getOptions()),
                answersToEntity(quizDto.getAnswer())
                );
    }

    private List<Option> optionsToEntity(String[] options) {
        if (options == null) {
            return new ArrayList<>();
        }
        List<Option> mappedOptions = new ArrayList<>();
        for (String option : options) {
            mappedOptions.add(new Option(option));
        }
        return mappedOptions;
    }

    private List<Answer> answersToEntity(int[] answers) {
        if (answers == null) {
            return new ArrayList<>();
        }
        List<Answer> mappedAnswers = new ArrayList<>();
        for (int i : answers) {
            mappedAnswers.add(new Answer(i));
        }
        return mappedAnswers;
    }

    private String[] optionsToDto(List<Option> options) {
        String[] mappedOptions = new String[options.size()];
        for (int i = 0; i < options.size(); i++) {
            mappedOptions[i] = options.get(i).getOption();
        }
        return mappedOptions;
    }

    private int[] answersToDto(List<Answer> answers) {
        int[] mappedAnswers = new int[answers.size()];
        for (int i = 0; i < answers.size(); i++) {
            mappedAnswers[i] = answers.get(i).getAnswer();
        }
        return mappedAnswers;
    }

    public QuizResponseDto toResponseDto(Quiz quiz) {
        return new QuizResponseDto(
                quiz.getId(),
                quiz.getTitle(),
                quiz.getText(),
                optionsToDto(quiz.getOptions()),
                answersToDto(quiz.getAnswer())
        );
    }
}
