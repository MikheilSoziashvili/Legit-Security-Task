package Steps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

import static Pages.HomePage.orders;

import static Pages.OrdersPage.orderItems;
import static Utils.SetupClass.*;

public class OrdersPageSteps {

    public static void validateOrders(String orderId, List<Integer> productIndices) {
        findElement(orders).click();

        //Insurance scrolling if the order is not visible because they are not sorted in any way.
        new Actions(getDriver())
                .scrollToElement(findElement(orders))
                .build()
                .perform();

        int i = 0; // Used for iteration through indexes
        for (WebElement item : findElements(orderItems(orderId))) {
            if (i < productIndices.size()) { // Check if there are more product indices available
                int productIndex = productIndices.get(i); // Get the product index
                String productName = "Product " + (productIndex + 1);

                // Assert that the current order item matches the expected product name
                Assert.assertTrue(item.getText().contains(productName));

                i++; // Increment the index
            } else {
                // If there are no more product indices, break the loop
                break;
            }
        }
    }
}
