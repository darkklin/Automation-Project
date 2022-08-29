package utilities;

import io.appium.java_client.MobileDriver;
import io.qameta.allure.Allure;
import org.apache.commons.compress.utils.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Listeners extends CommonOps implements IInvokedMethodListener {
    File file;

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod() && !platform.equalsIgnoreCase("api")) {
            try {
//                MonteScreenRecorder.startRecord(testResult.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (!platform.equalsIgnoreCase("api")) {

            file = new File("./test-recordings/" + testResult.getName() + ".avi");
            if (method.isTestMethod() && !testResult.isSuccess()) {
                attachScreenShot(testResult.getName());
                try {
//                    MonteScreenRecorder.stopRecord();
//                    byte[] byteArr = IOUtils.toByteArray(new FileInputStream(file.getAbsolutePath()));
//                    Allure.addAttachment(testResult.getName() + "-video", "video/avi", new ByteArrayInputStream(byteArr), "avi");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
//                    MonteScreenRecorder.stopRecord();
                } catch (Exception e) {
                    System.out.println(" Failed to stop the recording ? " + e );
                }
//                file.delete();


            }

        }
    }

    public void attachScreenShot(String nameTest) {
        if (!(platform.equalsIgnoreCase("mobile"))) {
            Allure.addAttachment(nameTest, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        } else
            Allure.addAttachment(nameTest, new ByteArrayInputStream(((TakesScreenshot) mobileDriver).getScreenshotAs(OutputType.BYTES)));

    }


}
