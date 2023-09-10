package befaster.solutions.HLO;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import befaster.solutions.SUM.SumSolution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HelloSolutionTest {
  private HelloSolution hello;

  @BeforeEach
  public void setUp() {
    hello = new HelloSolution();
  }

  @Test
  public void compute_hello() {
    assertThat(hello.hello("John"), equalTo("Hello, John!"));
  }

}


