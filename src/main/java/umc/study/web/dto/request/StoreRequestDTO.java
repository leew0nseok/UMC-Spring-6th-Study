package umc.study.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.study.domain.Region;

public class StoreRequestDTO {
    @Getter
    public static class JoinDto{
        @NotBlank
        String name;
        @Size(min = 5, max = 12)
        String address;
        Region region;

    }

    public class ReveiwDTO {
    }
}
