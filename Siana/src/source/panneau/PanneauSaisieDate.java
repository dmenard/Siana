/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package source.panneau;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Killdom
 */
public class PanneauSaisieDate {
    
    private static final String[] monthNames = {
        "Xiretsa’Geliva", "Marmo’Geliva", "Ago’Geliva", "Nar’Geliva", "Islate’Geliva", "Sifiadé’Geliva", "Alca’Geliva",
        "Oulor’Geliva", "Clat’Geliva", "Yliak’Geliva"
    };

    private JTextField saisieJour;
    private JComboBox saisieMois;
    private JTextField saisieAnnee;

    public PanneauSaisieDate() {
        this.saisieJour = new JTextField();
        this.saisieMois = new JComboBox();
        this.saisieAnnee= new JTextField();
    }
    
    public JTextField getSaisieJour() {
        return saisieJour;
    }

    public JComboBox getSaisieMois() {
        return saisieMois;
    }

    public JTextField getSaisieAnnee() {
        return saisieAnnee;
    }

    public static String[] getMonthNames() {
        return monthNames;
    }

    public static JPanel initialisationDatePanel(PanneauSaisieDate uneDate) {

        JPanel datePanel = new JPanel(new GridLayout(2, 3));

        JLabel jour = new JLabel("Jour");

        JLabel mois = new JLabel("Mois");

        for (int i = 0; i < monthNames.length; i++) {
            uneDate.getSaisieMois().addItem(monthNames[i]);
        }

        JLabel annee = new JLabel("Année");

        datePanel.add(jour);
        datePanel.add(mois);
        datePanel.add(annee);
        datePanel.add(uneDate.getSaisieJour());
        datePanel.add(uneDate.getSaisieMois());
        datePanel.add(uneDate.getSaisieAnnee());

        return datePanel;
    }
    
}
