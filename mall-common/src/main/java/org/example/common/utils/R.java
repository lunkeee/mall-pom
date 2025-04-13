package org.example.common.utils;

public class R<T> {

    /**
     * response code
     */
    private int code;

    /**
     * response message
     */
    private String message;

    /**
     * response result
     */
    private T result;

    public R() {
    }

    // 成功静态方法
    public static <T> R<T> success(T data) {
        return new R<>(200, "success", data);
    }

    // 失败静态方法
    public static <T> R<T> error(int code, String msg) {
        return new R<>(code, msg, null);
    }

    public R(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public R(int code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}