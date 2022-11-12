package MoyenDePaiement;

public class Cheque implements IMoyenDePaiement{

    private String nom = "Chèque";

    @Override
    public String getNom() {
        return nom;
    }
}
