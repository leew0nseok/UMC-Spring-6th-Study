package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank
        String missionSpec;
        @NotNull
        Integer reward;
        LocalDate deadline;
    }
}
