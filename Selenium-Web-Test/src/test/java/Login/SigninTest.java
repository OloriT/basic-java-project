package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class SigninTest {

    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. open your Chrome browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50000));
        //2. input your selenium demo page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        //3. Maximise the browser
        driver.manage().window().maximize();
        //4. click on the login button to open the login page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[1]")).click();

    }

    @Test(priority = 0)
    public void PositiveSignup() throws InterruptedException {
        //5. Input your email on the email field
        driver.findElement(By.id("session_email")).sendKeys(Constants.VALID_EMAIL);
        //6. Input your password on the password field
        driver.findElement(By.id("session_password")).sendKeys(Constants.VALID_PASSWORD);
        //7. Click on log in button to log in
        driver.findElement(By.xpath("/html/body/div[2]/form/div[3]/div/input")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void clickUser1item() throws InterruptedException {
        //9. click on the user to go to list
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
    }

        @Test(priority = 2)
        public void verifyItems() throws InterruptedException {
        //10. Click on user1 to go to list
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
            Thread.sleep(5000);
            //10. search for an item (using xpath) and confirm if it is present
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
            Thread.sleep(5000);
            //11. log out
            driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
            Thread.sleep(5000);
        }

    @AfterTest
    public void closeBrowser () {
        //Quit the browser
        driver.quit();
    }
}