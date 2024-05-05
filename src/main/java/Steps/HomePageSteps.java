package Steps;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Pages.HomePage.addToCartButtons;
import static Pages.HomePage.shoppingCart;
import static Utils.SetupClass.*;

public class HomePageSteps {

    public static List<Integer> pickProductsAndVerify() {
        List<Integer> addedIndices = addRandomProductsToCart();
        findElement(shoppingCart).click();

        // Asserting that valid products are added
        int firstProductIndex = addedIndices.get(0);
        int secondProductIndex = addedIndices.get(1);
        Assert.assertTrue(isProductDisplayed(firstProductIndex) && isProductDisplayed(secondProductIndex));

        List<Integer> indicesForValidation = new ArrayList<>();
        indicesForValidation.add(firstProductIndex);
        indicesForValidation.add(secondProductIndex);

        return indicesForValidation;
    }

    private static boolean isProductDisplayed(int index) {
        String productName = "Product " + (index + 1);
        return findElement(getElementByText(productName)).isDisplayed();
    }


    protected static List<Integer> addRandomProductsToCart() {
        Random random = new Random();
        List<WebElement> cartButtons = findElements(addToCartButtons);
        List<Integer> selectedIndices = new ArrayList<>(); //For validation if correct products are added in the Shopping Cart

        if (cartButtons.size() < 2) {
            throw new IllegalStateException("Not enough products to perform the operation.");
        }

        // Generate two different random indices for selecting products
        int firstProductIndex = random.nextInt(cartButtons.size() - 2);
        int secondProductIndex = firstProductIndex;

        while (secondProductIndex == firstProductIndex) {
            secondProductIndex = random.nextInt(cartButtons.size());
        }

        // Click on the 'Add to Cart' buttons for two randomly selected different products
        cartButtons.get(firstProductIndex).click();
        cartButtons.get(secondProductIndex).click();

        // Add the indices to the list
        selectedIndices.add(firstProductIndex);
        selectedIndices.add(secondProductIndex);

        return selectedIndices;
    }

}
