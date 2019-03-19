package com.glow.pageuis_app_android;

import macaca.client.common.GetElementWay;
import macaca.java.biz.BasePageUI;
import macaca.java.biz.CommonUIBean;

/**
 * Created by mijiawei on 2019-03-18
 */
public class JourneyPageUI extends BasePageUI {

    public static final CommonUIBean SeeAllSteps_Btn = new CommonUIBean(GetElementWay.XPATH, "//*[@text=\"See All Steps\"]", "See All Steps");
    public static final CommonUIBean RecommendedReading_link = new CommonUIBean(GetElementWay.XPATH, "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[4]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]", "RecommendedReading Article");
    public static final CommonUIBean Close_Btn = new CommonUIBean(GetElementWay.XPATH, "//*[@resource-id=\"android:id/content\"]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.ScrollView[1]/android.widget.ImageView[1]", "Close Btn");

}
