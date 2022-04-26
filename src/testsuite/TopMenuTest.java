package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUP() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        //finding the computers element and clicking
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //verifying the expected and actual messages by using xpath as locator
        verifyTextMessages("Computer element not matching", "Computers",(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]")));
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() throws InterruptedException {

        mouseHoverAndClick(By.linkText("Electronics"));
        verifyTextMessages("Electronics element not matching", "Electronics",(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']")));
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {

        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
       verifyTextMessages("Apparel element does not match","Apparel",By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Apparel']"));
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {

        //clicking the digitaldownloads tab
        clickOnElement(By.linkText("Digital downloads"));
        //verifying the text Digital downloads
        verifyTextMessages("Digital Downloads element does not match","Digital downloads",By.xpath("//body/div[6]/div[2]/ul[1]/li[4]/a[1]"));
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {

        //finding the Books element and clicking
        clickOnElement(By.linkText("Books"));
        //verifying the text Books
       verifyTextMessages("Books element does not match", "Books",By.xpath("//body/div[6]/div[2]/ul[1]/li[5]/a[1]"));
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        //finding the jewellery tab present or not
        clickOnElement(By.linkText("Jewelry"));
        //verifying the text Jewelry;
        verifyTextMessages("Jewelry element does not match", "Jewelry",By.linkText("Jewelry"));

    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        //clicking the Giftcards element on page
        clickOnElement(By.linkText("Gift Cards"));
        //verifying the text Gift Cards
       verifyTextMessages("Gift Cards element does not match", "Gift Cards", By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Gift Cards']"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
