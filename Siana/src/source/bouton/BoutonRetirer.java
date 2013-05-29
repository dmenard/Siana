/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package source.bouton;

import java.awt.event.*;
import javax.swing.*;
import source.Personnage;
import source.Siana_Ressource_Explorer;
import source.layout.SpringUtilities;

/**
 *
 * @author Killdom
 */
public class BoutonRetirer implements ActionListener {

    private JButton retirer;

    public JButton addButtonRerirerUnPersonnage() {
        retirer = new JButton("Retirer un personnage");
        retirer.addActionListener(this);
        return retirer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JPanel myPanel = new JPanel(new SpringLayout());

        JLabel descNom = new JLabel("Nom du personnage:");
        descNom.setSize(100, 20);

        JTextField nom = new JTextField(20);
        descNom.setLabelFor(nom);

        myPanel.add(descNom);
        myPanel.add(nom);

        SpringUtilities.makeCompactGrid(myPanel, 1, 2, //rows, cols
                6, 6, //initX, initY
                6, 6); //xPad, yPad

        Object[] options = {"Cancel", "Ok"};
        int choice = JOptionPane.showOptionDialog(null, myPanel, "Personnage à retirer",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);

        if (choice == 1) {
            boolean testIfPresent = false;

            for (int i = 0; i < Personnage.getListePersonnage().size(); i++) {
                if (Personnage.getListePersonnage().get(i).getNom().equals(nom.getText())) {
                    testIfPresent = true;
                }
            }

            if (testIfPresent == true) {
                int removeConfirmation = JOptionPane.showOptionDialog(null, "Êtes-vous certain de vouloir retirer ce personnage de la banque de donner.",
                        "Comfirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                if (removeConfirmation == 1) {

                    Personnage.getListePersonnage().remove(Personnage.findPersonnageByName(nom.getText()));
                    Siana_Ressource_Explorer.menuPerso.getMenuPersonnage().removeItem(nom.getText());

                    Personnage.savePersonnageListToJSON();

                }


            } else {
                JOptionPane.showMessageDialog(null, "Il n'y a aucun personnage de ce nom dans la base de données", "Erreur", JOptionPane.WARNING_MESSAGE);
            }

        }
    }
}
