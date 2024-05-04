package Pages;

import org.openqa.selenium.By;

import static Utils.SetupClass.getElementById;
import static Utils.SetupClass.getElementByText;

public class CartPage {
    public static final By proceedToCheckout = getElementByText("Proceed to Checkout");
    public static final By shippingAddress = getElementById("shipping-address-text");
    public static final By completeCheckout = getElementById("checkout-button");
}
