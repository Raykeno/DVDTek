public class Facturation {

    private float prixFinal; // Prix Durée * Durée

    private float prixTTC; // Prix Final + Calcul pénalité de Location
    private GlobalVals.typePaiement typeDePaiementChoisi;
    private Location location;

    private Support support;

    public Facturation(GlobalVals.typePaiement typeDePaiementChoisi, Location location, Support support) {
        this.prixFinal = 0;
        this.prixTTC = 0;
        this.typeDePaiementChoisi = typeDePaiementChoisi;
        this.location = location;
        this.support = support;
    }
    public void calculerPrixFinal() {
        this.prixFinal =  this.location.getPrixDuree() +
                this.support.getFilm().getPrix() +
                this.support.getPrixTypeSupport() +
                this.support.getFilm().getPrixCategorie();
    }

    public void calculerPrixTTC(){
        this.prixTTC = this.getPrixFinal() + this.location.getPenalite();
    }

    public float getPrixFinal() {
        return prixFinal;
    }

    public void setPrixFinal(float prixFinal) {
        this.prixFinal = prixFinal;
    }

    public float getPrixTTC() {
        return prixTTC;
    }

    public void setPrixTTC(float prixTTC) {
        this.prixTTC = prixTTC;
    }

    public GlobalVals.typePaiement getTypeDePaiementChoisi() {
        return typeDePaiementChoisi;
    }

    public void setTypeDePaiementChoisi(GlobalVals.typePaiement typeDePaiementChoisi) {
        this.typeDePaiementChoisi = typeDePaiementChoisi;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
