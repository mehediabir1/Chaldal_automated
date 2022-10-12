import org.junit.Assert;
import org.openqa.selenium.WebDriver;
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
        SleepTime(3000);
        findByClass("close").click();

        //Taking Profile Name
        SleepTime(3000);
        String logCheck = findByXpath("//*[@id=\"page\"]/div/div[3]/div/div[1]/div[1]/div[5]").getText();

        Assert.assertEquals("ABIR",logCheck);
        System.out.println("TC_001 Passed");
    }

}
