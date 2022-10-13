import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class Login extends Base{

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
    }

    @Test
    public static void TC_001() throws InterruptedException {
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
        SleepTime(5000);
        findByClass("close").click();

        //Taking Profile Name
        SleepTime(4000);
        String logCheck = findByXpath("//*[@id=\"page\"]/div/div[3]/div/div[1]/div[1]/div[5]").getText();

        Assert.assertEquals("ABIR",logCheck);
        System.out.println("TC_001 Passed");
    }
    @Test
    public static void Logout() throws InterruptedException {
        Thread.sleep(3000);

        Actions actions = new Actions(Base.driver);
        actions.moveByOffset(1420, 20).build().perform();
        //System.out.println("logout");
        //actions.moveToElement(findByXpath("//p[@class=\"oneWord\"]")).build().perform();
        //actions.moveToElement(Base.driver.findElement(By.xpath("//div[@class=\"loginArea loggedIn area-with-dropdown area hidden-xs\"]"))).perform();
        Thread.sleep(5000);
    }

}
