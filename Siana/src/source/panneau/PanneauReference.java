/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package source.panneau;

import source.panneau.PanneauDescriptif;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import source.Personnage;
import source.Siana_Ressource_Explorer;

/**
 *
 * @author Killdom
 */
public class PanneauReference {
    
    private static JComboBox personnageReference = new JComboBox();

    public static JPanel createReferencePanel(String nomPersonnage) throws Exception {
        
        personnageReference = new JComboBox();
        
        final String nom = nomPersonnage;

        GridLayout leftButtonPane = new GridLayout(0, 1);
        leftButtonPane.setVgap(10);
        leftButtonPane.setRows(20);

        JPanel tempPanel = new JPanel();
        tempPanel.setLayout(leftButtonPane);
        tempPanel.setBorder(BorderFactory.createEtchedBorder());

        personnageReference.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                String selection = "";
                //System.out.println("test");
                if(personnageReference.getSelectedItem().toString().equals("**Liste de référence de personne**")){
                    selection = Siana_Ressource_Explorer.menuPerso.getMenuPersonnage().getSelectedItem().toString();//System.out.println("test");
                }else{
                    selection = personnageReference.getSelectedItem().toString();//System.out.println("test");
                }

                if (!personnageReference.getSelectedItem().toString().equals("**Liste de référence de personne**")) {
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
                    
                    personnageReference.setSelectedItem("**Liste de référence de personne**");

                }
            }
        });
        
        personnageReference.removeAllItems();
        resetReferenceItem(nom);
        tempPanel.add(personnageReference);

        return tempPanel;

    }
    
    public static void resetReferenceItem (String nomPersonnage){
        personnageReference.addItem("**Liste de référence de personne**");

        for (int i = 0; i < Personnage.getListePersonnage().size(); i++) {
            if (Personnage.getListePersonnage().get(i).getDescription().indexOf(nomPersonnage) > -1) {
                personnageReference.addItem(Personnage.getListePersonnage().get(i).getNom());
            }
        }

    }
}
