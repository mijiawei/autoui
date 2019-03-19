package com.glow.pageuis_app_android;

import macaca.client.common.GetElementWay;
import macaca.java.biz.BasePageUI;
import macaca.java.biz.CommonUIBean;

/**
 * Created by mijiawei on 2019-03-18
 */
public class SettingPageUI extends BasePageUI {

    public static final CommonUIBean Logout_Btn = new CommonUIBean(GetElementWay.XPATH, "//*[@text=\"Log out\"]", "Logout Btn");
    public static final CommonUIBean Logout_Submit = new CommonUIBean(GetElementWay.XPATH, "//*[@text=\"Log out\"]", "Logout Alert Submit");

}
