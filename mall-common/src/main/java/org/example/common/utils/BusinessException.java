package org.example.common.utils;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int errorCode;
    private String errorMessage;

    public BusinessException() {
        super();
    }

    public BusinessException(BaseErrorInfoInterface errorInfoInterface) {
        super(String.valueOf(errorInfoInterface.getResultCode()));
        this.errorCode = errorInfoInterface.getResultCode();
        this.errorMessage = errorInfoInterface.getResultMsg();
    }

    public BusinessException(BaseErrorInfoInterface errorInfoInterface, Throwable cause) {
        super(String.valueOf(errorInfoInterface.getResultCode()), cause);
        this.errorCode = errorInfoInterface.getResultCode();
        this.errorMessage = errorInfoInterface.getResultMsg();
    }

    public BusinessException(String errorMsg) {
        super(errorMsg);
        this.errorMessage = errorMsg;
    }

    public BusinessException(int errorCode, String errorMsg) {
        super(String.valueOf(errorCode));
        this.errorCode = errorCode;
        this.errorMessage = errorMsg;
    }

    public BusinessException(int errorCode, String errorMsg, Throwable cause) {
        super(String.valueOf(errorCode), cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMsg;
    }


    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
