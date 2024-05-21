package umc.study.apiPayload.code;

import org.springframework.http.HttpStatus;
import umc.study.apiPayload.code.status.ErrorStatus;

public interface BaseErrorCode {



    public ErrorReasonDTO getReason();

    public ErrorReasonDTO getReasonHttpStatus();
}
