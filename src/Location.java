//Léo
public class Location {

    private int duree;
    private float prixDuree;
    private String dateRetour;
    private float penalite;
    private float remboursement;

    private Location location;

    public Location() {
        this.duree = 0;
        this.prixDuree = 0f;
        this.dateRetour = "";
        this.penalite = 0f;
        this.remboursement = 0f;
    }

    public Location(int duree, float prixDuree, String dateRetour, float penalite, float remboursement) {
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

    public float getPrixDuree() {
        return prixDuree;
    }

    public void setPrixDuree(float prixDuree) {
        this.prixDuree = prixDuree;
    }

    public String getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(String dateRetour) {
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

    public void calculerRemboursement(int avance) {
        // avance en heure, remboursement en euro
        if (avance > 0) {
            remboursement = ((prixDuree/duree)/12) * avance;
        } else {
            remboursement = 0;
        }
    }
}