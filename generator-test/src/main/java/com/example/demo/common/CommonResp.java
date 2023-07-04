package com.example.demo.common;

import lombok.Data;
import org.slf4j.MDC;

@Data
public class CommonResp<T> {

    private String code = "200";

    private String message = "ok";

    private String traceId;

    private T result;

    public CommonResp() {

    }

    public CommonResp(T result) {
        this.result = result;
        this.traceId = MDC.get("traceId");
    }

    public CommonResp(String code, String message) {
        this.code = code;
        this.message = message;
        this.traceId = MDC.get("traceId");
    }

    /**
     * 生成成功的返回结果
     * */
    public static <T> CommonResp<T> success(T result) {
        CommonResp<T> resp = new CommonResp<>(result);
        resp.setCode("200");
        resp.setMessage("ok");
        return resp;
    }

    /**
     * 生成成功的返回结果
     * */
    public static <T> CommonResp<T> success() {
        return new CommonResp<>();
    }

    public static CommonResp<Boolean> successOk() {
        CommonResp<Boolean> resp = new CommonResp<>();
        resp.setResult(true);
        return resp;
    }

    /**
     * 失败返回
     */
    public static <T> CommonResp<T> fail(String code, String message) {
        return new CommonResp<>(code, message);
    }



}
