package ValidLoginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaUserLogin {

    //import the selenium WebDriver
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
    public void ValidSignup () throws InterruptedException {
        //5. Input your email address or phone number in email/phone number field
        driver.findElement(By.id("username")).sendKeys(Constants.VALID_EMAIL);
        //6. Input your password in the password field
        driver.findElement(By.id("password")).sendKeys(Constants.VALID_PASSWORD);
        //7. Click on log in to log in to your account
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void SearchItem () throws InterruptedException {
        //8. Click on phones and tablet to see list
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[3]")).click();
        Thread.sleep(3000);
        //9. Add first item to my cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section[2]/section/ul/li[1]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(3000);
        //10. Add second item to my cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section[2]/section/ul/li[4]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(3000);
    }
    @Test(priority = 2)
            public void CheckCart() throws InterruptedException {
        //11. Go to my cart
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
        Thread.sleep(3000);
        //12. Close Cart Overview
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[1]/div/a/span")).click();
        Thread.sleep(3000);
        //13. Click on my account
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span")).click();
        Thread.sleep(3000);
        //Log out
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]")).click();
        Thread.sleep(3000);
    }

        @AfterTest
        public void closeBrowser () {
            //Quit the browser
            driver.quit();


    }

}
