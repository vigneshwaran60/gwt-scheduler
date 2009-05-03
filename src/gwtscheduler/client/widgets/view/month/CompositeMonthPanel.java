package gwtscheduler.client.widgets.view.month;

import gwtscheduler.client.interfaces.uievents.resize.IWidgetResizeHandler;
import gwtscheduler.client.interfaces.uievents.resize.WidgetResizeEvent;
import gwtscheduler.client.resources.Resources;
import gwtscheduler.client.resources.css.DayWeekCssResource;
import gwtscheduler.client.widgets.ViewportPanel;

import com.google.gwt.gen2.table.override.client.FlexTable;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Defines the composite month view.
 */
public class CompositeMonthPanel extends Composite {

  /** static ref to css */
  protected static final DayWeekCssResource CSS = Resources.dayWeekCss();

  /** widget impl */
  protected VerticalPanel impl;
  /** month view instance */
  protected MonthPanel monthView;

  /**
   * Default constructor.
   */
  public CompositeMonthPanel() {
    impl = new VerticalPanel();

    monthView = new MonthPanel();
    Widget topView = createTopView();

    final ViewportPanel vp = new ViewportPanel();
    DOM.setStyleAttribute(vp.getElement(), "overflowY", "hidden");
    vp.add(monthView, monthView);

    impl.add(topView);
    impl.add(vp);
    initWidget(impl);

    // we'll delegate the resize to the viewport panel
    addHandler(new IWidgetResizeHandler() {
      public void onResize(WidgetResizeEvent event) {
        vp.doDeferredResize();
      }
    }, WidgetResizeEvent.getType());
  }

  /**
   * Creates the top view.
   * 
   * @return the top view widget
   */
  private Widget createTopView() {
    FlexTable g = new FlexTable();
    g.addStyleName(CSS.genericContainer());
    g.setWidth("100%");

    for (int i = 0; i < 7; i++) {
      g.setWidget(0, i, new Label("Day" + i));
      g.getCellFormatter().setWidth(0, 0, ((float) 100 / 7) + "%");
      g.getFlexCellFormatter().setHorizontalAlignment(0, i,
          HasHorizontalAlignment.ALIGN_CENTER);
    }
    return g;
  }

}
