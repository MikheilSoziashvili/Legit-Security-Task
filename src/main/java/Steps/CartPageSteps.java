package Steps;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Pages.CartPage.*;
import static Pages.HomePage.pageTitle;
import static Utils.SetupClass.*;

public class CartPageSteps {

    public static String proceedAfterAddingItems() {
        findElement(proceedToCheckout).click();
        findElement(shippingAddress).sendKeys("Test Address 1");
        findElement(completeCheckout).click();

        //Waiting until alert is present and then accepting it
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.alertIsPresent());
        String orderId = getDriver().switchTo().alert().getText();
        getDriver().switchTo().alert().accept();

        //Asserting redirect to main page after accepting alert
        Assert.assertTrue(findElement(pageTitle).isDisplayed());

        return orderId.substring("checkout complete: ".length());
    }
}
