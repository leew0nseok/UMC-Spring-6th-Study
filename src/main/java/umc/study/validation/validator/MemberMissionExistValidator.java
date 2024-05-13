package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.xml.sax.ErrorHandler;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.StoreCategoryHandler;
import umc.study.service.MemberMissionService.MemberMissionQueryServiceImpl;
import umc.study.validation.annotation.ExistMemberMissions;
import umc.study.web.dto.request.MemberMissionRequestDTO;

@Component
@RequiredArgsConstructor
public class MemberMissionExistValidator implements ConstraintValidator<ExistMemberMissions, MemberMissionRequestDTO.JoinDto> {

    private final MemberMissionQueryServiceImpl memberMissionQueryService;
    @Override
    public void initialize(ExistMemberMissions constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MemberMissionRequestDTO.JoinDto value, ConstraintValidatorContext context) {
        boolean isValid = memberMissionQueryService.existsByMemberIdAndMissionId(value.getMemberId(), value.getMissionId());

        if (isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.EXITS_CHALLENGING_MISSION.toString()).addConstraintViolation();
        }
        return !isValid;
    }
}
