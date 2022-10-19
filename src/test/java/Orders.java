import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Orders extends Base {

    @Test
    public static void Order() throws InterruptedException {
        Login();
        SleepTime(3000);
        //findByXpath("//*[@id=\"page\"]/div/div[3]/div/div[1]/div[1]/div[5]");

        //mouse action
        Actions actions = new Actions(Base.driver);
        actions.moveToElement(findByXpath("//*[@class=\"loginArea loggedIn area-with-dropdown area hidden-xs\"]")).build().perform();

        SleepTime(2000);
        findByXpath("//a[normalize-space()='Your Orders']").click();

        String orderNum = findByClass("the-id").getText();
        //orderNum = orderNum.replace(",","");
        SleepTime(1000);

        System.out.println(orderNum);
    }
}
