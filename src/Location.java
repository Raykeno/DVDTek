import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Location {

    private float prixDuree;
    private GlobalVals.durees duree;
    private Calendar dateDebut;

    private Calendar dateRetour;
    private float penalite;
    private float remboursement;


    public Location() {
        this.duree = GlobalVals.durees.DUREE_1;
        this.prixDuree = 0f;
        this.dateDebut = new GregorianCalendar();
        this.dateRetour = new GregorianCalendar(); // Il faut set la date de retour....
        this.penalite = 0f;
        this.remboursement = 0f;
    }

    public Location(GlobalVals.durees duree, Calendar dateRetour, int penalite, int remboursement) {
        this.duree = duree;
        this.prixDuree = getDuree();
        this.dateDebut = new GregorianCalendar();
        this.dateRetour = dateRetour;
        this.penalite = penalite;
        this.remboursement = remboursement;
    }

    public GlobalVals.durees getEnumDuree() {
        return duree;
    }

    public int getDuree(){
        return switch (duree) {
            case DUREE_1 -> GlobalVals.DUREE_1;
            case DUREE_2 -> GlobalVals.DUREE_2;
            case DUREE_3 -> GlobalVals.DUREE_3;
        };
    }

    public void setDuree(GlobalVals.durees duree) {
        this.duree = duree;
    }

    public void setDureeWithInt(int dureeInt){
        switch (dureeInt){
            case 24: duree = GlobalVals.durees.DUREE_1;
            case 48: duree = GlobalVals.durees.DUREE_2;
            case 72: duree = GlobalVals.durees.DUREE_3;
            default: duree = GlobalVals.durees.DUREE_1; // Il faut mettre une bonne valeur!
        }
    }

    public float getPrixDuree() {
        return prixDuree;
    }

    public void setPrixDuree(int prixDuree) {
        this.prixDuree = prixDuree;
    }

    public Calendar getDateDebut() {
        return dateDebut;
    }

    public Calendar getDateRetour() {
        return dateRetour;
    }

    public Date getDateRetourToString(){
        return dateRetour.getTime();
    }

    public Date getDateDebutToString(){
        return dateDebut.getTime();
    }

    public void setDateRetour(Calendar dateRetour) {
        this.dateRetour = dateRetour;
    }

    public float getPenalite() {
        return penalite;
    }

    public void setPenalite(float penalite) {
        this.penalite = penalite;
    }

    public float getRemboursement() {
        return remboursement;
    }

    public void setRemboursement(float remboursement) {
        this.remboursement = remboursement;
    }

    public void calculerPenalite(int retard) {
        // retard en jour, penalite en euro
        if (retard <= 1) {
            penalite = 2f;
        } else if (retard <= 2) {
            penalite = 5f;
        } else if (retard <= 3) {
            penalite = 10f;
        } else if (retard <= 4) {
            penalite = 15f;
        } else {
            penalite = 20f;
        }
    }

    /**
     * public void calculerRemboursement(int avance) {
     *         // avance en heure, remboursement en euro
     *         if (avance > 0) {
     *             remboursement = ((prixDuree/getDuree())/12) * avance;
     *         } else {
     *             remboursement = 0;
     *         }
     * }
     */

    public void Prepayer(Boolean prepaye) {
        // Savoir si le client possède une carte prépayé
        if (prepaye) {
            int avance = 0;

            if (avance >= 0 && avance <= 12) {
                remboursement = ((prixDuree/getDuree())/12) * avance;
            } else if (avance >= 12 && avance <= 24) {
                remboursement = ((prixDuree/getDuree())/12) * avance;
            } else if (avance >= 24 && avance <= 36) {
                remboursement = ((prixDuree/getDuree())/12) * avance;
            } else if (avance >= 36 && avance <= 48) {
                remboursement = ((prixDuree/getDuree())/12) * avance;
            } else if(avance >= 48 && avance <= 60) {
                remboursement = ((prixDuree/getDuree())/12) * avance;
            } else {
                remboursement = 0;
            }
        } else {
            remboursement = 0;
        }
    }
}