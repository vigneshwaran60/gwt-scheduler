package gwtscheduler.client.widgets.nav;

import gwtscheduler.client.interfaces.CalendarPresenter;
import gwtscheduler.client.interfaces.uievents.resize.WidgetResizeEvent;
import gwtscheduler.client.resources.Resources;
import gwtscheduler.client.resources.css.DayWeekCssResource;
import gwtscheduler.client.utils.DOMUtils;

import java.util.HashMap;
import java.util.Map;

import org.cobogw.gwt.user.client.ui.RoundedPanel;

import com.google.gwt.event.logical.shared.BeforeSelectionEvent;
import com.google.gwt.event.logical.shared.BeforeSelectionHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Main navigation panel.
 * @author malp
 */
public class DateViewsTabPanel extends Composite implements
    BeforeSelectionHandler<Integer> {

  /** static ref to css */
  protected static final DayWeekCssResource CSS = Resources.dayWeekCss();
  /** widget delegate */
  private TabPanel impl;
  /** controllers map */
  private Map<Integer, CalendarPresenter> controllers;

  /**
   * Default constructor.
   */
  public DateViewsTabPanel() {
    impl = new DecoratedTabPanel();
    initWidget(impl);
    impl.addBeforeSelectionHandler(this);
    controllers = new HashMap<Integer, CalendarPresenter>();
  }

  public void onBeforeSelection(BeforeSelectionEvent<Integer> event) {
    // fire resize, redraw
    Widget w = impl.getWidget(event.getItem());
    w.fireEvent(new WidgetResizeEvent(DOMUtils.getViewportDimensions()));
  }

  /**
   * Adds a new view to this tab panel.
   * @param presenter the controller
   */
  public void add(CalendarPresenter presenter) {
    Widget view = presenter.getWidgetDisplay();
    impl.add(createWrapper(view), presenter.getTabLabel());
    Integer index = impl.getWidgetIndex(view);
    controllers.put(index, presenter);
  }

  /**
   * Selects a tab.
   * @param i the tab index
   */
  public void selectTab(int i) {
    impl.selectTab(i);
  }

  /**
   * Creates a rounded panel wrapper for the widget.
   * @param child the widget to wrap
   * @return the child wrapped in a rounded panel
   */
  protected Widget createWrapper(Widget child) {
    // will delegate events to child panel
    RoundedPanel rp = new RoundedPanel(RoundedPanel.ALL, 4) {
      @Override
      public void fireEvent(GwtEvent<?> event) {
        getWidget().fireEvent(event);
      }
    };
    // TODO get this from the css resources?
    rp.setCornerColor("#92C1F0");
    rp.add(child);
    return rp;
  }

}
