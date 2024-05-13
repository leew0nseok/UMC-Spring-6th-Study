package umc.study.service.MemberMissionService;

public interface MemberMissionQueryService {
    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);
}
