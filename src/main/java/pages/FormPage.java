package pages;

import java.io.File;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * The Class FormPage.
 */
public class FormPage extends BasePage {

	/** The url. */
	private String url = "https://go.gov.sg/gt-qe";

	/** The first name. */
	private By firstName = By.xpath("//input[@id='64532b5f00efba00121f117e']");
	
	/** The first name required. */
	private By firstNameRequired = By.xpath("//div[@id='64532b5f00efba00121f117e-feedback']/div");

	/** The last name. */
	private By lastName = By.xpath("//input[@id='64532b696a6af30013dc8321']");
	
	/** The last name required. */
	private By lastNameRequired = By.xpath("//div[@id='64532b696a6af30013dc8321-feedback']/div");

	/** The email field. */
	private By emailField = By.xpath("//input[@id='6453521e35eb0c00128fa97d']");
	
	/** The email field required. */
	private By emailFieldRequired = By.xpath("//div[@id='6453521e35eb0c00128fa97d-feedback']/div");

	/** The gender male. */
	private By genderMale = By.xpath("//div[@aria-label='4. Gender']//label[1]//span[1]");
	
	/** The gender female. */
	private By genderFemale = By.xpath("//div[@aria-label='4. Gender']//label[2]//span[1]");
	
	/** The gender required. */
	private By genderRequired = By.xpath("//div[@id='6453524b93ceeb0012cbe76e-feedback']/div");

	/** The gender male option. */
	private By genderMaleOption = By.xpath("//input[@id='radio-11']");
	
	/** The gender female option. */
	private By genderFemaleOption = By.xpath("//input[@id='radio-12']");

	/** The mobile numer. */
	private By mobileNumer = By.xpath("//input[@id='6453527335eb0c00128fbabf']");
	
	/** The mobile numer required. */
	private By mobileNumerRequired = By.xpath("//div[@id='6453527335eb0c00128fbabf-feedback']/div");

	/** The dob. */
	private By dob = By.xpath("//input[@id='645352c16dc31e001202f56f']");
	
	/** The date picker. */
	private By datePicker = By.xpath(
			"//body/div[@id='root']/div[1]/div[2]/div[4]/div[1]/div[1]/form[1]/div[1]/div[1]/div[6]/div[2]/div[1]/div[1]/button[1]");
	
	/** The dob required. */
	private By dobRequired = By.xpath("//div[@id='645352c16dc31e001202f56f-feedback']/div");

	/** The hobbies sport. */
	private By hobbiesSport = By.xpath("//div[@aria-label='7. Hobbies']//label[1]//span[1]//*[name()='svg']");
	
	/** The hobbies music. */
	private By hobbiesMusic = By.xpath("//div[@aria-label='7. Hobbies']//label[2]//span[1]//*[name()='svg']");
	
	/** The hobbies reading. */
	private By hobbiesReading = By.xpath("//div[@aria-label='7. Hobbies']//label[3]//span[1]//*[name()='svg']");
	
	/** The hobbies required. */
	private By hobbiesRequired = By.xpath("//div[@id='645354a681cb0e001299b47c-feedback']/div");

	/** The hobbies sport option. */
	private By hobbiesSportOption = By.xpath("(//input[@id='645354a681cb0e001299b47c'])[1]");
	
	/** The hobbies music option. */
	private By hobbiesMusicOption = By.xpath("(//input[@id='645354a681cb0e001299b47c'])[2]");
	
	/** The hobbies reading option. */
	private By hobbiesReadingOption = By.xpath("(//input[@id='645354a681cb0e001299b47c'])[3]");

	/** The attachment. */
	private By attachment = By.xpath("//input[@id='645354f093ceeb0012cc628a']");
	
	/** The location. */
	private By location = By.xpath("(//input[@id='6453551e00efba001225204b'])[1]");
	
	/** The address. */
	private By address = By.xpath("(//textarea[@id='6453553781cb0e001299cc83'])[1]");
	
	/** The submit. */
	private By submit = By.xpath("(//button[@class='chakra-button css-1szjd8b'])[1]");

	/** The form header. */
	private By formHeader = By.xpath("//h1[contains(text(),'Technical Test Form')]");
	
	/** The submit success messge. */
	private By submitSuccessMessge = By.xpath("//h2[contains(text(),'Thank you for filling out the form.')]");

	/**
	 * Instantiates a new form page.
	 *
	 * @param driver the driver
	 */
	public FormPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Open.
	 */
	public void open() {
		driver.get(url);
	}

	/**
	 * Verify page open.
	 */
	public void verifyPageOpen() {
		Assert.assertTrue(waitForElement(formHeader).isDisplayed());
	}

	/**
	 * Fill first name.
	 *
	 * @param fname the fname
	 */
	public void fillFirstName(String fname) {
		waitForElement(firstName).sendKeys(fname);
	}

	/**
	 * Fill last name.
	 *
	 * @param lname the lname
	 */
	public void fillLastName(String lname) {
		waitForElement(lastName).sendKeys(lname);
	}

	/**
	 * Fill email.
	 *
	 * @param email the email
	 */
	public void fillEmail(String email) {
		waitForElement(emailField).sendKeys(email);
	}

	/**
	 * Fill mobilel.
	 *
	 * @param mobile the mobile
	 */
	public void fillMobilel(String mobile) {
		waitForElement(mobileNumer).sendKeys(mobile);
	}

	/**
	 * Select gender option.
	 *
	 * @param gender the gender
	 */
	public void selectGenderOption(String gender) {
		if (gender.equalsIgnoreCase("male")) {
			waitForElement(genderMale).click();
		} else if (gender.equalsIgnoreCase("female")) {
			waitForElement(genderFemale).click();
		}
	}

	/**
	 * Select DOB.
	 *
	 * @param dt the dt
	 */
	public void selectDOB(String dt) {
		String dt1 = String.valueOf(Integer.valueOf(dt.substring(0, 2)));
		String dt2 = monthNumberToFullName(Integer.valueOf(dt.substring(3, 5)));
		String dt3 = dt.substring(6);
		waitForElement(datePicker).click();

		By year = By.xpath("(//div[@class='css-ufz58k'])[1]/div/div[2]");
		waitForElement(year).click();

		By selectYear = By.xpath(
				"//body/div[3]/div[1]/section[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/select[1]");
		new Select(waitForElement(selectYear)).selectByVisibleText(dt3);
		waitForElement(selectYear).click();

		By month = By.xpath("(//div[@class='css-ufz58k'])[1]/div/div[1]");
		waitForElement(month).click();

		By selectMonth = By.xpath(
				"//body/div[3]/div[1]/section[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]");
		new Select(waitForElement(selectMonth)).selectByVisibleText(dt2);
		waitForElement(selectMonth).click();

		List<WebElement> elements = driver.findElements(By.xpath("//button[contains(text(),'" + dt1 + "')]"));

		if (elements.size() == 2) {
			By day = By.xpath("(//button[contains(text(),'" + dt1 + "')])[2]");
			waitForElement(day).click();
		} else if (elements.size() >= 2) {
			By day = By.xpath("(//button[contains(text(),'" + dt1 + "')])[2]");
			for (int i = 1; i <= elements.size(); i++) {
				day = By.xpath("(//button[contains(text(),'" + dt1 + "')])[" + i + "]");
				if (Integer.valueOf(dt1) == Integer.valueOf(waitForElement(day).getText())) {
					day = By.xpath("(//button[contains(text(),'" + dt1 + "')])[" + i + "]");
					break;
				}
			}
			waitForElement(day).click();
		} else {
			By day = By.xpath("(//button[contains(text(),'" + dt1 + "')])[1]");
			waitForElement(day).click();
		}
	}

	/**
	 * Month number to full name.
	 *
	 * @param monthNumber the month number
	 * @return the string
	 */
	public String monthNumberToFullName(int monthNumber) {
		return Month.of(monthNumber).getDisplayName(TextStyle.FULL, Locale.getDefault());
	}

	/**
	 * Select hobbies option.
	 *
	 * @param hobbies the hobbies
	 */
	public void selectHobbiesOption(String hobbies) {
		if (hobbies.equalsIgnoreCase("sports")) {
			waitForElement(hobbiesSport).click();
		} else if (hobbies.equalsIgnoreCase("music")) {
			waitForElement(hobbiesMusic).click();
		} else if (hobbies.equalsIgnoreCase("reading")) {
			waitForElement(hobbiesReading).click();

		}
	}

	/**
	 * Upload file.
	 *
	 * @param filePath the file path
	 */
	public void uploadFile(String filePath) {
		File file = new File(filePath);
		waitForElement(attachment).sendKeys(file.getAbsolutePath());
	}

	/**
	 * Fill location.
	 *
	 * @param loc the loc
	 */
	public void fillLocation(String loc) {
		waitForElement(location).sendKeys(loc);
	}

	/**
	 * Fill address.
	 *
	 * @param add the add
	 */
	public void fillAddress(String add) {
		waitForElement(address).sendKeys(add);
	}

	/**
	 * Submit form.
	 */
	public void submitForm() {
		waitForElement(submit).click();
	}

	/**
	 * Verify successfull submit.
	 */
	public void verifySuccessfullSubmit() {
		Assert.assertTrue(driver.findElement(submitSuccessMessge).isDisplayed());
	}

	/**
	 * Verify first name.
	 *
	 * @return true, if successful
	 */
	public boolean verifyFirstName() {
		String expected = "This field is required";
		String actual_msg = " ";
		boolean errorMessage = false;
		if (driver.findElement(firstName).getAttribute("value").isEmpty()) {
			actual_msg = driver.findElement(firstNameRequired).getText();
			if (expected.equals(actual_msg))
				errorMessage = true;
		}
		return errorMessage;
	}

	/**
	 * Verify last name.
	 *
	 * @return true, if successful
	 */
	public boolean verifyLastName() {
		String expected = "This field is required";
		String actual_msg = " ";
		boolean errorMessage = false;
		if (driver.findElement(lastName).getAttribute("value").isEmpty()) {
			actual_msg = driver.findElement(lastNameRequired).getText();
			if (expected.equals(actual_msg))
				errorMessage = true;
		}
		return errorMessage;

	}

	/**
	 * Verify email.
	 *
	 * @return true, if successful
	 */
	public boolean verifyEmail() {
		String expected = "This field is required";
		String actual_msg = " ";
		boolean errorMessage = false;
		if (driver.findElement(emailField).getAttribute("value").isEmpty()) {
			actual_msg = driver.findElement(emailFieldRequired).getText();
			if (expected.equals(actual_msg))
				errorMessage = true;
		}
		return errorMessage;
	}

	/**
	 * Verify mobile.
	 *
	 * @return true, if successful
	 */
	public boolean verifyMobile() {
		String expected = "This field is required";
		String actual_msg = " ";
		boolean errorMessage = false;
		if (driver.findElement(mobileNumer).getAttribute("value").isEmpty()) {
			actual_msg = driver.findElement(mobileNumerRequired).getText();
			if (expected.equals(actual_msg))
				errorMessage = true;
		}
		return errorMessage;
	}

	/**
	 * Verify DOB.
	 *
	 * @return true, if successful
	 */
	public boolean verifyDOB() {
		String expected = "This field is required";
		String actual_msg = " ";
		boolean errorMessage = false;
		if (driver.findElement(dob).getAttribute("value").isEmpty()
				|| driver.findElement(dob).getAttribute("value").equals("dd/mm/yyyy")) {
			actual_msg = driver.findElement(dobRequired).getText();
			if (expected.equals(actual_msg))
				errorMessage = true;
		}
		return errorMessage;
	}

	/**
	 * Verify gender.
	 *
	 * @return true, if successful
	 */
	public boolean verifyGender() {
		String expected = "This field is required";
		String actual_msg = " ";
		boolean errorMessage = false;
		if ((!driver.findElement(genderMaleOption).isSelected())
				&& (!driver.findElement(genderFemaleOption).isSelected())) {
			actual_msg = driver.findElement(genderRequired).getText();
			if (expected.equals(actual_msg))
				errorMessage = true;
		}
		return errorMessage;
	}

	/**
	 * Verify hobbies.
	 *
	 * @return true, if successful
	 */
	public boolean verifyHobbies() {
		String expected = "This field is required";
		String actual_msg = " ";
		boolean errorMessage = false;
		if ((!driver.findElement(hobbiesSportOption).isSelected())
				&& (!driver.findElement(hobbiesMusicOption).isSelected())
				&& (!driver.findElement(hobbiesReadingOption).isSelected())) {
			actual_msg = driver.findElement(hobbiesRequired).getText();
			if (expected.equals(actual_msg))
				errorMessage = true;
		}
		return errorMessage;
	}
}
