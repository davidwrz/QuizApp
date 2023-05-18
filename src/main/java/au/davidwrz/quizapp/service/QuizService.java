package au.davidwrz.quizapp.service;

import au.davidwrz.quizapp.model.*;
import au.davidwrz.quizapp.repository.QuizRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;

    public QuizService(QuizRepository repository, QuizMapper mapper) {
        this.quizRepository = repository;
        this.quizMapper = mapper;
    }

    public List<QuizResponseDto> getAllQuizzes() {
        return quizRepository.findAll()
                .stream()
                .map(quizMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public Optional<QuizResponseDto> getQuizById(Integer id) {
        Optional<Quiz> quizById = quizRepository.findById(id);
        return quizById.map(quizMapper::toResponseDto);
    }

    public QuizResponse checkAnswer(QuizResponseDto quizDto, QuizAnswerDto quizAnswer) {
        boolean answersNull = quizDto.getAnswer() == null && quizAnswer.getAnswer().length == 0;
        if (Arrays.equals(quizDto.getAnswer(), quizAnswer.getAnswer()) || answersNull) {
            return new QuizResponse(true, "Congratulations, you're right!");
        } else {
            return new QuizResponse(false, "Wrong answer! Please, try again.");
        }
    }

    @Transactional
    public QuizResponseDto addQuiz(QuizRequestDto quizDto) {
        Quiz quiz = quizMapper.toEntity(quizDto);
        quizRepository.save(quiz);
        return quizMapper.toResponseDto(quiz);
    }

    public void deleteQuizById(Integer id) {
        quizRepository.deleteById(id);
    }
}
