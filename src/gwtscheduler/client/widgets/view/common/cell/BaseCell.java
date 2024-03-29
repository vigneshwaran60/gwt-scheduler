package gwtscheduler.client.widgets.view.common.cell;

import gwtscheduler.client.interfaces.Cell;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * Base class for grid cells.
 * @author malp
 */
public class BaseCell extends Widget implements Cell<Element> {

  /** Cell identifiers */
  public final int row, col;

  /**
   * Default constructor.
   * @param row the row index
   * @param col the column index
   */
  public BaseCell(int row, int col) {
    setElement(DOM.createDiv());
    this.row = row;
    this.col = col;
  }

  public int column() {
    return col;
  }

  public int row() {
    return row;
  }

  public final Element getCellElement() {
    return getElement();
  }

  public int index(int rowsize) {
    return row * rowsize + col;
  }
}
