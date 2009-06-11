package gwtscheduler.client.interfaces.decoration;


import org.goda.time.Interval;

import com.google.gwt.user.client.Element;

/**
 * Defines a generic decorator.
 * @author malp
 * @param <T> the decorable
 */
public interface Decorator<T extends Element> {

  /**
   * Fired when the decorator should decorate elements.
   * @param interval the time interval
   * @param decorable the decorable
   */
  void decorate(Interval interval, HasMultipleDecorables<Element> decorable);
}
