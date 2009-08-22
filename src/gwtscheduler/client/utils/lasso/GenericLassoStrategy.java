package gwtscheduler.client.utils.lasso;

import gwtscheduler.client.interfaces.LassoStrategy;
import gwtscheduler.client.interfaces.LassoSubject;
import gwtscheduler.client.utils.PointUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines a generic lasso strategy that can be reusable.
 * @author malp
 */
public abstract class GenericLassoStrategy implements LassoStrategy {

  /**
   * Returns the appropriate segments based on the start and end point.
   * @param subject the lasso subject
   * @param start the start point
   * @param end the end point
   * @return the segments
   */
  public List<int[]> getBlocks(LassoSubject subject, int[] start, int[] end) {
    if (PointUtils.equals(start, end)) {
      ArrayList<int[]> result = new ArrayList<int[]>();
      result.add(start);
      return result;
    }
    int[] from = getFirst(start, end);
    int[] to = getLast(start, end);
    return stripInSegments(from, to);
  }

  /**
   * Strips the range in appropriate segments.
   * @param from the starting point. It is guaranteed that the starting point is
   *          before the ending point
   * @param to the end point
   * @return the segments
   */
  protected abstract List<int[]> stripInSegments(int[] from, int[] to);

  /**
   * Compares 2 points.
   * @param start the first
   * @param end the last
   * @return an integer less than, equals or bigger than 0 if the <tt>start</tt>
   *         is less than, equals or bigger than <tt>end</tt> respectively
   */
  public abstract int compare(int[] start, int[] end);

  /**
   * Gets the element that comes first.
   * @param start the start point
   * @param end the end point
   * @return the first element
   */
  protected int[] getFirst(int[] start, int[] end) {
    return compare(start, end) <= 0 ? start : end;
  }

  /**
   * Gets the element that comes last.
   * @param start the start point
   * @param end the end point
   * @return the last element
   */
  protected int[] getLast(int[] start, int[] end) {
    return compare(start, end) >= 0 ? start : end;
  }
}
