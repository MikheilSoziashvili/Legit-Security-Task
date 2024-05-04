import org.testng.annotations.Test;

import static Steps.HomePageSteps.pickProducts;
import static Steps.LandingPageSteps.signIn;

public class LegitTestSuite {
    private static final String userName = "mixeilsoziashvili@gmail.com";
    private static final String password = "Misho-2121";

    @Test (testName = "Legit test")
    public void taskFlow() {
        signIn(userName, password);
        pickProducts();

    }
}
