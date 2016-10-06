package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;

    public static void set(WebDriver driverInput) {
        driver = driverInput;
    }

    public static WebDriver get() {return driver;}

    public static void init() {

        switch (PropertyConfig.getProperty("test.browser")) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome" :
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
        }

        driver.manage().window().maximize();
        Driver.set(driver);
    }

    public static WebDriverWait getWait() {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(Driver.get(), 20);
        }
        return webDriverWait;
    }


    public static void tearDown() {
        Driver.get().quit();
    }
}

