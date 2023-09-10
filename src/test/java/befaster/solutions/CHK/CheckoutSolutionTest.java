package befaster.solutions.CHK;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import befaster.solutions.HLO.HelloSolution;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckoutSolutionTest {

    private CheckoutSolution checkout;

    @BeforeEach
    public void setUp() {
        checkout = new CheckoutSolution();
    }

    @Test
    public void compute_checkout() {
        assertThat(checkout.checkout("AAABBAAABB"), equalTo(350));
        assertThat(checkout.checkout("REAAABBAAABB"), equalTo(-1));
        //10 A's, 7B's = 130 * 3 + 3 * 45 = 525 + 50 + 30 = 605

        assertThat(checkout.checkout("AAAAAAAAAABBBBBBB"), equalTo(605));
        assertThat(checkout.checkout("ABC"), equalTo(100));
        assertThat(checkout.checkout("A"), equalTo(50));
    }
}

