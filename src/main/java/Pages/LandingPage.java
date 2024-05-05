package Pages;

import org.openqa.selenium.By;

import static Utils.SetupClass.getElementById;
import static Utils.SetupClass.getElementByText;

public class LandingPage {
    public static final By email = getElementById("amplify-id-:r1:");
    public static final By passwordInput = getElementById("amplify-id-:r4:");
    public static final By signIn = getElementByText("Sign in", "@type = 'submit'");
}
