package MoyenDePaiement;

public class CarteBancaire implements IMoyenDePaiement {

    private String nom = "Carte Bancaire";

    @Override
    public String getNom() {
        return this.nom;
    }
}
