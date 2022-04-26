package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    String expectedMessage = "Register";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {

        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        verifyTextMessages("ErrorMessage", "Register",By.xpath("//h1[contains(text(),'Register')]"));
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() throws InterruptedException {
        //click the register button
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

        //selecting the gender button
        clickOnElement(By.xpath("//input[@id='gender-female']"));

        //sending firstname field
        sendTextToElement(By.name("FirstName"),"Hi");

        //sending last name value
        sendTextToElement(By.name("LastName"),"Hello");

        //sending the date of birth details
        selectByValueFromDropDown(By.name("DateOfBirthDay"),"10");

        selectByVisibleTextFromDropDown(By.name("DateOfBirthMonth"),"August");

        //yearOfBirth.sendKeys("1990");
        selectByValueFromDropDown(By.name("DateOfBirthYear"),"1990");

        Thread.sleep(3000);
        //sending email value
        sendTextToElement(By.name("Email"),"prime123@gmail.com");

        //sending password
        sendTextToElement(By.name("Password"),"abcd123");

        //confirming password
        sendTextToElement(By.name("ConfirmPassword"),"abcd123");

        //clicking the register button
        clickOnElement(By.id("register-button"));

        verifyTextMessages("Registration not completed","Your registration completed", By.xpath("//div[contains(text(),'Your registration completed')]"));
    }

    @After
    public void tearDown() {
        //closeBrowser();
    }
}
