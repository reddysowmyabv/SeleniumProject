package resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreport {
	public static ExtentReports extent;

	public static ExtentReports getExtentreport(){
		String extentReportpath=System.getProperty("user.dir")+"\\reports\\extentreports.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(extentReportpath);
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Automation labs");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Seleninum version", "4.15.0");
		extent.setSystemInfo("Tested by", "sowmya");
		return extent;
	

}}
