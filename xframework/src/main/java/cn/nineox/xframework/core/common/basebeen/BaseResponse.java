package cn.nineox.xframework.core.common.basebeen;

/**
 * @author Muyangmin
 * @since 1.0.0
 */
public class BaseResponse<DataType> {

    public static final int RESULT_CODE_SUCCESS = 0;
    public static final int RESULT_CODE_TOKEN_EXPIRED = 401;

    /**
     * 通用返回值属性
     */
    private int code;
    /**
     * 通用返回信息。
     */
    private String msg;
    /**
     * 具体的内容。
     */
    private DataType data;

    private int yeyedata;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataType getData() {
        return data;
    }

    public void setData(DataType data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getYeyedata() {
        return yeyedata;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}