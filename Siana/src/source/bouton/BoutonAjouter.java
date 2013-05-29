/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package source.bouton;

import java.awt.event.*;
import javax.swing.*;
import source.Personnage;
import source.SianaCalendarDate;
import source.Siana_Ressource_Explorer;
import source.layout.SpringUtilities;
import source.panneau.PanneauSaisieDate;

/**
 *
 * @author Killdom
 */
public class BoutonAjouter implements ActionListener {

    private JButton ajouter;

    public JButton addButtonAjouter() {
        ajouter = new JButton("Ajouter un personnage");
        ajouter.addActionListener(this);
        return ajouter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JPanel myPanel = new JPanel(new SpringLayout());

        JLabel descNom = new JLabel("Nom du personnage:");
        descNom.setSize(100, 20);

        JTextField nom = new JTextField(20);
        descNom.setLabelFor(nom);

        JLabel dateDeNaissanceLabel = new JLabel("Date de naissance :");

        PanneauSaisieDate panneauDate = new PanneauSaisieDate();
        JPanel date = PanneauSaisieDate.initialisationDatePanel(panneauDate);
        dateDeNaissanceLabel.setLabelFor(date);

        JLabel lieuDeNaissanceLabel = new JLabel("Lieu de naissance :");

        JTextField lieuDeNaissance = new JTextField(20);
        lieuDeNaissanceLabel.setLabelFor(lieuDeNaissance);

        JLabel description = new JLabel("Description :");

        JTextArea desc = new JTextArea(20, 20);
        desc.setLineWrap(true);
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

        Object[] options = {"Cancel", "Ok"};
        int choice = JOptionPane.showOptionDialog(null, myPanel, "Nouveau Personnage",
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
                JOptionPane.showMessageDialog(null, "Un personnage de ce nom est présent dans la base de données", "Erreur", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    SianaCalendarDate uneDate = new SianaCalendarDate(Integer.parseInt(panneauDate.getSaisieJour().getText()),
                            panneauDate.getSaisieMois().getSelectedItem().toString(),
                            Integer.parseInt(panneauDate.getSaisieAnnee().getText()));

                    Personnage.getListePersonnage().add(new Personnage(nom.getText(), uneDate, desc.getText(), lieuDeNaissance.getText()));

                    Siana_Ressource_Explorer.menuPerso.getMenuPersonnage().addItem(nom.getText());

                    Personnage.sortPersonnageList();
                    Personnage.savePersonnageListToJSON();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "La date d'entrée est invalide", "Erreur", JOptionPane.WARNING_MESSAGE);
                }



            }

        }
    }
}
