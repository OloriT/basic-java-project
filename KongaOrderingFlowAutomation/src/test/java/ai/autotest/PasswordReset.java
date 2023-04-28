package ai.autotest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PasswordReset {

    //import the selenium web driver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. open your Chrome browser
        driver = new ChromeDriver();
        //2. input your Konga Browser URL (https://www.konga.com/)
        driver.get("https://www.konga.com/");
        Thread.sleep(3000);
        //3. Maximise the browser
        driver.manage().window().maximize();
        //4. click on the Login/signup button to open the Login/Signup page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(3000);

    }

    @Test(priority = 0)
    public void ForgotPassword () throws InterruptedException {
        //5. click on forgot password to reset password
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[2]/label/a")).click();
        Thread.sleep(3000);
    }
    @Test(priority = 1)
    public void ValidEmail () throws InterruptedException {
        //Enter email in the email field
        driver.findElement(By.id("email")).sendKeys();
        Thread.sleep(3000);
        //Click on set reset Link
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/div/div[1]/div/form/div[2]/button")).click();

    }

    @AfterTest
    public void closeBrowser () {
        //Quit the browser
        driver.quit();
    }
}
