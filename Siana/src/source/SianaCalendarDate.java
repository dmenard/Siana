/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

/**
 *
 * @author Killdom
 */
public class SianaCalendarDate {

    private int jour;
    private String month;
    private int annee;

    public SianaCalendarDate(int jour, String month, int annee) throws Exception {
        if (jour < 1 || jour > 35 || annee < 1) {
            throw new Exception ();
        } else {
            this.jour = jour;
            this.month = month;
            this.annee = annee;
        }
    }

    public int getJour() {
        return jour;
    }

    public String getMonth() {
        return month;
    }

    public int getAnnee() {
        return annee;
    }
    
    public String toString(){
        return jour + " " + month + " " + annee;
    }
}
