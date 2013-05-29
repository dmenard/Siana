/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package source.bouton;

import source.panneau.PanneauReference;
import source.panneau.PanneauDescriptif;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import source.*;

/**
 *
 * @author Killdom
 */
public class MenuPersonnage implements ActionListener {

    private JComboBox menuPersonnage;

    public JComboBox getMenuPersonnage() {
        return menuPersonnage;
    }

    public JComboBox addMenuPersonnage() throws Exception {
        menuPersonnage = new JComboBox();
        menuPersonnage.addActionListener(this);
        menuPersonnage.addItem("**Liste de nom de personne**");

        Personnage.populateListePersonnageFromJSON();

        for (int i = 0; i < Personnage.getListePersonnage().size(); i++) {
            menuPersonnage.addItem(Personnage.getListePersonnage().get(i).getNom());
        }

        return menuPersonnage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selection = menuPersonnage.getSelectedItem().toString();
        
        if (!menuPersonnage.getSelectedItem().toString().equals("**Liste de nom de personne**")) {
            try {
                Siana_Ressource_Explorer.contenuFenetre.remove(Siana_Ressource_Explorer.centerPanel);
                Siana_Ressource_Explorer.contenuFenetre.validate();
                Siana_Ressource_Explorer.contenuFenetre.repaint();
                
                JPanel tempPanel = PanneauDescriptif.addPersonnageDescription(selection);
                Siana_Ressource_Explorer.centerPanel = tempPanel;

                Siana_Ressource_Explorer.contenuFenetre.add(Siana_Ressource_Explorer.centerPanel, BorderLayout.CENTER);
                Siana_Ressource_Explorer.contenuFenetre.validate();
                Siana_Ressource_Explorer.contenuFenetre.repaint();

            } catch (Exception ex) {
            }
            
            try {
                Siana_Ressource_Explorer.contenuFenetre.remove(Siana_Ressource_Explorer.referencePanel);
                Siana_Ressource_Explorer.contenuFenetre.validate();
                Siana_Ressource_Explorer.contenuFenetre.repaint();
                
                JPanel tempPanel = PanneauReference.createReferencePanel(selection);
                Siana_Ressource_Explorer.referencePanel = tempPanel;
                
                Siana_Ressource_Explorer.contenuFenetre.add(Siana_Ressource_Explorer.referencePanel, BorderLayout.EAST);
                Siana_Ressource_Explorer.contenuFenetre.validate();
                Siana_Ressource_Explorer.contenuFenetre.repaint();

            } catch (Exception ex) {
            }
            menuPersonnage.setSelectedItem("**Liste de nom de personne**");
            
        }
    }
}
