/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import source.bouton.BoutonAjouter;
import source.bouton.BoutonRetirer;
import source.bouton.MenuPersonnage;
import source.panneau.InitialisationFenetrePrincipal;
import source.panneau.LeftButtonPaneInitializer;

/**
 *
 * @author Killdom
 */
public class Siana_Ressource_Explorer {

    public static JFrame fenetre = InitialisationFenetrePrincipal.creationFenetrePrincipale();
    public static Container contenuFenetre = fenetre.getContentPane();
    public static JPanel centerPanel = new JPanel();
    public static JPanel referencePanel = new JPanel();
    public static MenuPersonnage menuPerso = new MenuPersonnage();
    public static JMenuBar menuBar = new JMenuBar();
    JComboBox menuPersonnage = menuPerso.addMenuPersonnage();
    JButton ajouterPersonnage = (new BoutonAjouter()).addButtonAjouter();
    JButton retirer = (new BoutonRetirer()).addButtonRerirerUnPersonnage();
    JButton rechercher;
    JButton nouveau;
    JButton enregistrer;
    JButton quitter;

    public Siana_Ressource_Explorer() throws IOException, Exception {

        // ===== BOUTONS =====

        rechercher = new JButton("Rechercher");
        rechercher.setSize(110, 20);

        nouveau = new JButton("Nouveau");
        nouveau.setSize(110, 20);

        enregistrer = new JButton("Enregistrer");
        enregistrer.setSize(110, 20);

        quitter = new JButton("Quitter");
        quitter.setSize(110, 20);

        // JPanel HAUT (avec le menu deroulant)
        JPanel panneauMenuRecherche = new JPanel();
        panneauMenuRecherche.setBorder(BorderFactory.createLoweredBevelBorder());
        panneauMenuRecherche.setSize(400, 100);
        // AJOUT
        panneauMenuRecherche.add(menuPersonnage);

        centerPanel.setSize(200, 200);
        centerPanel.setBorder(BorderFactory.createLoweredBevelBorder());

        // JPanel BAS (les boutons)
        JPanel panneauMenuBoutonLeft = new JPanel();

        panneauMenuBoutonLeft.setLayout(LeftButtonPaneInitializer.setLeftPaneLayout());
        panneauMenuBoutonLeft.setBorder(BorderFactory.createEtchedBorder());
        // AJOUT
        panneauMenuBoutonLeft.add(ajouterPersonnage);
        panneauMenuBoutonLeft.add(retirer);
        panneauMenuBoutonLeft.add(rechercher);
        panneauMenuBoutonLeft.add(nouveau);
        panneauMenuBoutonLeft.add(enregistrer);
        panneauMenuBoutonLeft.add(quitter);

        // ===== CONTENEUR =====
        contenuFenetre.setLayout(new BorderLayout());
        contenuFenetre.add(panneauMenuRecherche, BorderLayout.NORTH);
        contenuFenetre.add(panneauMenuBoutonLeft, BorderLayout.WEST);
        contenuFenetre.add(centerPanel, BorderLayout.CENTER);
        contenuFenetre.add(referencePanel, BorderLayout.EAST);

        JMenu menu = new JMenu("Personnage");
        JMenuItem menuItemAjouterPersonnage = new JMenuItem("Ajouter un personnage",
                KeyEvent.VK_T);
        menu.add(menuItemAjouterPersonnage);

        menuBar.add(menu);

        fenetre.setJMenuBar(menuBar);

        // Afficher la fenetre
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) throws IOException, Exception {
        new Siana_Ressource_Explorer();
    }
}
