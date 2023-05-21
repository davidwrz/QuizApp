package au.davidwrz.quizapp.service.mapper;

import au.davidwrz.quizapp.model.Question;
import au.davidwrz.quizapp.model.dto.AddQuestionDto;
import au.davidwrz.quizapp.model.dto.GetQuestionDto;
import org.springframework.stereotype.Service;

@Service
public class QuestionMapper {

    public GetQuestionDto toResponseDto(Question question) {
        return new GetQuestionDto();
    }

    public Question toEntity(AddQuestionDto questionDto) {
        return null;
    }
}
