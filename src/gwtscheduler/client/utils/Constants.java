package gwtscheduler.client.utils;

/**
 * Application constants.
 */
public class Constants {

  /** holds the scrollbar width */
  public static int width = 0;

  /** the scrollbar width - magic number */
  public static final int SCROLLBAR_WIDTH() {
    if (width == 0) {
      width = JSNIUtils.getScrollbarWidthP();
    }
    return width;
  }

  /** z index for lasso panel */
  public static final int LASSO_ZINDEX = 1;
  /** z index for events panel */
  public static final int EVENTS_ZINDEX = 12;
  /** z index for lasso panel while a range is being selected */
  public static final int LASSO_ZINDEX_SELECTING = 13;

}
