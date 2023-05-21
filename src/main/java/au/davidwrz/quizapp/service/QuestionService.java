package au.davidwrz.quizapp.service;

import au.davidwrz.quizapp.exception.QuestionNotFoundException;
import au.davidwrz.quizapp.model.Question;
import au.davidwrz.quizapp.model.dto.AddQuestionDto;
import au.davidwrz.quizapp.model.dto.GetQuestionDto;
import au.davidwrz.quizapp.service.mapper.QuestionMapper;
import au.davidwrz.quizapp.utils.OwnCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService  {

    private final OwnCrudRepository<Question,Integer> repository;
    private final QuestionMapper mapper;

    public QuestionService(
            OwnCrudRepository<Question,Integer> repository,
            QuestionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void add(AddQuestionDto questionDto) {
        Question question = mapper.toEntity(questionDto);
        repository.save(question);
    }

    public void deleteById(Integer id) {
        Question question = repository.findById(id).orElseThrow(QuestionNotFoundException::new);
        repository.deleteById(question.getId());
    }

    public List<GetQuestionDto> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    public GetQuestionDto findById(Integer id) {
        return repository.findById(id)
                .map(mapper::toResponseDto)
                .orElseThrow(QuestionNotFoundException::new);
    }
}
