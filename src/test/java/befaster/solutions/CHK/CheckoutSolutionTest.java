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

    /*
     - {"method":"checkout","params":["B"],"id":"CHK_R1_004"}, expected: 30, got: 80
 - {"method":"checkout","params":["C"],"id":"CHK_R1_005"}, expected: 20, got: 100
 - {"method":"checkout","params":["D"],"id":"CHK_R1_006"}, expected: 15, got: 115
     */

    @BeforeEach
    public void setUp() {
        checkout = new CheckoutSolution();
    }

    @Test
    public void compute_checkout() {
        assertThat(checkout.checkout("AAABBAAABB"), equalTo(350));
    }

    @Test
    public void test_illegal_argument() {
        assertThat(checkout.checkout("REAAABBAAABB"), equalTo(-1));
    }

    @Test
    public void test_multi_prices() {
        //10 A's, 7B's = 130 * 3 + 3 * 45 = 525 + 50 + 30 = 605
        assertThat(checkout.checkout("AAAAAAAAAABBBBBBB"), equalTo(605));
    }

    @Test
    public void test_all_prices() {
        assertThat(checkout.checkout("ABC"), equalTo(100));
    }

    @Test
    public void test_A() {
        assertThat(checkout.checkout("A"), equalTo(50));
    }

    @Test
    public void test_B() {
        assertThat(checkout.checkout("B"), equalTo(30));
    }

    @Test
    public void test_C() {
        assertThat(checkout.checkout("C"), equalTo(20));
    }

    @Test
    public void test_D() {
        assertThat(checkout.checkout("D"), equalTo(15));
    }

    @Test
    public void test_ABCD() {
        assertThat(checkout.checkout("ABCD"), equalTo(115));
    }
}
