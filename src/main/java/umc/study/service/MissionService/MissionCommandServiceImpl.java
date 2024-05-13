package umc.study.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.StoreCategoryHandler;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.repository.MissionRespository;
import umc.study.repository.StoreRespository;
import umc.study.web.dto.MissionRequestDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRespository missionRespository;
    private final StoreRespository storeRespository;

    @Override
    @Transactional
    public Mission joinMission(Long storeId, MissionRequestDTO.JoinDto request) {
        // 음식점 조회
        Optional<Store> storeOptional = storeRespository.findById(storeId);
        if (storeOptional.isEmpty()) {
            throw new StoreCategoryHandler(ErrorStatus.STORE_NOT_FOUND);
        }
        Store store = storeOptional.get();

        Mission newMission = MissionConverter.toMission(store, request);

        return missionRespository.save(newMission);
    }
}
