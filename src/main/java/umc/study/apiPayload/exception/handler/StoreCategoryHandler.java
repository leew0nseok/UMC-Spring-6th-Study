package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.exception.GeneralException;

public class StoreCategoryHandler extends GeneralException {
    public StoreCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
