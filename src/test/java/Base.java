import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

import java.nio.file.Watchable;

public class Base  {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
    }
    @BeforeTest
    public static void ChromeOpen(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    public static void ChromeClose(){
        driver.quit();
    }

    public static void Login(){
        GetUrl("https://chaldal.com/");
        findByClass("signInBtn").click();
        SleepTime(2000);
        findByXpath("//*[@id=\"page\"]/div/div[1]/div/div/div/div[2]/div/form/div[1]/div/div/input").sendKeys("01521326396");
        SleepTime(2000);
        findByXpath("//*[@id=\"page\"]/div/div[1]/div/div/div/div[2]/div/form/div[3]/button").click();

        //input the otp
        SleepTime(15000);
        findByClass("btn-primary").click();

        //Clicking Previous Order as Close
        SleepTime(3000);
        findByClass("close").click();
    }
    public static void GetUrl(String URL){
        driver.get(URL);
    }

    public static WebElement findById(String Locator){
        return driver.findElement(By.id(Locator));
    }

    public static WebElement findByClass(String Locator){
        return driver.findElement(By.className(Locator));
    }

    public static WebElement findByCSS(String Locator){
        return driver.findElement(By.cssSelector(Locator));
    }

    public static WebElement findByXpath(String Locator){
        return driver.findElement(By.xpath(Locator));
    }

    public static WebElement findByName(String Locator){
        return driver.findElement(By.name(Locator));
    }

    public static void SleepTime(int time) throws InterruptedException {
        Thread.sleep(time);
    }

    public static void Utils(){

    }

}
