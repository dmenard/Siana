/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package source.panneau;

import java.awt.*;
import javax.swing.*;
import source.Personnage;
import source.layout.SpringUtilities;

/**
 *
 * @author Killdom
 */
public class PanneauDescriptif {

    public static JPanel addPersonnageDescription(String nomPersonnage) throws Exception {

        JPanel primaryPanel = new JPanel();
        primaryPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        primaryPanel.setSize(600, 600);

        SpringLayout layout = new SpringLayout();
        JPanel myPanel = new JPanel(layout);

        int pos = -1;

        for (int i = 0; i < Personnage.getListePersonnage().size(); i++) {

            if (Personnage.getListePersonnage().get(i).getNom().equals(nomPersonnage)) {
                pos = i;
            }
        }



        Personnage tempPerso = Personnage.getListePersonnage().get(pos);

        myPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        myPanel.setSize(200, 400);


        JLabel descNom = new JLabel("Nom du personnage:");
        descNom.setSize(100, 20);

        JTextField nom = new JTextField(20);
        nom.setText(nomPersonnage);
        nom.setEditable(false);
        descNom.setLabelFor(nom);

        JLabel dateDeNaissanceLabel = new JLabel("Date de naissance :");

        JTextField date = new JTextField(40);
        date.setText(tempPerso.getDateDeNaissance().toString());
        date.setEditable(false);
        dateDeNaissanceLabel.setLabelFor(date);

        JLabel lieuDeNaissanceLabel = new JLabel("Lieu de naissance :");

        JTextField lieuDeNaissance = new JTextField(20);
        lieuDeNaissance.setText(tempPerso.getLieuDeNaissance());
        lieuDeNaissance.setEditable(false);
        lieuDeNaissanceLabel.setLabelFor(lieuDeNaissance);

        JLabel description = new JLabel("Description :");

        JTextArea desc = new JTextArea(35, 20);
        desc.setLineWrap(true);
        desc.setWrapStyleWord(true);
        desc.setText(tempPerso.getDescription());
        desc.setEditable(false);
        description.setLabelFor(desc);

        myPanel.add(descNom);
        myPanel.add(nom);
        myPanel.add(dateDeNaissanceLabel);
        myPanel.add(date);
        myPanel.add(lieuDeNaissanceLabel);
        myPanel.add(lieuDeNaissance);
        myPanel.add(description);
        myPanel.add(desc);

        SpringUtilities.makeCompactGrid(myPanel, 4, 2, //rows, cols
                6, 6, //initX, initY
                6, 6); //xPad, yPad

        primaryPanel.add(myPanel);

        return primaryPanel;

    }
}
