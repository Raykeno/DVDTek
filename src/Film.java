public class Film {

    private int prix;
    private String titre;
    private String categorie;
    private String genre;

    private Film film;

    public Film() {
        this.prix = 0;
        this.titre = "";
        this.categorie = "";
        this.genre = "";
    }

    public Film(int prix, String titre, String categorie, String genre) {
        this.prix = prix;
        this.titre = titre;
        this.categorie = categorie;
        this.genre = genre;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
