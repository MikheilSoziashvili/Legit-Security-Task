package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

import static Pages.HomePage.addToCartButtons;
import static Utils.SetupClass.findElements;

public class HomePageSteps {

    public static void pickProducts() {
        addRandomProductsToCart();
    }

    private static void addRandomProductsToCart() {
        Random random = new Random(); //Instance of Random

        // Find all 'Add to Cart' buttons on the page
        List<WebElement> cartButtons = findElements(addToCartButtons);

        // Ensure there are enough products to choose from
        if (cartButtons.size() < 2) {
            throw new IllegalStateException("Not enough products to perform the operation.");
        }

        // Select two different random indices
        int firstProductIndex = random.nextInt(cartButtons.size());
        int secondProductIndex = firstProductIndex;

        while (secondProductIndex == firstProductIndex) {
            secondProductIndex = random.nextInt(cartButtons.size());
        }

        // Click on the 'Add to Cart' buttons for two random different products
        cartButtons.get(firstProductIndex).click();
        cartButtons.get(secondProductIndex).click();
    }
}
