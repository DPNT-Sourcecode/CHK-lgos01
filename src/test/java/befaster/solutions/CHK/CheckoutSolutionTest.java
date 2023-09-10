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
 - {"method":"checkout","params":["ABCDEABCDE"],"id":"CHK_R2_038"}, expected: 280, got: 250
 - {"method":"checkout","params":["CCADDEEBBA"],"id":"CHK_R2_039"}, expected: 280, got: 250
 - {"method":"checkout","params":["AAAAAEEBAAABB"],"id":"CHK_R2_040"}, expected: 455, got: 410
     */

    @BeforeEach
    public void setUp() {
        checkout = new CheckoutSolution();
    }

    @Test
    public void test_2E_1B() {
        assertThat(checkout.checkout("EEB"), equalTo(80));
    }

    @Test
    public void test_failure_1() {
        assertThat(checkout.checkout("ABCDEABCDE"), equalTo(280));
    }

    @Test
    public void test_4E_1B() {
        assertThat(checkout.checkout("EEEEB"), equalTo(160));
    }

    @Test
    public void test_4E_2B() {
        assertThat(checkout.checkout("EEEEBB"), equalTo(160));
    }


    @Test
    public void compute_checkout() {
        // 6 As and 4Bs = 200 + 50 + 90
        assertThat(checkout.checkout("AAABBAAABB"), equalTo(340));
    }

    @Test
    public void test_illegal_argument() {
        assertThat(checkout.checkout("REAAABBAAABB"), equalTo(-1));
    }

    @Test
    public void test_multi_prices() {
        assertThat(checkout.checkout("AAAAA"), equalTo(200));
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

