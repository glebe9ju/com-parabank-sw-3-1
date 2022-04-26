package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utitilies.Utility;

import java.time.Duration;

public class RegisterTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        //click on the ‘Register’ link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        // Verify the text ‘Signing up is easy!
        String actualMessage =getTextFromElement(By.className("title"));
        String expectedMessage = "Signing up is easy!";
        Assert.assertEquals("Wrong Message", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //click on the ‘Register’ link

        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //Enter First name

        sendTexttoElement(By.id("customer.firstName"),"Lilya");
        //Enter Last name
        sendTexttoElement(By.id("customer.lastName"),"Lotus");
        //Enter Address
        sendTexttoElement(By.id("customer.address.street"),"105,Shaftbury");
        //Enter City
        sendTexttoElement(By.id("customer.address.city"),"Cardiff");
        // Enter State
        sendTexttoElement(By.id("customer.address.state"),("Wales"));
        //Enter Zip Code
         sendTexttoElement(By.id("customer.address.zipCode"),"WA19QT");
        //Enter Phone
        
        sendTexttoElement(By.id("customer.phoneNumber"),"12345678912");
        // Enter SSN

        sendTexttoElement(By.id("customer.ssn"),"12345");
        //Enter Username
        sendTexttoElement(By.id("customer.username"),"ghtytt2334@yahoo.co");
        //Enter Password
        sendTexttoElement(By.id("customer.password"),"Lily123");
        // Enter Confirm
        sendTexttoElement(By.id("repeatedPassword"),"Lily123");
        //Click on REGISTER button
        clickOnElement(By.xpath("//input[@value='Register']"));
        //Verify the text 'Your account was created successfully. You are now logged in.’
//        WebElement verifySignIn = driver.findElement(By.xpath("//div[@id='rightPanel']//p"));
//        String actualMessage = verifySignIn.getText();
        String actualMessage = getTextFromElement(By.xpath("//div[@id='rightPanel']//p"));

        String expectedMessage = "Your account was created successfully. You are now logged in.";
        Assert.assertEquals("Wrong Message", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowsers();

    }

}
