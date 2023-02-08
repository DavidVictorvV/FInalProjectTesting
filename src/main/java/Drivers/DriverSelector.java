package Drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSelector {

    public static ChromeDriver startChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static FirefoxDriver startFirefoxBrowser() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
