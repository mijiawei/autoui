package com.glow.cases;
/**
 * Created by mijiawei on 2019-03-15
 */
import java.io.File;
import com.glow.utils.extent.ExtentTestNGITestListener;
import macaca.java.biz.BaseErrorType;
import macaca.java.biz.BaseMacacaClient;
import macaca.java.biz.ResultGenerator;
import macaca.java.biz.BaseMacacaClient.PlatformType;
import com.glow.utils.Config;
import com.alibaba.fastjson.JSONObject;
import com.nikhaldimann.inieditor.IniEditor;

public class BaseTest {

	// 屏幕截图的数目，为了实现递增的顺序
	private int screenNum = 1;

	BaseMacacaClient driver = new BaseMacacaClient();

	public void getConfig() throws Exception {
		IniEditor user = new IniEditor();
		user.load(System.getProperty("user.dir") + File.separator + "device.ini");
		if (!user.get("default", "REUSE").equals("null")) {
			Config.REUSE = user.get("default", "REUSE");
		}
		if (!user.get("default", "PLATFORM").equals("null")) {
			Config.PLATFORM = user.get("default", "PLATFORM");
		}
		if (!user.get("user", "USER_NAME").equals("null")) {
			Config.USER_NAME = user.get("user", "USER_NAME");
		}
		if (!user.get("user", "PASSWORD").equals("null")) {
			Config.PASSWORD = user.get("user", "PASSWORD");
		}
	}

	public void commom_setUp(String port,String udid) throws Exception {

		// 清除日志记录
		ResultGenerator.clearOldData();
		//清理截图重新记录
		File file = new File(Config.ScreenshotPath);
		deleteOldScreen(file);

		try {
			getConfig();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 初始化应用基础信息
		JSONObject props = new JSONObject();
		if (Config.PLATFORM.equals("ios")) {

			// 创建ios实例
			props.put("app", Config.IOS_APP);
			props.put("platformName", Config.IOS_PLATFORM_NAME);
			props.put("deviceName", Config.IOS_DEVICE_NAME);
			props.put("udid", Config.IOS_UDID);
			props.put("autoAcceptAlerts",false);
			props.put("bundleId",Config.IOS_BUNDLE);
			//props.put("browserName", Config.IOS_BROWSER_NAME);
			driver.setCurPlatform(PlatformType.IOS);
		} else if (Config.PLATFORM.equals("android")) {

			//创建安卓实例
			props.put("app", Config.ADR_APP);
			props.put("platformName", Config.ADR_PLATFORM_NAME);
			//props.put("browserName", Config.ADR_BROWSER_NAME);
			//props.put("package", Config.ADR_PACKAGE);
			//props.put("activity", Config.ADR_LAUNCH_ACTIVITY);
			props.put("autoAcceptAlerts",true);
			props.put("resetKeyboard",true);
			props.put("unicodeKeyboard",true);
			props.put("udid", udid);
			driver.setCurPlatform(PlatformType.ANDROID);
		}

		// 覆盖安装
		props.put("reuse", Config.REUSE);

		JSONObject desiredCapabilities = new JSONObject();
		desiredCapabilities.put("host", "127.0.0.1"); // custom server  host
		desiredCapabilities.put("port", Integer.parseInt(port)); // custom server  port desiredCapabilities.put("desiredCapabilities", props);
		desiredCapabilities.put("desiredCapabilities", props);
		if(port.equals("3457")){
			Thread.sleep(1000);
		}
		driver.initDriver(desiredCapabilities);
		System.out.println(driver);
		ExtentTestNGITestListener.driver = driver;

	}

	/**
	 * 保存当前屏幕截图-生成的截图会按照截图的先后顺序生成有序的名称
	 *
	 * @param fileName 图片名称，默认为.png格式,图片默认保存在screenShot目录下
	 */
	public void saveScreen(String fileName) {
		try {
			// 判断是否存在对应目录，不存在的话则创建
			File file = new File(Config.ScreenshotPath);
			if (!file.exists() || !file.isDirectory()) {
				// 没有目录 创建截屏目录
				System.out.println("没有screenshot目录，创建目录");
				boolean isMkdirSucc = file.mkdir();
				if (isMkdirSucc) {
					System.out.println("创建screenshot目录成功");
				} else {
					System.out.println("创建screenshot目录失败");
				}
			} else {
				System.out.println("存在screenshot目录");
			}
			driver.saveScreenshot(
					Config.ScreenshotPath + File.separator + screenNum + "_" + fileName + ".png");
			screenNum++;
		} catch (Exception e) {
			// TODO: handle exception
			ResultGenerator.fail("截屏异常", "", BaseErrorType.FUNCTION_FAILED);
		}
	}

	//删除screenshot目录下旧的截图
	public static void deleteOldScreen(File oldScreen) {
		if (oldScreen.exists() && oldScreen.isDirectory()) {
			File[] files = oldScreen.listFiles();
			for (File file : files) {
				deleteOldScreen(file);
			}
		} else {
			oldScreen.delete();
		}

	}
}
