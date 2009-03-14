package gwtscheduler.client.resources.css;

import com.google.gwt.libideas.resources.client.CssResource;

/**
 * Common Css Resources. This will hold structural css values.
 * 
 * @author Miguel Ping
 * @version $Revision: $
 * @since 1.0
 */
public interface MonthCss extends CssResource {

    /**
     * Defines font size.
     * 
     * @return the font size in px
     */
    int fontSize();

    /**
     * Defines line height.
     * 
     * @return the line height in px
     */
    int lineHeight();

    /**
     * Defines padding top.
     * 
     * @return the padding top in px
     */
    int monthCellPadTopPx();

    /**
     * Defines border top.
     * 
     * @return the border topin px
     */
    int monthCellBorderTopPx();

    /**
     * Month row class.
     * 
     * @return the month row class name
     */
    String monthRow();

    /**
     * Class name for month table.
     * 
     * @return the class name for month row tables
     */
    String monthRowTable();

    /**
     * Month cell class.
     * 
     * @return the month cell class name
     */
    String monthCell();

}