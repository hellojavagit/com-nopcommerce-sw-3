package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        String expectedMessage = "Welcome, Please Sign In!";
        clickOnElement(By.xpath("//a[contains(text(),'Log in')]"));

        //checking the welcome text
        verifyTextMessages("ErrorMessage", "Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        clickOnElement(By.xpath("//a[contains(text(),'Log in')]"));
        sendTextToElement(By.id("Email"), ("prime1234@gmail.com"));
        sendTextToElement(By.name("Password"), ("abcd123"));
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));
        verifyTextMessages("Error Message", "Log out", By.xpath("//a[normalize-space()='Log out']"));
    }

    @Test
    public void verifyTheErrorMessage() {
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        clickOnElement(By.xpath("//a[contains(text(),'Log in')]"));
        sendTextToElement(By.id("Email"), ("prime1234@gmail.com"));
        sendTextToElement(By.name("Password"), "abcd1234");
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));
        verifyTextMessages("Login is not Successfull", expectedMessage, By.xpath("//div[@class='message-error validation-summary-errors']"));

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}

