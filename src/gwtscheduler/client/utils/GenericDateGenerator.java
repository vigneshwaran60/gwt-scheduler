package gwtscheduler.client.utils;

import gwtscheduler.client.interfaces.IDateGenerator;
import gwtscheduler.common.calendar.IDate;
import gwtscheduler.common.calendar.ITimePeriod;
import gwtscheduler.common.calendar.Interval;
import gwtscheduler.common.model.TimePeriod;

/**
 * Generic factory.
 * @author Miguel Ping
 * @version $Revision: $
 * @since 1.0
 */
public class GenericDateGenerator implements IDateGenerator {

  /** the interval type */
  private Interval interval;
  /** interval start and end */
  private IDate start;

  public IDate current() {
    return start;
  }

  public void init(Interval interval, IDate start) {
    this.interval = interval;
    this.start = start.copy(); //we should maintain a copy of the date
  }

  public IDateGenerator next() {
    start.add(interval, 1);
    return this;
  }

  public IDateGenerator previous() {
    start.add(interval, -1);
    return this;
  }

  public ITimePeriod period() {
    return new TimePeriod(start, start.copy().add(interval, 1));
  }

}