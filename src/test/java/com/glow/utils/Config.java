package com.glow.utils;

import com.nikhaldimann.inieditor.IniEditor;

import java.io.File;
import java.io.IOException;


public class Config {

   // 根目录
   public static final String RootPath = System.getProperty("user.dir");
   //截图保存目录
   public static final String ScreenshotPath = RootPath + File.separator + "output/screenshot";
   //结果日志保存文件
   public static final String ResultLogPath = RootPath + File.separator + "result.log";

   // 用户名
   public static String USER_NAME = "zxcvbnm@qatest.com";
   // 密码
   public static String PASSWORD = "zxcvbnm";
   // 目标平台- ios android
   public static String PLATFORM = "android";
   // 0: 启动并安装;1: 卸载并重装 app;2: 仅重装 app;3: 在测试结束后保持 app 状态
   public static String REUSE = "3";

   // ios平台相关信息 各参数含义参考 https://macacajs.github.io/macaca/desired-caps.html
   public static final String IOS_PLATFORM_NAME = "iOS";
   public static final String IOS_DEVICE_NAME = "iPhone 6 Plus";
   //public static final String IOS_BROWSER_NAME = "Safari";
   public static final String IOS_APP = RootPath + File.separator + "app/ios-app-bootstrap.zip";
   public static String IOS_UDID = "2466e45b2af1a78ccaf858ca913230398e726d8b";
   public static final String IOS_BUNDLE = "com.baixing.iosbaixing";

   // 安卓平台相关信息
   public static final String ADR_PLATFORM_NAME = "android";
   public static final String ADR_BROWSER_NAME = "Chrome";
   public static final String ADR_APP = RootPath + File.separator + "app/app-development-debug.apk";
   //public static final String ADR_PACKAGE = "com.glow.patient.debug";
   public static final String ADR_LAUNCH_ACTIVITY = "";
   // 多台设备时，如果指定某一台设备可以在这里指定udid
   public static String ADR_UDID = "";

   //PC平台
   public static final String PC_PLATFORM_NAME = "desktop";
   public static final String PC_BROWSER_NAME = "electron";

   //extentReport
   public static final String REPORTPIC = RootPath + File.separator + "output/screenshot/";
   public static final String REPORTPath = RootPath + File.separator + "output/extent.html";

}
