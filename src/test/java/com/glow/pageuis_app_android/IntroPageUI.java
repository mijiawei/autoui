package com.glow.pageuis_app_android;
/**
 * Created by mijiawei on 2019-03-15
 */
import macaca.java.biz.BasePageUI;
import macaca.java.biz.CommonUIBean;
import macaca.client.common.GetElementWay;

public class IntroPageUI extends BasePageUI {

    public static final CommonUIBean GetStarted_Btn = new CommonUIBean(GetElementWay.XPATH, "//*[@text=\"Get Started\"]", "WelcomePage: Get Started");
    public static final CommonUIBean Email_Input = new CommonUIBean(GetElementWay.XPATH, "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.EditText[1]","Email Input Box");
    public static final CommonUIBean NextStep_Btn = new CommonUIBean(GetElementWay.XPATH, "//*[@resource-id=\"android:id/content\"]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.Button[1]", "下一步");
    public static final CommonUIBean Password_Input = new CommonUIBean(GetElementWay.XPATH, "//*[@resource-id=\"android:id/content\"]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.EditText[2]", "Password输入框");

    public static final CommonUIBean Journey_Tab = new CommonUIBean(GetElementWay.XPATH, "//*[@text=\"Journey\"]", "Journey Tab");
    public static final CommonUIBean Coach_Tab = new CommonUIBean(GetElementWay.XPATH, "//*[@text=\"Coach\"]", "Coach Tab");
    public static final CommonUIBean Clinic_Tab = new CommonUIBean(GetElementWay.XPATH, "//*[@text=\"Clinic\"]", "Clinic Tab");

    public static final CommonUIBean Menu = new CommonUIBean(GetElementWay.XPATH,"//*[@resource-id=\"android:id/content\"]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.ImageView[1]","mune");
    public static final CommonUIBean BillPayment = new CommonUIBean(GetElementWay.XPATH,"//*[@text=\"Bills and payments\"]","Bills and payments");
    public static final CommonUIBean PaymentMethod = new CommonUIBean(GetElementWay.XPATH,"//*[@text=\"Payment methods\"]","Payment methods");
    public static final CommonUIBean Documents = new CommonUIBean(GetElementWay.XPATH,"//*[@text=\"Documents\"]","Documents");
    public static final CommonUIBean Settings = new CommonUIBean(GetElementWay.XPATH,"//*[@text=\"Settings\"]","Settings");


}

