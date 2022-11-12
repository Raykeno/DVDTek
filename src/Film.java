public class Film {

    private float prix;
    private String titre;
    private GlobalVals.categories categorie;
    private GlobalVals.genres genre;

    private Film film;

    public Film() {
        this.prix = 0f;
        this.titre = "";
        this.categorie = GlobalVals.categories.Ancien;
        this.genre = GlobalVals.genres.Fantaisie;
    }

    public Film(float prix, String titre, GlobalVals.categories categorie, GlobalVals.genres genre) {
        this.prix = prix;
        this.titre = titre;
        this.categorie = categorie;
        this.genre = genre;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
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

    public GlobalVals.genres getGenre() {
        return genre;
    }

    public void setGenre(GlobalVals.genres genre) {
        this.genre = genre;
    }

    public float getPrixCategorie() {
        return switch (this.categorie) {
            case Ancien -> GlobalVals.PRIX_ANCIEN;
            case Recent -> GlobalVals.PRIX_RECENT;
            case Nouveau -> GlobalVals.PRIX_NOUVEAU;
            case DeLAnnee -> GlobalVals.PRIX_DELANNEE;
            case DeLAnPasse -> GlobalVals.PRIX_DELANPASSE;
        };
    }
}