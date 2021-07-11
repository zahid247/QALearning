package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	public static ExtentReports extent;
	public static ExtentReports getReportObject() {
		// first we need to create a path for the folder to store the reports.
				String path = System.getProperty("user.dir") + "//reports//index.html";
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);

				reporter.config().setReportName("Automation Extent Results");
				reporter.config().setDocumentTitle("Test Results");

				extent = new ExtentReports();
				extent.attachReporter(reporter);

				extent.setSystemInfo("Tester", "Zahid A");
				return extent;
	}

}
