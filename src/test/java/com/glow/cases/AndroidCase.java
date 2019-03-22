package com.glow.cases;
/**
 * Created by mijiawei on 2019-03-15
 */
import com.glow.utils.Config;
import macaca.java.biz.BaseErrorType;
import macaca.java.biz.ResultGenerator;
import macaca.java.biz.BaseUtils;
import com.glow.pages_app_android.*;
import com.glow.pageuis_app_android.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class AndroidCase extends BaseTest {

    @Parameters({"port","udid"})
    @BeforeClass
    public void setUp(String port,String udid) throws Exception {
        commom_setUp(port,udid);
        System.out.print("ok");
    }

    @AfterClass
    public void tearDown() throws Exception {
        try {
            driver.quit();
        } catch (Exception e) {
            // TODO: handle exception
            ResultGenerator.fail("quit fail", "", BaseErrorType.FUNCTION_FAILED);
        }
    }

    @Parameters({"udid"})
    @Test(description = "Login")
    public void test_000_login(String udid) throws Exception {
        IntroPage IntroPage = new IntroPage("LoginPage");
        IntroPage.setDriver(driver);
        driver.sleep(5000);
        driver.onclickBean(IntroPageUI.GetStarted_Btn);
        driver.sleep(2000);
        BaseUtils.exec2("adb -s "+ udid +" shell am broadcast -a ADB_INPUT_TEXT --es msg "+Config.USER_NAME);
        //driver.inputBean(IntroPageUI.Email_Input, Config.USER_NAME);
        driver.onclickBean(IntroPageUI.NextStep_Btn);
        driver.sleep(2000);
        //driver.inputBean(IntroPageUI.Password_Input,Config.PASSWORD);
        driver.onclickBean(IntroPageUI.Password_Input);
        BaseUtils.exec2("adb -s "+ udid +" shell am broadcast -a ADB_INPUT_TEXT --es msg "+Config.PASSWORD);
        driver.onclickBean(IntroPageUI.NextStep_Btn);

        Assert.assertTrue(IntroPage.hasPageShown(IntroPageUI.Journey_Tab));
//        if (IntroPage.hasPageShown(IntroPageUI.Journey_Tab)) {
//            ResultGenerator.loadPageSucc(IntroPage);
//        } else {
//            ResultGenerator.findElementFail(IntroPageUI.Journey_Tab);
//        }
    }

//    @Test(description = "Logout")
//    public void test_001_logout() throws Exception {
//        driver.onclickBean(IntroPageUI.Menu);
//        driver.onclickBean(IntroPageUI.Settings);
//        SettingPage SettingPage = new SettingPage("SettingPage");
//        SettingPage.setDriver(driver);
//        driver.onclickBean(SettingPageUI.Logout_Btn);
//        driver.onclickBean(SettingPageUI.Logout_Submit);
//
//        Assert.assertTrue(SettingPage.hasPageShown(IntroPageUI.GetStarted_Btn));
//    }

}