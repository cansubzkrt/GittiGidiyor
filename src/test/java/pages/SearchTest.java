package pages;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {

    public WebDriver webDriver;

    @Before
    public void testDriver() {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\cansu\\Documents\\DEV\\Selenium\\ChromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.gittigidiyor.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @Test
    public void testSearch() {

        //Bilgisayar kelimisenin aranması
        WebDriver driver = new ChromeDriver();
        WebElement searchBox = driver.findElement(By.id("searchData"));
        searchBox.click();
        searchBox.sendKeys("Bilgisayar");
        driver.findElement(By.className("searchBtn")).click();

        //Rastgele bir ürün seçilmesi
        driver.findElement(By.xpath(".//*[@class=title r-onepp-title")).click();
        driver.findElement(By.xpath(".//*[@id= sp-title")).click();

        WebElement price= driver.findElement(By.xpath(".//*[@class='newPrice']/ins[1]"));
        String priceText= price.getText();

        //ürünün sepete eklenmesi
        WebElement sumBox = driver.findElement(By.id("sum"));
        sumBox.click();
        sumBox.clear();
        sumBox.sendKeys("1");

        WebElement basketBtn = driver.findElement(By.className("btnAddBasket"));
        basketBtn.click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.className("iconBasket")).click();

        //Ürün sayfasındaki fiyat ile sepetteki fiyatın karşılaştırılması
        WebElement priceBasket= driver.findElement(By.className("price"));
        String priceText2= priceBasket.getText();
        if(priceText.compareTo(priceText2)>0){

            //Sepetteki ürün adetinin arttırılması
            WebElement sumBasket = driver.findElement(By.id("sum_126685645817"));
            sumBasket.click();
            sumBasket.clear();
            sumBasket.sendKeys("1");
            driver.findElement(By.className("spinnerUp")).click();
        }
        //Sepetteki ürünlerin silinmesi
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.className("removeProd")).click();

    }

    @After
    public void quitDriver(){

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.quit();
    }

}
