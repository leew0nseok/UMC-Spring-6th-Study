package umc.study.web.dto.request;

import lombok.Getter;


public class MemberMissionRequestDTO {
    @Getter
    public static class JoinDto{
        private Long memberId;
        private Long missionId;
    }
}
