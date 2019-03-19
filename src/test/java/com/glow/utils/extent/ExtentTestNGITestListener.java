package com.glow.utils.extent;
/**
 * Created by micky on 17/1/25.
 */
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import macaca.client.MacacaClient;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.glow.utils.Config;

import java.io.File;

public class ExtentTestNGITestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance(Config.REPORTPath);
    private static ThreadLocal test = new ThreadLocal();
    public static MacacaClient driver;

    @Override
    public synchronized void onStart(ITestContext context) {
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        extent.flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        test.set(extent.createTest(result.getMethod().getMethodName()));
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        ((ExtentTest)test.get()).pass("Test passed");
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        ((ExtentTest)test.get()).fail(result.getThrowable());
        //File directory = new File(Config.REPORT);
        try {
            File file = new File(Config.REPORTPIC);
            if (!file.exists()){
                file.mkdirs();
            }
            String fileName = result.getMethod().getMethodName() +".png";
            driver.saveScreenshot(Config.REPORTPIC + fileName);
            ((ExtentTest)test.get()).addScreenCaptureFromPath(Config.REPORTPIC + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        ((ExtentTest)test.get()).skip(result.getThrowable());
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }
}