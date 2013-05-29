/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package source.panneau;

import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 *
 * @author Killdom
 */
public class InitialisationFenetrePrincipal {
    
    public static JFrame creationFenetrePrincipale(){
        JFrame fenetre;
        fenetre = new JFrame("Centre d'information sur le monde de Siana");
        fenetre.setBounds(200, 200, 1024, 768);
        fenetre.setLayout(new FlowLayout());
        //fenetre.setExtendedState(fenetre.MAXIMIZED_BOTH); 
        
        return fenetre;
    }
    
}
