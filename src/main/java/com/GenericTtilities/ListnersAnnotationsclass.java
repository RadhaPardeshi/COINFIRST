package com.GenericTtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.GenericTtilities.BaseClass;
import com.GenericTtilities.WebdiverUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnersAnnotationsclass implements ITestListener
{
	ExtentReports report;
	
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log("Execution Starts from here ",true);


	}
    @Override
	public void onTestSuccess(ITestResult result) {

		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName);
		Reporter.log(MethodName+"---> executed successfully");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
//		System.out.println("entered");

		try {
			String screenshot = WebdiverUtility.getSceeenShot(BaseClass.sdriver, MethodName);
			test.log(Status.FAIL, MethodName+"--->failed ");
			test.log(Status.FAIL, result.getThrowable());

			test.addScreenCaptureFromPath(screenshot);

			Reporter.log(MethodName+"--->failed ");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"--> Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+"----> Skipped ");

	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/Report.html");
		htmlreport.config().setDocumentTitle("COINFIRST");
		htmlreport.config().setReportName("Online Banking");
		htmlreport.config().setTheme(Theme.STANDARD);

		report =new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base-Paltform", "Windows");
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/Online_Banking_System/");
		report.setSystemInfo("ReporterName", "Radha");

	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
