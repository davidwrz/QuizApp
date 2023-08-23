package au.davidwrz.quizapp.modules.external.competition.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CompetitionDto {

    private Integer userId;
    private Integer questionId;
    private boolean correct;
    @JsonProperty(value = "localDateTime")
    private LocalDateTime time;

    public CompetitionDto() {
    }
}

