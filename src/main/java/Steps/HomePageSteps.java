package Steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Pages.HomePage.addToCartButtons;
import static Pages.HomePage.shoppingCart;
import static Utils.SetupClass.*;

public class HomePageSteps {

    public static void pickProductsAndVerify() {
        List<Integer> addedProductIndices = addRandomProductsToCart();
//        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, 0);");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        findElement(shoppingCart).click();

        //Asserting that valid products are added by appending returned index of picked items to the cart product titles
        Assert.assertTrue(findElement(getElementByText("Product " + (addedProductIndices.get(0) + 1))).isDisplayed() &&
                findElement(getElementByText("Product " + (addedProductIndices.get(1) + 1))).isDisplayed());

//        return List<Integer> ;
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

        System.out.println(firstProductIndex + " " + secondProductIndex);

        // Click on the 'Add to Cart' buttons for two randomly selected different products
        cartButtons.get(firstProductIndex).click();
        cartButtons.get(secondProductIndex).click();

        // Add the indices to the list
        selectedIndices.add(firstProductIndex);
        selectedIndices.add(secondProductIndex);

        return selectedIndices;
    }

}
