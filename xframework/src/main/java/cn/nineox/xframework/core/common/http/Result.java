package cn.nineox.xframework.core.common.http;

import com.yanzhenjie.nohttp.Headers;

public class Result<Result> {

    private int code;

    private Result result;

    private Headers headers;

    private String error;

    public Result() {
    }

    public Result(int code, Result result, Headers headers, String error) {
        this.code = code;
        this.result = result;
        this.headers = headers;
        this.error = error;
    }

    public boolean isSucceed() {
        if(this.code == 200){
            return true;
        }else{
            return false;
        }
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", result=" + result +
                ", headers=" + headers +
                ", error='" + error + '\'' +
                '}';
    }
}