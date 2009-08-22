package gwtscheduler.client.tests.lasso;

import gwtscheduler.client.tests.mock.SimpleLassoSubject;
import gwtscheduler.client.utils.lasso.GenericLassoStrategy;
import gwtscheduler.client.utils.lasso.HorizontalLassoStrategy;
import gwtscheduler.client.utils.lasso.VerticalLassoStrategy;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests lasso selection modes.
 * @author malp
 */
public class GenericLassoSelectionTests {

  static SimpleLassoSubject subject;
  static GenericLassoStrategy hStrat;

  @BeforeClass
  public static void setUp() {
    subject = new SimpleLassoSubject(10, 10);
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
