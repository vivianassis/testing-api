package petstore;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.*;

import java.io.File;

public class BaseClass {
    protected ExtentTest test;
    protected ExtentReports extent;


    @BeforeMethod
    public void setUp() {
        System.out.println("Iniciando setUp...");
        extent = ExtentReportManager.getInstance();
        String testName = getClass().getSimpleName();
        test = ExtentReportManager.createTest(testName);
        test.info("Iniciando o teste: " + testName);
        test.assignCategory("Trainning");

        System.out.println("Concluindo setUp...");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        System.out.println("Iniciando Flush...");

        File extentReportsDir = new File("ExtentReports");
        if (!extentReportsDir.exists()) {
            extentReportsDir.mkdirs();
        }

        ExtentReportManager.getInstance().flush();
        System.out.println("Concluindo Flush...");

    }

}
