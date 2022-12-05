package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportdemo {
	
	ExtentReports extent;
	public void config() {
		
		//SlackTest.Sendmessage("KapivaAppUserWorkflow_PayOnline Test Started...");
		
		//extent.createTest("UserWokflow_PayOnline");
	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	
	reporter.config().setReportName("Mobile Automation Results");
	reporter.config().setDocumentTitle("Test Results");
	
	extent=new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Harish HJ");
	//SlackTest.Sendmessage("KapivaAppUserWorkflow_PayOnline Test End...");

	}

}
