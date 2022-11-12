import Exception.InvalidTypeSupportFound;

public class Support {

    private boolean estDisponible;
    private Film film;
    private GlobalVals.typeSupport support;


    public Support(boolean estDisponible, Film film, GlobalVals.typeSupport support) {
        this.estDisponible = estDisponible;
        this.film = film;
        this.support = support;
    }

    public Support(){
        new Support(false, new Film(), GlobalVals.typeSupport.DVD);
    }

    public boolean estDisponible() {
        return estDisponible;
    }

    public void setEstDisponible(boolean estDisponible) {
        this.estDisponible = estDisponible;
    }

    public GlobalVals.typeSupport getSupport() {
        return support;
    }

    public void setSupport(GlobalVals.typeSupport support) {
        this.support = support;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public float getPrixTypeSupport(){
        return switch (this.support) {
            case DVD -> GlobalVals.PRIX_SUPPORT_DVD;
            case BluRay -> GlobalVals.PRIX_SUPPORT_BLURAY;
        };
    }


}
