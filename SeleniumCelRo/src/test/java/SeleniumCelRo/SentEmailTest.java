package SeleniumCelRo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.awt.*;
import java.util.List;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.InterruptedIOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by vstancu on 10/26/2016.
 */
public class SentEmailTest {
    private WebDriver driver;


    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vstancu\\Documents\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://gmail.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(2000);
        //driver.close();
    }

    @Test
    public void testGmailSendEmail() throws InterruptedException
    {
        //write username
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='Email']"));
        usernameField.sendKeys("seleniumtest557@gmail.com");

        //press next button
        WebElement nextButton = driver.findElement(By.xpath("//input[@id='next']"));
        nextButton.click();

        //write password
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='Passwd']"));
        passwordField.sendKeys("pass1122");

        //press sign in
        WebElement signinButton = driver.findElement(By.xpath("//input[@id='signIn']"));
        signinButton.click();

        //press compose
        WebElement composeButton = driver.findElement(By.xpath("//div[text()=\"COMPOSE\"]"));
        composeButton.click();

        // TO FIELD

        WebElement toField = driver.findElement (By.xpath("//textarea[@aria-label='To']"));//creare element
        toField.sendKeys("seleniumtest579@gmail.com");
        //when we send many emails,the address becomes favourite and even if we write the address it won't go to the next step because of the dropdown that appears
        Robot robot1 = null;

        try {
            robot1 = new Robot();
        }
        catch (AWTException e)
        {
            e.printStackTrace();
        }

        robot1.keyPress(KeyEvent.VK_ENTER);
        robot1.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);

        //From Field Dropdown
        WebElement fromField = driver.findElement(By.xpath("//span[contains(., 'seleniumtest557@gmail.com')]"));
        fromField.click();
        List<WebElement> emailList = driver.findElements(By.xpath("//div[contains(@value,'@gmail.com')]"));
        emailList.get(0).click();


        //Subject field
        WebElement subjectField = driver.findElement(By.xpath("//input[@name='subjectbox']"));
        subjectField.sendKeys("Selenium Test Valentina Stancu");

        //Body Field

        WebElement bodyField = driver.findElement(By.xpath("//div[@aria-label='Message Body']"));
        bodyField.sendKeys("Selenium Test body");

        //press attachButton

        WebElement attachButton = driver.findElement(By.xpath("//div[@aria-label='Attach files']"));
        attachButton.click();


        StringSelection ss = new StringSelection("C:\\Users\\vstancu\\Documents\\SeleniumCel.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        Robot robot = null;

        try {
            robot = new Robot();
        }
        catch (AWTException e)
        {
            e.printStackTrace();
        }

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(5000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        //sendButton
        WebElement sendButton = driver.findElement(By.xpath("//div[contains(@aria-label,'Send')]"));
        sendButton.click();
        Thread.sleep(5000);

        //select user button from right corner
        WebElement userButton = driver.findElement(By.xpath("//span[@class = 'gb_8a gbii']"));
        userButton.click();

        //select the sign out button
        WebElement signOutButton = driver.findElement(By.xpath("//a[text() = 'Sign out']"));
        signOutButton.click();
        Thread.sleep(2000);
        //in case the browser asks us if we want to stay on the page or leave
        Robot robot2 = null;

        try {
            robot2 = new Robot();
        }
        catch (AWTException e)
        {
            e.printStackTrace();
        }

        robot2.keyPress(KeyEvent.VK_ENTER);
        robot2.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);

        //select change account button
        WebElement changeAccountButton= driver.findElement(By.id("account-chooser-link"));
        changeAccountButton.click();
        Thread.sleep(2000);

        //select add another account
        WebElement addAccountButton = driver.findElement(By.id("account-chooser-add-account"));
        addAccountButton.click();
        Thread.sleep(3000);

        //write username for the second account so we can check if the email was sent
        WebElement usernameFieldSecond = driver.findElement(By.xpath("//input[@id='Email']"));
        usernameFieldSecond.sendKeys("seleniumtest579@gmail.com");

        //press next button
        WebElement nextButtonSecond = driver.findElement(By.xpath("//input[@id='next']"));
        nextButtonSecond.click();

        //write password
        WebElement passwordFieldSecond = driver.findElement(By.xpath("//input[@id='Passwd']"));
        passwordFieldSecond.sendKeys("test1122");

        //press sign in
        WebElement signinButtonSecond = driver.findElement(By.xpath("//input[@id='signIn']"));
        signinButtonSecond.click();

       //select the email recieved from the list of emails

        List<WebElement> email = driver.findElements(By.cssSelector("div.xT>div.y6>span>b"));

        for(WebElement emailsub : email){
            if (emailsub.getText().equals("Selenium Test Valentina Stancu")== true) {

                emailsub.click();
                break;
            }
        }

        //click on download button
        WebElement downloadButton = driver.findElement(By.xpath("//div[@data-tooltip='Download']"));
        downloadButton.click();



    }



}
