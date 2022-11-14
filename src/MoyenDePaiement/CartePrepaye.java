package MoyenDePaiement;

public class CartePrepaye implements IMoyenDePaiement{
    private String nom = "Carte Prépayé";
    @Override
    public String getNom() {
        return this.nom;
    }
}
