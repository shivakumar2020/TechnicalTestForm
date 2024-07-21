package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The Class BasePage.
 */
public class BasePage {
	
    /** The driver. */
    protected WebDriver driver;
    
    /** The wait. */
    private WebDriverWait wait;

    /**
     * Instantiates a new base page.
     *
     * @param driver the driver
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    /**
     * Wait for element.
     *
     * @param locator the locator
     * @return the web element
     */
    protected WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
   
}
