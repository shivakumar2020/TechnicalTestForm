package tests;

import com.aventstack.extentreports.Status;

import pages.FormPage;
import util.CommonUtil;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class FormTest extends BaseTest {

	@DataProvider(name = "formData")
	public Object[][] getData() throws IOException {
		List<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader()
				.parse(new FileReader("data/test_data.csv")).getRecords();
		Object[][] data = new Object[records.size()][1];
		for (int i = 0; i < records.size(); i++) {
			data[i][0] = records.get(i).toMap();
		}
		return data;
	}

	@Test(dataProvider = "formData")
	public void testFormSubmission(java.util.Map<String, String> testData) {
		test = extent.createTest("Form Submission Test - " + testData.get("firstname"));

		System.out.println("Form Submission Test - " + testData.get("firstname"));
		try {
			FormPage formPage = new FormPage(driver);
			formPage.open();
			test.log(Status.INFO, "Navigated to form page");

			try {
				formPage.verifyPageOpen();
				test.log(Status.PASS, "Page launched successful");
			} catch (Exception e) {
				test.log(Status.FAIL, "Page launched failed");
				throw e;
			}

			formPage.fillFirstName(testData.get("firstname"));
			test.log(Status.INFO, "Filled first name");

			formPage.fillLastName(testData.get("lastname"));
			test.log(Status.INFO, "Filled last name");

			formPage.fillEmail(testData.get("email"));
			test.log(Status.INFO, "Filled email");

			formPage.selectGenderOption(testData.get("gender"));
			test.log(Status.INFO, "Selected gender");

			formPage.fillMobilel(testData.get("mobile"));
			test.log(Status.INFO, "Selected mobile");

			if (CommonUtil.isFutureDate(testData.get("dob")))
				test.log(Status.FAIL, "Date of brith can not future date");
			else {
				formPage.selectDOB(testData.get("dob"));
				test.log(Status.INFO, "Selected dob");
			}

			formPage.selectHobbiesOption(testData.get("hobbies"));
			test.log(Status.INFO, "Selected hobbies");

			formPage.uploadFile(testData.get("attachment"));
			test.log(Status.INFO, "Uploaded file");

			formPage.fillLocation(testData.get("location"));
			test.log(Status.INFO, "Selected location");

			formPage.fillAddress(testData.get("address"));
			test.log(Status.INFO, "Selected address");

			CommonUtil.waitForMilSeconds(2000);
			formPage.submitForm();
			test.log(Status.INFO, "Submitted form");

			try {
				formPage.verifySuccessfullSubmit();
				test.log(Status.PASS, "Form submission successful and success message is displayed");
			} catch (Exception e) {
				test.log(Status.FAIL, "Form submission is failed");

				if (formPage.verifyFirstName())
					test.log(Status.FAIL, "First Name is required field");
		
				if (formPage.verifyLastName())
					test.log(Status.FAIL, "Last Name is required field");

				if (formPage.verifyEmail())
					test.log(Status.FAIL, "Email is required field");

				if (formPage.verifyGender())
					test.log(Status.FAIL, "Gender is required field");

				if (formPage.verifyMobile())
					test.log(Status.FAIL, "Mobile is required field");

				if (formPage.verifyDOB())
					test.log(Status.FAIL, "DOB is required field");

				if (formPage.verifyHobbies())
					test.log(Status.FAIL, "Hobbies is required field");

				throw (e);
			}
		} catch (
		Exception e) {
			//e.printStackTrace();
			test.log(Status.FAIL, "Test failed due to exception: " + e.getMessage());
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}
}
