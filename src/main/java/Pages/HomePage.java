package Pages;

import org.openqa.selenium.By;

import static Utils.SetupClass.findElement;
import static Utils.SetupClass.getElementByText;

public class HomePage {
    public static final By pageTitle = getElementByText("Online Shopping Website");
    public static final By addToCartButtons = getElementByText("Add to Cart");
}
