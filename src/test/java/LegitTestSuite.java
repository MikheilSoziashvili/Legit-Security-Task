import org.testng.annotations.Test;

import java.util.List;

import static Steps.CartPageSteps.proceedAfterAddingItems;
import static Steps.HomePageSteps.pickProductsAndVerify;
import static Steps.LandingPageSteps.signIn;
import static Steps.OrdersPageSteps.validateOrders;

public class LegitTestSuite {
    private static final String userName = "mixeilsoziashvili@gmail.com";
    private static final String password = "Misho-2121";

    @Test (testName = "Legit test")
    public void taskFlow() {
        signIn(userName, password);
        List<Integer> indicesForOrdersValidation = pickProductsAndVerify();
        String orderId = proceedAfterAddingItems();
        validateOrders(orderId, indicesForOrdersValidation);
    }
}
