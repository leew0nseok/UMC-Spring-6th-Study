package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {
    public static Mission toMission(Store store, MissionRequestDTO.JoinDto request){
        return Mission.builder()
                .store(store)
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .reward(request.getReward())
                .build();
    }

    public static MissionResponseDTO.JoinResultDTO toJoinResultDTO(Mission mission) {
        return MissionResponseDTO.JoinResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
