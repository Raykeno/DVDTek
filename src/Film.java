public class Film {

    private int prix;
    private String titre;
    private String categorie;

    private Film film;

    public Film() {
        this.prix = 0;
        this.titre = "";
        this.categorie = "";
    }

    public Film(int prix, String titre, String categorie) {
        this.prix = prix;
        this.titre = titre;
        this.categorie = categorie;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
