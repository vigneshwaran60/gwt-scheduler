package gwtscheduler.client.interfaces.navigation;

import gwtscheduler.common.calendar.IntervalType;

import org.goda.time.DateTime;
import org.goda.time.Interval;
import org.goda.time.ReadableDateTime;

/**
 * Defines event controller operations.
 * @author Miguel Ping
 * @version $Revision: $
 * @since 1.0
 */
public interface DateGenerator {

  /**
   * Initializes the date factory.
   * @param interval the interval type
   * @param start the start date
   */
  void init(IntervalType interval, ReadableDateTime start);

  /**
   * Gets the current date.
   * @return the current date
   */
  DateTime current();

  /**
   * Moves to the specified instant.
   * @param start the start date
   */
  void goTo(DateTime start);

  /**
   * Gets the next date period.
   * @return the next period
   */
  DateGenerator next();

  /**
   * Gets the previous period.
   * @return the previous period
   */
  DateGenerator previous();

  /**
   * Creates a new time period.
   * @return the time period
   */
  Interval interval();

}
