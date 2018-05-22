package cn.nineox.xframework.core.common.basebeen;

import android.text.TextUtils;

public class UserBean extends BaseResponse{
    /**
     * uid : 5736
     * name :
     * headPic :
     */
    /**
     * 用户ID
     */
    private int uid;
    /**
     * 会话 token
     */
    private String token;


    private String name;

    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean hasLogin() {
        return !TextUtils.isEmpty(token);
    }


}

