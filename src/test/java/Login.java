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
        SleepTime(3000);
        String logCheck = findByXpath("//*[@id=\"page\"]/div/div[3]/div/div[1]/div[1]/div[5]").getText();
        //System.out.println(logCheck);

        Assert.assertEquals("015213296",logCheck);
        System.out.println("Passed");
    }
}
