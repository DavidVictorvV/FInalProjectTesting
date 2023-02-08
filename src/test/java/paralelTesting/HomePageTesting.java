package paralelTesting;

import Drivers.DriverSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTesting {

    WebDriver driver;

//    @BeforeClass


    @BeforeClass
    @Parameters({"browser", "url"})
    void setup(String browser, String app) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = DriverSelector.startChromeBrowser();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = DriverSelector.startFirefoxBrowser();
        }

        driver.get(app);
    }

    @Test
    void logoTest() throws InterruptedException {
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"logo\"]"));
        Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed on the page");
    }


    @Test(dependsOnMethods = {"logoTest"})
    void homepageTitle() throws InterruptedException {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Cinema Palace Oradea", "Title doesn't match");
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
