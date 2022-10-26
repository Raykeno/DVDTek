import Exception.InvalidTypeSupportFound;

public class Support {

    private boolean estDisponible;
    private Film film;
    public enum typeSupport {BluRay, DVD}
    private typeSupport support;


    public Support(boolean estDisponible, Film film, typeSupport support) {
        this.estDisponible = estDisponible;
        this.film = film;
        this.support = support;
    }

    public Support(){
        new Support(false, new Film(), typeSupport.DVD);
    }

    public boolean estDisponible() {
        return estDisponible;
    }

    public void setEstDisponible(boolean estDisponible) {
        this.estDisponible = estDisponible;
    }

    public typeSupport getSupport() {
        return support;
    }

    public void setSupport(typeSupport support) {
        this.support = support;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public float getPrixTypeSupport(typeSupport support) throws InvalidTypeSupportFound {
        return switch (support) {
            case DVD -> GlobalVals.PRIX_SUPPORT_DVD;
            case BluRay -> GlobalVals.PRIX_SUPPORT_BLURAY;
        };
    }

}
