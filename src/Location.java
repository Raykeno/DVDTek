public class Location {

    private int duree;
    private int prixDuree;
    private String dateRetour;
    private int penalite;

    private Location location;

    public Location() {
        this.duree = 0;
        this.prixDuree = 0;
        this.dateRetour = "";
        this.penalite = 0;
    }

    public Location(int duree, int prixDuree, String dateRetour, int penalite) {
        this.duree = duree;
        this.prixDuree = prixDuree;
        this.dateRetour = dateRetour;
        this.penalite = penalite;
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

    public void calculerPenalite(int retard) {
        if (retard <= 24) {
            penalite = 2;
        } else if (retard <= 48) {
            penalite = 6;
        } else {
            penalite = 12;
        }
    }
}
