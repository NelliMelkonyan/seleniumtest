import java.util.concurrent.TimeUnit;
//--
import org.openqa.selenium.By;
//--
import org.openqa.selenium.WebDriver;
//--
import org.openqa.selenium.WebElement;
//--
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//--
import org.testng.Assert;
//--
import org.testng.annotations.AfterClass;
//--
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//--


public class OFTest {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void verifySearchButton() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://ofeditorialstg:OpenFitWeb2018@www.openfit.com/best-cozy-winter-products");


        WebElement button = driver.findElement(By.xpath("/html/body/div[4]/div[2]/a[1]/img"));
        Thread.sleep(3000);
        button.click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "", "Text not found!");
    }
}
