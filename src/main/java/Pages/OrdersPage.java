package Pages;

import org.openqa.selenium.By;

public class OrdersPage {

    public static By orderItems(String orderId) {
        return By.xpath("//h2[contains(., '" + orderId + "')]//following-sibling::ul/li");
    }
}
