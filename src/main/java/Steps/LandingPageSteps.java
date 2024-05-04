package Steps;

import org.testng.Assert;

import static Pages.HomePage.pageTitle;
import static Pages.LandingPage.*;
import static Utils.SetupClass.findElement;

public class LandingPageSteps {

    public static void signIn(String username, String password) {
        findElement(email).sendKeys(username);
        findElement(passwordInput).sendKeys(password);
        findElement(signIn).click();

        Assert.assertTrue(findElement(pageTitle).isDisplayed());
    }
}
