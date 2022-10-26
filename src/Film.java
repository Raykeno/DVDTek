//Léo
public class Film {

    private int prix;
    private String titre;
    private GlobalVals.categories categorie;
    private String genre;

    private Film film;

    public Film() {
        this.prix = 0;
        this.titre = "";
        this.categorie = GlobalVals.categories.Ancien;
        this.genre = "";
    }

    public Film(int prix, String titre, GlobalVals.categories categorie, String genre) {
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

    public GlobalVals.categories getCategorie() {
        return categorie;
    }

    public void setCategorie(GlobalVals.categories categorie) {
        this.categorie = categorie;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}