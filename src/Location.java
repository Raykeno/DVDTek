//Léo
public class Location {

    private int duree;
    private int prixDuree;
    private String dateRetour;
    private int penalite;
    private int remboursement;

    private Location location;

    public Location() {
        this.duree = 0;
        this.prixDuree = 0;
        this.dateRetour = "";
        this.penalite = 0;
        this.remboursement = 0;
    }

    public Location(int duree, int prixDuree, String dateRetour, int penalite, int remboursement) {
        this.duree = duree;
        this.prixDuree = prixDuree;
        this.dateRetour = dateRetour;
        this.penalite = penalite;
        this.remboursement = remboursement;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getPrixDuree() {
        return prixDuree;
    }

    public void setPrixDuree(int prixDuree) {
        this.prixDuree = prixDuree;
    }

    public String getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(String dateRetour) {
        this.dateRetour = dateRetour;
    }

    public int getPenalite() {
        return penalite;
    }

    public void setPenalite(int penalite) {
        this.penalite = penalite;
    }

    public int getRemboursement() {
        return remboursement;
    }

    public void setRemboursement(int remboursement) {
        this.remboursement = remboursement;
    }

    public void calculerPenalite(int retard) {
        // retard en jour, penalite en euro
        if (retard <= 1) {
            penalite = 2;
        } else if (retard <= 2) {
            penalite = 5;
        } else if (retard <= 3) {
            penalite = 10;
        } else if (retard <= 4) {
            penalite = 15;
        } else {
            penalite = 20;
        }
    }

    public void calculerRemboursement(int avance) {
        // avance en heure, remboursement en euro
        if (avance > 0) {
            remboursement = ((prixDuree/duree)/12) * avance;
        } else {
            remboursement = 0;
        }
    }
}