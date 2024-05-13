package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberMissionConverter;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MemberMissionService.MemberMissionCommandServiceImpl;
import umc.study.service.MissionService.MissionCommandServiceImpl;
import umc.study.validation.annotation.ExistMemberMissions;
import umc.study.web.dto.request.MemberMissionRequestDTO;
import umc.study.web.dto.response.MemberMissionResponseDTO;
import umc.study.web.dto.request.MissionRequestDTO;
import umc.study.web.dto.response.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {
    private final MissionCommandServiceImpl missionCommandService;
    private final MemberMissionCommandServiceImpl memberMissionCommandService;

    @PostMapping("/{storeId}")
    public ApiResponse<MissionResponseDTO.JoinResultDTO> join(@PathVariable Long storeId, @RequestBody @Valid MissionRequestDTO.JoinDto request){
        Mission mission = missionCommandService.joinMission(storeId, request);
        return ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(mission));
    }

    @PostMapping("/{storeId}/challenge")
    public ApiResponse<MemberMissionResponseDTO.AddChallengingMissionResultDTO> addChallengingMission(@PathVariable Long storeId,
            @RequestBody @ExistMemberMissions @Valid MemberMissionRequestDTO.JoinDto request
    ){
        MemberMission memberMission = memberMissionCommandService.addChallengingMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toAddChallengingMissionResultDTO(memberMission));
    }

}
