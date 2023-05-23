package au.davidwrz.quizapp.service;

import au.davidwrz.quizapp.exception.QuestionNotFoundException;
import au.davidwrz.quizapp.model.Answer;
import au.davidwrz.quizapp.model.Question;
import au.davidwrz.quizapp.model.dto.AddQuestionDto;
import au.davidwrz.quizapp.model.dto.GetQuestionDto;
import au.davidwrz.quizapp.repository.AnswerRepository;
import au.davidwrz.quizapp.repository.QuestionRepository;
import au.davidwrz.quizapp.service.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final Mapper mapper;

    public QuestionService(QuestionRepository repository, AnswerRepository answerRepository, Mapper mapper) {
        this.questionRepository = repository;
        this.answerRepository = answerRepository;
        this.mapper = mapper;
    }

    public void add(AddQuestionDto questionDto) {
        Question question = mapper.toQuestionEntity(questionDto);
        List<Answer> answers = questionDto.getAnswers()
                .stream()
                .map(mapper::toAnswerEntity)
                .toList();
        answers.forEach(a -> a.setQuestion(question));
        question.setAnswers(answers);
        questionRepository.save(question);
        answerRepository.saveAll(answers);
    }

    public void deleteById(Integer id) {
        Question question = questionRepository.findById(id).orElseThrow(QuestionNotFoundException::new);
        questionRepository.deleteById(question.getId());
    }

    public List<GetQuestionDto> findAll() {
        return questionRepository.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    public GetQuestionDto findById(Integer id) {
        return questionRepository.findById(id)
                .map(mapper::toResponseDto)
                .orElseThrow(QuestionNotFoundException::new);
    }
}
