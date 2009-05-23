package gwtscheduler.client;

import gwtscheduler.client.modules.IUIInjector;
import gwtscheduler.client.modules.views.IUIRegistry;
import gwtscheduler.client.modules.views.IViewController;
import gwtscheduler.client.resources.Resources;
import gwtscheduler.client.widgets.nav.DateViewsTabPanel;
import gwtscheduler.common.model.DateTime;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ViewportTests implements EntryPoint, ClickHandler {

  Button back, forward, today;

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    Resources.injectAllStylesheets();

    // let's test a registration
    IUIInjector uiResources = IUIInjector.GIN.getInjector();
    IUIRegistry registry = uiResources.getUIRegistry();
    // registry.addController(new DummyMonthController());

    DateViewsTabPanel main = new DateViewsTabPanel();
    // the registry will be pre-filled with default controllers
    // for day, week and month, plus our own dummy controller
    for (IViewController controller : registry.getControllers()) {
      main.add(controller);
    }
    main.selectTab(0);

    back = new Button("<<", this);
    forward = new Button(">>", this);
    today = new Button("today", this);
    HorizontalPanel nav = new HorizontalPanel();
    nav.add(back);
    nav.add(today);
    nav.add(forward);

    RootPanel.get("calendar-main").add(main);
    RootPanel.get("calendar-top").add(nav);
    
    registry.fireDateNavigation(new DateTime());
  }

  public void onClick(ClickEvent event) {
    IUIInjector uiResources = IUIInjector.GIN.getInjector();
    IUIRegistry registry = uiResources.getUIRegistry();

    if (event.getSource() == back) {
      registry.fireBackNavigation();
    } else if (event.getSource() == forward) {
      registry.fireForwardNavigation();
    } else if (event.getSource() == today) {
      registry.fireDateNavigation(new DateTime());
    }

  }
}
