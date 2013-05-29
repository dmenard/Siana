/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package source.panneau;

import java.awt.GridLayout;

/**
 *
 * @author Killdom
 */
public class LeftButtonPaneInitializer {
    
    public static GridLayout setLeftPaneLayout(){
        GridLayout leftButtonPane = new GridLayout(0,1);
        leftButtonPane.setVgap(10);
        leftButtonPane.setRows(20);
        
        return leftButtonPane;
    }
    
}
