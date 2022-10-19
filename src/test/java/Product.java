import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Product extends Base {
    public static WebDriver driver;
    public static void main(String[] args) {
    }
    @Test
    public static void PROD_001() throws InterruptedException {
        GetUrl("https://chaldal.com/");
        SleepTime(1000);

        //searching
        findByClass("searchBox").sendKeys("Chips");
        SleepTime(5000);

        //adding to cart
        findByClass("imageWrapper").click();
        SleepTime(2000);

        //getting quantity
        String first = findByClass("quantity").getText();
        SleepTime(1000);
        findByClass("stickyHeader").click();
        SleepTime(1000);
        String second = findByClass("onHoverCursor").getText();
        //cart delete
        SleepTime(1000);
        findByClass("remove").click();
        Assert.assertEquals(first,second);
        System.out.println("PROD_001 Passed!");
    }
    @Test
    public static void PROD_002() throws InterruptedException {
        GetUrl("https://chaldal.com/");
        SleepTime(1000);

        //searching
        findByClass("searchBox").sendKeys("Pran");
        SleepTime(5000);

        //adding to cart x 10
        for (int i = 1; i <= 10; i++) {
            findByClass("imageWrapper").click();
            SleepTime(1000);
        }

        //getting quantity
        String first = findByClass("quantity").getText();
        SleepTime(1000);
        findByClass("stickyHeader").click();
        SleepTime(1000);
        String second = findByClass("onHoverCursor").getText();
        //cart delete
        SleepTime(1000);
        findByClass("remove").click();
        Assert.assertEquals(first,second);
        System.out.println("PROD_002 Passed!");
    }

    @Test
    //checking cart decrease.
    public static void PROD_003() throws InterruptedException {
        GetUrl("https://chaldal.com/");
        SleepTime(1000);

        //searching
        findByClass("searchBox").clear();
        findByClass("searchBox").sendKeys("Biscuits");
        SleepTime(5000);

        //adding to cart
        findByClass("imageWrapper").click();
        SleepTime(5000);

        //searching x 2
        findByClass("searchBox").clear();
        findByClass("searchBox").sendKeys("Chocolates");
        SleepTime(5000);


        //adding to cart
        findByClass("imageWrapper").click();

        String actual = "2 ITEMS";
        //getting quantity
        findByClass("stickyHeader").click();
        SleepTime(1000);
        String second = findByClass("itemCount").getText();
        //cart delete
        //findByClass("remove").click();
        SleepTime(1000);
        findByClass("remove").click();
        Assert.assertEquals(actual,second);
        System.out.println("PROD_003 Passed!");
    }
}
