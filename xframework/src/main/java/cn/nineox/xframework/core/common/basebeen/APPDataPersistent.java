package cn.nineox.xframework.core.common.basebeen;

import android.content.Context;

import com.google.gson.Gson;
import cn.nineox.xframework.core.common.Const;
import cn.nineox.xframework.core.common.utils.PreferenceUtils;

public class APPDataPersistent {

    public static APPDataPersistent mInstance = new APPDataPersistent();

    private UserBean userBean;


    public static APPDataPersistent getInstance() {
        return mInstance;
    }


    public UserBean getUserBean() {
        if (userBean == null) {
            userBean = new UserBean();
        }
        return userBean;
    }

    public void setUserBean(UserBean userBean,Context context) {
        this.userBean = userBean;
        PreferenceUtils.putString(Const.LOGIN_USER, new Gson().toJson(userBean), context);
    }
}
