package umc.study.service.MissionService;

import jakarta.transaction.Transactional;
import umc.study.domain.Mission;
import umc.study.web.dto.request.MissionRequestDTO;

public interface MissionCommandService {
    @Transactional
    Mission joinMission(Long storeId, MissionRequestDTO.JoinDto request);
}
