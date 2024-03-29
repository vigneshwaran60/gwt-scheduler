package gwtscheduler.tests.lasso;

import gwtscheduler.client.utils.lasso.GenericLassoStrategy;
import gwtscheduler.client.utils.lasso.HorizontalLassoStrategy;
import gwtscheduler.client.utils.lasso.VerticalLassoStrategy;
import gwtscheduler.tests.mock.TestLassoSubject;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests lasso selection modes.
 * @author malp
 */
public class GenericLassoSelectionTests {

  static TestLassoSubject subject;
  static GenericLassoStrategy hStrat;

  @BeforeClass
  public static void setUp() {
    subject = new TestLassoSubject(10, 10);
    hStrat = new HorizontalLassoStrategy();
    hStrat = new VerticalLassoStrategy();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testHBoundsNegative() {
    int[] p1 = {-1, 0};
    hStrat.getBlocks(subject, p1, p1);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testHBoundsOutside() {
    int[] p1 = {0, 10};
    hStrat.getBlocks(subject, p1, p1);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testVBoundsNegative() {
    int[] p1 = {-1, 0};
    hStrat.getBlocks(subject, p1, p1);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testVBoundsOutside() {
    int[] p1 = {10, 10};
    hStrat.getBlocks(subject, p1, p1);
  }

}
