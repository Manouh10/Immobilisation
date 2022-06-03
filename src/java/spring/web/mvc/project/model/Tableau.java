 
package spring.web.mvc.project.model;
 
public class Tableau {
    int annee;
    int jour;
    int anterieure;
    int exercice;
    int cumul;
    int vnc;

    public Tableau(int annee, int jour, int anterieure, int exercice, int cumul, int vnc) {
        this.annee = annee;
        this.jour = jour;
        this.anterieure = anterieure;
        this.exercice = exercice;
        this.cumul = cumul;
        this.vnc = vnc;
    }

    public Tableau() {
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public int getAnterieure() {
        return anterieure;
    }

    public void setAnterieure(int anterieure) {
        this.anterieure = anterieure;
    }

    public int getExercice() {
        return exercice;
    }

    public void setExercice(int exercice) {
        this.exercice = exercice;
    }

    public int getCumul() {
        return cumul;
    }

    public void setCumul(int cumul) {
        this.cumul = cumul;
    }

    public int getVnc() {
        return vnc;
    }

    public void setVnc(int vnc) {
        this.vnc = vnc;
    }
    
    
}
