package pages;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeTest {

    public WebDriver driver;

    @Before
    public void testDriver() {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\cansu\\Documents\\DEV\\Selenium\\ChromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.gittigidiyor.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @Test
    public void testHome() {
        /*WebElement loginhover = driver.findElement(By.cssSelector(""));
        Actions builder = new Actions(driver);
        builder.moveToElement(loginhover).perform();
        driver.findElement(By.cssSelector(".kNKwwK")).click();
        driver.findElement(By.id("L-UserNameField")).sendKeys("username");
        driver.findElement(By.id("L-PasswordField")).sendKeys("password");
        driver.findElement(By.xpath("//*[@id=\"gg-login-enter\"]")).click();*/

        //driver.get("https://www.gittigidiyor.com/uye-girisi");

        WebDriverWait wait = new WebDriverWait(driver ,60);
        driver.findElement(By.cssSelector(".gekhq4-5 > .gekhq4-6 > .gekhq4-4")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Giriş Yap']")));
        driver.findElement(By.xpath("//div[@title='Giriş Yap']")).click();

        driver.get("https://www.gittigidiyor.com/uye-girisi");

        driver.findElement(By.id("UserName")).sendKeys("cansubozkurtt4@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("");
        driver.findElement(By.id("login")).click();
    }

    @After
    public void testQuit() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.quit();
    }
}
