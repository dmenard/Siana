/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import source.json_reader.JSONFileManipulator;

/**
 *
 * @author Killdom
 */
public class Personnage {

    private static ArrayList<Personnage> listePersonnage = new ArrayList<Personnage>();
    private String nom;
    private String description;
    private SianaCalendarDate dateDeNaissance;
    private String lieuDeNaissance;

    public Personnage(String nom, SianaCalendarDate dateDeNaissance, String description, String lieuDeNaissance) {
        this.nom = nom;
        this.description = description;
        this.dateDeNaissance = dateDeNaissance;
        this.lieuDeNaissance = lieuDeNaissance;
    }

    Personnage() {
    }

    public void addPersonnage(Personnage unPersonnage) {
        listePersonnage.add(unPersonnage);
    }

    public static ArrayList<Personnage> getListePersonnage() {
        return listePersonnage;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public SianaCalendarDate getDateDeNaissance() {
        return dateDeNaissance;
    }
    
    public String getLieuDeNaissance() {
        return lieuDeNaissance;
    }

    public static Personnage findPersonnageByName(String name) {

        Personnage personnageATrouver = null;

        for (int i = 0; i < listePersonnage.size(); i++) {
            if (listePersonnage.get(i).getNom().equals(name)) {
                personnageATrouver = listePersonnage.get(i);
            }
        }

        return personnageATrouver;

    }

    public static void populateListePersonnageFromJSON() throws Exception {
        JSONFileManipulator listeToPopulate = new JSONFileManipulator();
        listeToPopulate.JSONFileCreator("data/db/listePersonnage.json");
        for (int i = 0; i < listeToPopulate.getjsonFile().getJSONArray("liste").size(); i++) {
            
            SianaCalendarDate uneDate = new SianaCalendarDate(listeToPopulate.getjsonFile().getJSONArray("liste").getJSONObject(i).getJSONArray("date").getJSONObject(0).getInt("jour"),
                    listeToPopulate.getjsonFile().getJSONArray("liste").getJSONObject(i).getJSONArray("date").getJSONObject(0).getString("mois"),
                    listeToPopulate.getjsonFile().getJSONArray("liste").getJSONObject(i).getJSONArray("date").getJSONObject(0).getInt("annee"));
            
            Personnage unPerso = new Personnage(listeToPopulate.getjsonFile().getJSONArray("liste").getJSONObject(i).getString("nom"),
                    uneDate,
                    listeToPopulate.getjsonFile().getJSONArray("liste").getJSONObject(i).getString("description"),
                    listeToPopulate.getjsonFile().getJSONArray("liste").getJSONObject(i).getString("lieuDeNaissance"));
            listePersonnage.add(unPerso);
        }
    }

    public int compareTo(Personnage other) {
        return nom.compareTo(other.getNom());
    }

    public static void sortPersonnageList() {
        Collections.sort(listePersonnage, new Comparator<Personnage>() {
            public int compare(Personnage one, Personnage other) {
                return one.getNom().compareTo(other.getNom());
            }
        });
    }
    
    public static void savePersonnageListToJSON() {
        JSONFileManipulator listePersonnage = new JSONFileManipulator();
        JSONArray arrayListePersonnage = new JSONArray();

        for (int i = 0; i < Personnage.getListePersonnage().size(); i++) {
            JSONObject personnage = new JSONObject();
            personnage.accumulate("nom", Personnage.getListePersonnage().get(i).getNom());
            
            JSONArray arrayDate = new JSONArray();
            JSONObject date = new JSONObject();
            
            date.accumulate("jour", Personnage.getListePersonnage().get(i).getDateDeNaissance().getJour());
            date.accumulate("mois", Personnage.getListePersonnage().get(i).getDateDeNaissance().getMonth());
            date.accumulate("annee", Personnage.getListePersonnage().get(i).getDateDeNaissance().getAnnee());
            
            arrayDate.add(date);
            
            personnage.accumulate("date", arrayDate);
            personnage.accumulate("lieuDeNaissance", Personnage.getListePersonnage().get(i).getLieuDeNaissance());
            personnage.accumulate("description", Personnage.getListePersonnage().get(i).getDescription());
            arrayListePersonnage.add(personnage);
        }

        listePersonnage.getjsonFile().accumulate("liste", arrayListePersonnage);
        try {
            listePersonnage.saveJSONFile("data/db/listePersonnage.json", listePersonnage.getjsonFile());
        } catch (Exception ex) {
            //Logger.getLogger(BoutonAjouter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
