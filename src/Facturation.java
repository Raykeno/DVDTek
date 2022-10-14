public class Facturation {

    private float prixFinal; // Prix Durée * Durée

    private float prixTTC; // Prix Final + Calcul pénalité de Location
    private enum TypePaiement {
        CB, Cheque, Espece
    }
    private TypePaiement typeDePaiementChoisi;
    private Location location;

    public Facturation(TypePaiement typeDePaiementChoisi, Location location) {
        this.prixFinal = 0;
        this.prixTTC = 0;
        this.typeDePaiementChoisi = typeDePaiementChoisi;
        this.location = location;
    }
    public void calculerPrixFinal() {
        this.prixFinal = this.location.getDuree() * this.location.getPrixDuree();
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

    public TypePaiement getTypeDePaiementChoisi() {
        return typeDePaiementChoisi;
    }

    public void setTypeDePaiementChoisi(TypePaiement typeDePaiementChoisi) {
        this.typeDePaiementChoisi = typeDePaiementChoisi;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
