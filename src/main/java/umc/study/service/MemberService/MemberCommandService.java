package umc.study.service.MemberService;

import umc.study.domain.Member;
import umc.study.web.dto.request.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
