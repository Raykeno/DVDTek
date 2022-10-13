public class DVD {


    private boolean estDisponible;
    private Film film;

    public DVD(boolean estDisponible, Film film) {
        this.estDisponible = estDisponible;
    }

    public DVD(){
        new DVD(false, new Film());
    }

    public boolean estDisponible() {
        return estDisponible;
    }

    public void setEstDisponible(boolean estDisponible) {
        this.estDisponible = estDisponible;
    }

}
