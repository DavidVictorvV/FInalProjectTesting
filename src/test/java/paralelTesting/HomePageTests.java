package paralelTesting;

import CustomDataprovider.CustomDataProvider;
import Drivers.DriverSelector;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class HomePageTests {

    WebDriver driver;

    String url = "https://www.cinemapalace.ro/";


    //    @BeforeClass
    void setup(){
        driver = DriverSelector.startChromeBrowser();
        driver.get(url);
    }


    @Test(dataProvider = "LogInDataProvider", dataProviderClass = CustomDataProvider.class, groups = {"possibleFail"})
    void logInTest(String email, String pwd) throws InterruptedException {
        setup();

        driver.findElement(By.id("auth_inreg")).click();

        WebElement user = driver.findElement(By.name("user"));
        WebElement psw = driver.findElement(By.name("parola"));
        user.clear();
        user.sendKeys(email);
        psw.clear();
        psw.sendKeys(pwd);
        driver.findElement(By.id("btn_login")).click();

        Thread.sleep(1000);

        Assert.assertEquals(driver.getTitle(), "Home - CinemaPalace.ro","Didn't log in successfully");

    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }


}




