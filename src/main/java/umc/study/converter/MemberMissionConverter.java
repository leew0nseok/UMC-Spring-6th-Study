package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.response.MemberMissionResponseDTO;

public class MemberMissionConverter {

    public static MemberMission toMemberMission(Member member, Mission mission){
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();
    }

    public static MemberMissionResponseDTO.AddChallengingMissionResultDTO toAddChallengingMissionResultDTO(MemberMission memberMission){
        return MemberMissionResponseDTO.AddChallengingMissionResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(memberMission.getCreatedDate())
                .build();
    }
}
