public class Scenario2 {
    public Agence agence;

    public void init(){

        agence = new Agence();

        agence.printLocalSupportList();
        System.out.println("");
        agence.printLocalFilmList();
        System.out.println("");
        agence.printLocalClientList();
        System.out.println("");
        agence.getFilmListFromGenrePrintRandom();
        System.out.println("");
        agence.getFilmListFromSupportPrintRandom();
        System.out.println("");
        agence.denombrerToutGenre();
        System.out.println();
        agence.denombrerToutSupport();

    }
}
