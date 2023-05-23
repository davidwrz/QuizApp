package au.davidwrz.quizapp.utils.torefactor;

import au.davidwrz.quizapp.modules.question.create.domain.Question;
import au.davidwrz.quizapp.modules.question.create.infrastracture.db.AnswerRepository;
import au.davidwrz.quizapp.modules.question.create.infrastracture.db.QuestionRepository;
import au.davidwrz.quizapp.modules.question.create.infrastracture.web.Mapper;
import au.davidwrz.quizapp.modules.question.create.infrastracture.web.QuestionNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionFacade {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final Mapper mapper;

    public QuestionFacade(QuestionRepository repository, AnswerRepository answerRepository, Mapper mapper) {
        this.questionRepository = repository;
        this.answerRepository = answerRepository;
        this.mapper = mapper;
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
