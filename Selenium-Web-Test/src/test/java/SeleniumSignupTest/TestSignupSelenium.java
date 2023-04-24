package SeleniumSignupTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class TestSignupSelenium {

    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. open your Chrome browser
        driver = new ChromeDriver();
        //2. input your selenium demo page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        sleep(Long.parseLong("10"));
        //3. Maximise the browser
        driver.manage().window().maximize();
        //4. click on the signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);

    }

    @Test(priority = 0)
    public void PositiveSignup() throws InterruptedException {
        //5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("tunde4");
        //6. Input your email on the email field
        driver.findElement(By.id("user_email")).sendKeys("tunde4@mailinator.com");
        //7. Locate your password and input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("speaker");
        //8. Click on submit button to submit
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void clickUser1item() throws InterruptedException {
        //9. click on the user1 item on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void verifyItems() throws InterruptedException {
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