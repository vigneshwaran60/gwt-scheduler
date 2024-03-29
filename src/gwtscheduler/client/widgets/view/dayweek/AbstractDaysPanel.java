package gwtscheduler.client.widgets.view.dayweek;

import gwtscheduler.client.interfaces.Cell;
import gwtscheduler.client.interfaces.LassoSubject;
import gwtscheduler.client.interfaces.uievents.resize.HasWidgetResizeHandlers;
import gwtscheduler.client.interfaces.uievents.resize.WidgetResizeEvent;
import gwtscheduler.client.interfaces.uievents.resize.WidgetResizeHandler;
import gwtscheduler.client.modules.AppInjector;
import gwtscheduler.client.modules.config.AppConfiguration;
import gwtscheduler.client.resources.Resources;
import gwtscheduler.client.resources.css.DayWeekCssResource;
import gwtscheduler.client.widgets.view.common.WrappedWidget;
import gwtscheduler.client.widgets.view.common.grid.HorizontalGridFill;
import gwtscheduler.client.widgets.view.common.grid.HorizontalGridFillResizeHandler;

import java.util.List;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Abstract class for day and week views. Holds the main grid cells.
 */
//FIXME: migrate the LassoSubject to the presenter
public abstract class AbstractDaysPanel extends WrappedWidget implements
    HasWidgetResizeHandlers, LassoSubject {

  /** static ref to css */
  private static final DayWeekCssResource CSS = Resources.dayWeekCss();

  /** Main container */
  protected VerticalPanel container;
  /** Hours grid */
  protected HorizontalGridFill grid;
  /** Resize handler */
  private WidgetResizeHandler rh;

  /** static ref to app configuration */
  private static final AppConfiguration config = AppInjector.GIN.getInjector().getConfiguration();

  /**
   * Default constructor.
   */
  public AbstractDaysPanel() {
    container = new VerticalPanel();
    wrapWidget(container);

    grid = new HorizontalGridFill(getRows(), getColumns());
    rh = new HorizontalGridFillResizeHandler(grid);

    // this defines the row height 
    int lh = config.daysLineHeightEMs();
    container.setSize("100%", getRows() * lh + "em");
    grid.setSize("100%", getRows() * lh + "em");
    container.add(grid);
  }

  @Override
  public int getColNum() {
    return getColumns();
  }

  @Override
  public int getRowNum() {
    return getRows();
  }

  @Override
  public final List<Cell<Element>> getLassoSubjects() {
    return getMainDecorables();
  }

  /**
   * Gets the decorable elements.
   * @return the decorable elements
   */
  List<Cell<Element>> getTitleDecorables() {
    return grid.getTitleElements();
  }

  /**
   * Gets the main decorables.
   * @return the decorableelements
   */
  List<Cell<Element>> getMainDecorables() {
    return grid.getMainElements();
  }

  /**
   * Gets the proper resize handler for this widget.
   * @return the resize handler
   */
  WidgetResizeHandler getWidgetResizeHandler() {
    return rh;
  }

  public HandlerRegistration addWidgetResizeHandler(WidgetResizeHandler handler) {
    return addHandler(handler, WidgetResizeEvent.getType());
  }

  @Override
  public int getHeight() {
    return grid.getElement().getOffsetHeight();// - CSS.smallBorderPx();
  }

  @Override
  public int getWidth() {
    return grid.getElement().getOffsetWidth() - CSS.titleColumnWidthPx()
        - CSS.smallPaddingPx();
  }

  /**
   * Gets the number of rows.
   * @return the number of rows of this panel
   */
  protected abstract int getRows();

  /**
   * Gets the number of columns.
   * @return the number of columns of this panel
   */
  protected abstract int getColumns();

}
