package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utitilies.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter valid username

        sendTexttoElement(By.name("username"),"Lil1@yahoo.com");
        //Enter valid password
        sendTexttoElement(By.name("password"),"Lily123");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        // Verify the ‘Accounts Overview’ text is display
        WebElement verifyAccOverView = driver.findElement(By.xpath("//h1[@class='title']"));
        String actualMessage = getTextFromElement(By.xpath("//h1[@class='title']"));
        String expectedMessage = "Accounts Overview";
        Assert.assertEquals("Wrong Message", expectedMessage, actualMessage);

    }
    @Test
    public void verifyLogInErrorMessage() {
        // Enter invalid username

        sendTexttoElement(By.name("username"),"jet@yahoo.com");
        //Enter invalid password

        sendTexttoElement(By.name("password"),"jet123");

        //Click on ‘LOGIN’ button
         clickOnElement(By.xpath("//input[@value='Log In']"));
        // Verify the error message ‘The username and password could not be verified.’
        String actualMessage = getTextFromElement(By.xpath("//p[@class='error']"));
        String expectedMessage = "The username and password could not be verified.";
        //Assert.assertEquals("Error in Message", expectedMessage, actualMessage);
        Assert.assertEquals("Error in Message", expectedMessage, actualMessage);
    }
    @Test
    public void userShouldLogOutSuccessfully() {
        //Enter valid username

        sendTexttoElement(By.name("username"),"Lil1@yahoo.com");
        //Enter valid password

        sendTexttoElement(By.name("password"),"Lily123");
        //Click on ‘LOGIN’ button

        clickOnElement(By.xpath("//input[@value='Log In']"));
        //			* Click on ‘Log Out’ link

        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));
        //			* Verify the text ‘Customer Login’
        String actualText = getTextFromElement(By.xpath("//div[@id='leftPanel']//h2"));
        Assert.assertEquals("Wrong Text", "Customer Login", actualText);
    }
    @After
    public void tearDown() {
        closeBrowsers();
    }
}

