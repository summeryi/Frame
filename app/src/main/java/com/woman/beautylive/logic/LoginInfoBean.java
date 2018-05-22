package com.woman.beautylive.logic;

import android.text.TextUtils;

/**
 * Created by Administrator on 2017/11/15.
 */

public class LoginInfoBean {
    private String token;
    /**
     * id
     */
    private Long uid;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String headpic;


    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}