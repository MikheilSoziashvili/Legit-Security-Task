package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.List;

public class SetupClass {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public static List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public static By getElementByText(String text, String... conditions) {
        StringBuilder xpathBuilder = new StringBuilder("//*[text()='" + text + "'");
        for (String condition : conditions) {
            xpathBuilder.append(" and ").append(condition);
        }
        xpathBuilder.append("]");

        // Append additional XPath suffix if the last condition starts with a slash (indicating a path)
        if (conditions.length > 0 && conditions[conditions.length - 1].startsWith("/")) {
            xpathBuilder.append(conditions[conditions.length - 1]);
        }

        return By.xpath(xpathBuilder.toString());
    }

    public static By getElementById(String id, String... suffixes) {
        StringBuilder xpathBuilder = new StringBuilder("//*[@id='" + id + "']");
        for (String suffix : suffixes) {
            // Append the suffix directly since it's supposed to be a valid XPath
            xpathBuilder.append(suffix);
        }
        return By.xpath(xpathBuilder.toString());
    }

    @BeforeSuite
    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless"); // Run in headless mode (optional)
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-gpu"); // Disable GPU rendering (optional)
        chromeOptions.addArguments("--disable-extensions");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://main.d2t1pk7fjag8u6.amplifyapp.com/");
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
