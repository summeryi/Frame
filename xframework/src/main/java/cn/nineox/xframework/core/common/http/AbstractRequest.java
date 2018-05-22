package cn.nineox.xframework.core.common.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yanzhenjie.nohttp.Headers;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.RestRequest;
import com.yanzhenjie.nohttp.rest.StringRequest;

import cn.nineox.xframework.core.android.log.Log;

public abstract class AbstractRequest<T> extends RestRequest<Result<T>> {

    public AbstractRequest(String url, RequestMethod requestMethod) {
        super(url, requestMethod);
    }

    @Override
    public void onPreExecute() {
    }

    private String md5(String params) {
        return params;
    }

    @Override
    public Result<T> parseResponse(Headers headers, byte[] body) throws Exception {
        int responseCode = headers.getResponseCode();
        // 响应码正确，且包体不为空。
        if (responseCode == 200 && body != null && body.length > 0) {
            String result = StringRequest.parseResponseString(headers, body);
            Log.i("HTTP request>>>"+this.url());
            Log.i("HTTP response>>>"+result);
            try {
                org.json.JSONObject ob = new org.json.JSONObject(result);
                String status = ob.optString("status","");
                String message = ob.optString("message","");
                //这样处理是为了去掉returndata这一层
                if("success".equals(status)){
                    String value = ob.optString("data","");
                    T t = getResult(value);
                    return new Result<>(200, t,headers, message);
                }else{
                    return new Result<>(400, null,headers, message);
                }


            } catch (Exception e) { // 解析发生错误。
                String error = "服务器返回数据格式错误，请稍后重试";
                return new Result<>(responseCode, null, headers, error);
            }
        } else if (responseCode >= 400) { // 其它响应码处理。
            String result = StringRequest.parseResponseString(headers, body);

            String error = "服务器发生错误，请稍后重试";
            // 错误响应码时正常解析说明是服务器返回的json数据。
            // 非正常解析说明是服务器返回的崩溃信息html等。
            try {
                JSONObject jsonObject = JSON.parseObject(result);
                error = jsonObject.getString("message");
            } catch (Exception ignored) {
            }
            return new Result<>(responseCode, null, headers, error);
        } else {
            String error = "服务器返回数据格式错误，请稍后重试";
            return new Result<>(responseCode, null, headers, error);
        }
    }


    protected abstract T getResult(String responseBody) throws Exception;
}