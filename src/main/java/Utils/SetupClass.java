package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.List;

public class SetupClass {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Find a single WebElement using the specified locator.
     * @param locator The By locator to find the element.
     * @return The found WebElement.
     * @throws NoSuchElementException if the element cannot be found.
     */
    public static WebElement findElement(By locator) {
        try {
            return driver.findElement(locator);
        } catch (NoSuchElementException e) {
            System.err.println("Element not found: " + locator);
            throw e;
        }
    }

    /**
     * Find multiple WebElements using the specified locator.
     * @param locator The By locator to find elements.
     * @return A list of found WebElements.
     */
    public static List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    /**
     * Construct an XPath locator for elements containing specific text.
     * @param text The text to search for.
     * @param conditions Additional conditions for filtering the elements.
     * @return A By locator constructed from the input parameters.
     */
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

    /**
     * Construct an XPath locator for elements with a specific ID.
     * @param id The ID of the target element.
     * @param suffixes Additional suffixes to refine the search.
     * @return A By locator constructed from the input parameters.
     */
    public static By getElementById(String id, String... suffixes) {
        StringBuilder xpathBuilder = new StringBuilder("//*[@id='" + id + "']");
        for (String suffix : suffixes) {
            // Append the suffix directly since it's supposed to be a valid XPath
            xpathBuilder.append(suffix);
        }
        return By.xpath(xpathBuilder.toString());
    }

    /**
     * Initialize the Chrome WebDriver and launch the browser.
     */
    @BeforeSuite
    public void launchBrowser() {
        try {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();

            // Check for environment variable to determine if running in GitHub Actions
            String isGithubActions = System.getenv("GITHUB_ACTIONS");

            if ("true".equalsIgnoreCase(isGithubActions)) {
                chromeOptions.addArguments("--headless");
            }

            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            driver.get("https://main.d2t1pk7fjag8u6.amplifyapp.com/");
        } catch (Exception e) {
            System.err.println("Error during WebDriver setup: " + e.getMessage());
            throw new RuntimeException("Failed to launch browser", e);
        }
    }

    /**
     * Close the browser and clean up resources.
     */
    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
