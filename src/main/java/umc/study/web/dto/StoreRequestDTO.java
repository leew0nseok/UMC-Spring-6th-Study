package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.study.domain.Region;
import umc.study.validation.annotation.ExistCategories;

import java.util.List;

public class StoreRequestDTO {
    @Getter
    public static class JoinDto{
        @NotBlank
        String name;
        @Size(min = 5, max = 12)
        String address;
        Region region;

    }
}
