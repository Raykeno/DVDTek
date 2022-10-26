//Léo
public class Location {

    private GlobalVals.durees duree;
    private int prixDuree;
    private String dateRetour;
    private int penalite;
    private int remboursement;

    private Location location;

    public Location() {
        this.duree = GlobalVals.durees.DUREE_1;
        this.prixDuree = 0;
        this.dateRetour = "";
        this.penalite = 0;
        this.remboursement = 0;
    }

    public Location(GlobalVals.durees duree, int prixDuree, String dateRetour, int penalite, int remboursement) {
        this.duree = duree;
        this.prixDuree = getDuree();
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
            remboursement = ((prixDuree/getPrixDuree())/12) * avance;
        } else {
            remboursement = 0;
        }
    }
}