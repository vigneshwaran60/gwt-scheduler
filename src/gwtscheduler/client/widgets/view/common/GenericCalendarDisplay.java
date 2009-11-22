package gwtscheduler.client.widgets.view.common;

import gwtscheduler.client.interfaces.Cell;
import gwtscheduler.client.interfaces.decoration.HasMultipleDecorables;

import java.util.List;

import net.customware.gwt.presenter.client.widget.WidgetDisplay;

import com.google.gwt.user.client.Element;

/**
 * Defines a generic view for displaying a calendar.
 * @author malp
 */
public interface GenericCalendarDisplay extends WidgetDisplay {

  /**
   * Gets the height in pixels.
   * @return
   */
  int getHeight();

  /**
   * Gets the width in pixels.
   * @return
   */
  int getWidth();

  /**
   * Gets the current visible elements.
   * @return
   */
  List<Cell<Element>> getVisibleElements();

  /**
   * Gets the decorables elements.
   * @return
   */
  HasMultipleDecorables<Element> getDecorables();

}
