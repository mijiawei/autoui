package com.glow.pageuis_app_android;

import macaca.client.common.GetElementWay;
import macaca.java.biz.BasePageUI;
import macaca.java.biz.CommonUIBean;

/**
 * Created by mijiawei on 2019-03-18
 */
public class BillPaymentPageUI extends BasePageUI {

    public static final CommonUIBean MakePayment_Btn = new CommonUIBean(GetElementWay.XPATH, "//*[@text=\"Make payment\"]", "Make Payment Btn");
    public static final CommonUIBean AllCycles_Btn = new CommonUIBean(GetElementWay.XPATH, "//*[@text=\"All cycles\"]", "All cycles Btn");
    public static final CommonUIBean ExportPDF_Btn = new CommonUIBean(GetElementWay.XPATH, "//*[@text=\"Export PDF\"]", "Export PDF Btn");

    public static final CommonUIBean AmountDue_text = new CommonUIBean(GetElementWay.XPATH, "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[3]", "Amount Due text");

    public static final CommonUIBean Back_Btn = new CommonUIBean(GetElementWay.XPATH, "//*[@resource-id=\"android:id/content\"]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.ScrollView[1]/android.widget.ImageView[1]", "Back Btn");

}
