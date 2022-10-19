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

    //@Test
    public static void LOG_001() throws InterruptedException {
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
        System.out.println("LOG_001 Passed");
    }

    //@Test
    public static void LOG_002() throws InterruptedException {
        GetUrl("https://chaldal.com/");
        findByClass("signInBtn").click();
        SleepTime(2000);
        findByXpath("//*[@id=\"page\"]/div/div[1]/div/div/div/div[2]/div/form/div[1]/div/div/input").sendKeys("AbcDefg");
        SleepTime(2000);
        findByXpath("//*[@id=\"page\"]/div/div[1]/div/div/div/div[2]/div/form/div[3]/button").click();

        //input the otp
        SleepTime(2000);
        String numError = findByClass("errorContainer").getText();

        Assert.assertEquals("Please enter a valid bangladeshi number. e.g. +8801672955886",numError);
        System.out.println("LOG_002 Passed");
    }

    @Test //Email Login
    public static void LOG_003() throws InterruptedException {
        GetUrl("https://chaldal.com/");
        findByClass("signInBtn").click();
        SleepTime(2000);
        //Email Login Click
        findByClass("loginBtn emailLoginBtn").click();
        //email
        findByClass("input-placeholder").sendKeys("abir.riseuplabs@gmail.com");
        SleepTime(1000);
        findByClass("password").sendKeys("abir1100");

        SleepTime(2000);
        //Click Submit
        findByClass("loginBtn").click();

        //input the otp
        SleepTime(2000);
        String numError = findByClass("errorContainer").getText();

        Assert.assertEquals("Please enter a valid bangladeshi number. e.g. +8801672955886",numError);
        System.out.println("LOG_002 Passed");
    }

//    @Test
//    public static void Order() {
//        findByXpath("//*[@id=\"page\"]/div/div[3]/div/div[1]/div[1]/div[5]");
//        Actions actions = new Actions(Base.driver);
//        actions.moveToElement(findByXpath("//*[@id=\"page\"]/div/div[3]/div/div[1]/div[1]/div[5]")).build().perform();
//    }
}
