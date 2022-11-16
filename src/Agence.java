import MoyenDePaiement.IMoyenDePaiement;

import java.util.*;

// verbose cela veut dire que la fonction fait des prints pour indiquer certains états
// Sa ce peut que je mette ce boolean pour certaines fonctions, il faut juste mettre false si on ne veut pas de prints

public class Agence {
    private Client clientActuel;
    private Random random = new Random();

    // MockData pour tester
    private final Film[] Film_connu = {
            new Film(15,"Harry Potter 7", GlobalVals.categories.Ancien, GlobalVals.genres.ScienceFiction),
            new Film(20,"Plancha", GlobalVals.categories.Recent, GlobalVals.genres.Comedie),
            new Film(2,"Transformers 1", GlobalVals.categories.Ancien, GlobalVals.genres.ScienceFiction),
            new Film(5,"Transporteur 3", GlobalVals.categories.Ancien, GlobalVals.genres.Action)
    };

    private final Support[] Support_connu = {
            new Support(false, Film_connu[0], GlobalVals.typeSupport.DVD),
            new Support(true, Film_connu[0], GlobalVals.typeSupport.BluRay),
            new Support(true, Film_connu[0], GlobalVals.typeSupport.BluRay),
            new Support(false, Film_connu[1], GlobalVals.typeSupport.BluRay),
            new Support(true, Film_connu[1], GlobalVals.typeSupport.DVD),
            new Support(true, Film_connu[2], GlobalVals.typeSupport.DVD),
            new Support(false, Film_connu[2], GlobalVals.typeSupport.BluRay),
            new Support(false, Film_connu[3], GlobalVals.typeSupport.BluRay),
            new Support(true, Film_connu[3], GlobalVals.typeSupport.BluRay),
            new Support(true, Film_connu[3], GlobalVals.typeSupport.BluRay),
            new Support(false, Film_connu[3], GlobalVals.typeSupport.DVD)
    };

    private final Client[] Client_connu = {
            new Client("Clement", 20, 10f),
            new Client("Keke", 20, 78f),
            new Client("Paul", 14, 72.5f),
            new Client("Arthur", 12, 8.9f)
    };

    private final Location[] Location_connu = {
            new Location(GlobalVals.durees.DUREE_1, new GregorianCalendar(), 0, 0),
            new Location(GlobalVals.durees.DUREE_2, new GregorianCalendar(), 0, 0)
    };

    private List<Location> ListLocation = new ArrayList<>(Arrays.asList(Location_connu));
    private List<Film> ListFilm = new ArrayList<>(Arrays.asList(Film_connu));
    private List<Client> ListClient = new ArrayList<>(Arrays.asList(Client_connu));

    private List<Support> ListSupport = new ArrayList<>(Arrays.asList(Support_connu));

    public List<Client> getListClient() {
        return ListClient;
    }

    public List<Film> getListFilm() {
        return ListFilm;
    }

    public List<Support> getListSupport() {
        return ListSupport;
    }

    // ------------- Fonction de base pour rajouter des elements dans chacune des listes ----------------

    public void addFilmToList(Film film){
        this.ListFilm.add(film);
    }

    public void addClientToList(Client client){
        this.ListClient.add(client);
    }

    public void addLocationToList(Location location){
        this.ListLocation.add(location);
    }

    // ------------------------- getters spécifiques ---------------------------------------------

    public List<Film> getFilmListFromGenre(GlobalVals.genres genre, boolean verbose){
        List<Film> returnFilmList = new ArrayList<>();
        for (Film film: this.ListFilm) {
            if (film.getGenre() == genre){
                returnFilmList.add(film);
            }
        }
        if (returnFilmList.size() == 0){
            if (verbose) {
                System.out.println("Il n'y a pas de film de " +genre+ " dans notre agence");
            }
        }
        return returnFilmList;
    }

    public List<Support> getSupportListFromSpecificSupport(GlobalVals.typeSupport typeSupport, boolean verbose){
        List<Support> returnSupportList = new ArrayList<>();
        for (Support support: this.ListSupport) {
            if (support.getSupport() == typeSupport){
                returnSupportList.add(support);
            }
        }
        if (returnSupportList.size() == 0){
            if (verbose) {
                System.out.println("Il n'y a plus de " +typeSupport+ " dans notre agence");
            }
        }
        return returnSupportList;
    }

    public void getSupportListFromSpecificSupportPrint(GlobalVals.typeSupport typeSupport){
        List<Support> supportList = getSupportListFromSpecificSupport(typeSupport, false);
        if (supportList.size() == 0) {
            System.out.println("Il n'y a plus de " +typeSupport+ " dans notre agence");
            return;
        }
        System.out.println("\nVoici une liste de film sur un support " + typeSupport + " , on en a " + supportList.size());
        printSupportList(supportList);
    }

    public void getFilmListFromGenrePrint(GlobalVals.genres genre){
        List<Film> genreListFilm = getFilmListFromGenre(genre, false);
        if (genreListFilm.size() == 0) {
            System.out.println("Il n'y a pas de film de " +genre+ " dans notre agence");
            return;
        }
        System.out.println("\nVoici une liste de film de genre " + genre + " , on en a " + genreListFilm.size());
        printFilmList(genreListFilm);
    }

    public void getFilmListFromGenrePrintRandom(){
        getFilmListFromGenrePrint(randomGenre());
    }

    public void getFilmListFromSupportPrintRandom(){
        getSupportListFromSpecificSupportPrint(randomSupport());
    }

    public void denombrerToutGenre(){
        for (GlobalVals.genres genre : GlobalVals.genres.values()) {
            List<Film> currentFilmList = getFilmListFromGenre(genre,false);
            System.out.println("Nous avons " + currentFilmList.size() + " Film(s) du genre " + genre);
        }
    }

    public void denombrerToutSupport(){
        for (GlobalVals.typeSupport typeSupport : GlobalVals.typeSupport.values()) {
            List<Support> currentSupportList = getSupportListFromSpecificSupport(typeSupport,false);
            System.out.println("Nous avons " + currentSupportList.size() + " Film(s) en " + typeSupport);
        }
    }

    // -------------------------- Fonctions pour print les listes -------------------------------------

    public void printFilmList( List<Film> filmList){
        for (Film film: filmList) {
            System.out.println(film.getTitre() + " pour " + film.getPrix() + " €");
        }
    }

    public void printLocalFilmList(){
        System.out.println("Voici une liste de tout nos film avec leurs prix");
        printFilmList(this.ListFilm);
    }

    public void printClientList( List<Client> clientList){
        for (Client client: clientList) {
            System.out.println(client.getNom() + ", " + client.getAge() + " ans");
        }
    }

    public void printLocalClientList(){
        System.out.println("Voici une liste de tout nos clients avec leur age");
        printClientList(this.ListClient);
    }

    public void printLocationList( List<Location> locationList){
        for (Location location: locationList) {
            System.out.println(location.getDuree() + ", " + location.getDateRetourToString());
        }
    }

    public void printLocalLocationList(){
        System.out.println("Voici une liste de tout nos location avec duree et date de retour");
        printLocationList(this.ListLocation);
    }

    public void printSupportList( List<Support> supportList){
        for (Support support: supportList) {
            System.out.println(support.getFilm().getTitre() + " en " +  support.getSupport());
        }
    }

    public void printLocalSupportList(){
        System.out.println("Voici une liste de tout nos supports avec les films associées");
        printSupportList(this.ListSupport);
    }

    // ---------------------------------- Fonctions de Test si connu -----------------------------------

    // Il faudrait tester avec un système d'ID plutot
    private boolean clientIsKnown(Client client) {
        for (Client cli : this.ListClient) {
            if (Objects.equals(cli.getNom(), client.getNom())) {
                return true;
            }
        }
        System.out.println("Nouveau client ajouté a la bdd client");
        this.ListClient.add(client);
        return false;
    }

    // Pas vraiment besoin d'ID par là
    private boolean filmIsKnown(String film) {
        for (Film fi : this.ListFilm) {
            if (Objects.equals(fi.getTitre(), film)) {
                return true;
            }
        }
        System.out.println("Film inconnu dans notre agence");
        return false;
    }

    // --------------------------- Fonctions pour scénario --------------------------------------

    public void clientEntreDansAgence(Client client, boolean verbose){
        this.clientActuel = client;
        if (verbose) {
            System.out.println("Le client " + client.getNom() + " entre dans le magasin, il a " + client.getArgent() + " €");
        }
        if (!clientIsKnown(client)){
            if (verbose) {
                System.out.println("Le client n'est pas connu dans notre agence, on l'ajoute à notre liste de client connu");
            }
            addClientToList(client);
        }
    }

    public boolean payerLaFacture(Client client, Facturation facture, IMoyenDePaiement moyenDePaiement, Support support, Location location){
        System.out.println("Le client va utiliser un/une " + moyenDePaiement.getNom()+ "\n");
        facture.calculerPrixFinal();
        if (client.getArgent() < facture.getPrixFinal()){
            System.out.println("le client n'a pas assez d'argent pour payer sa facture");
            return false;
        }
        client.setArgent(client.getArgent() - facture.getPrixFinal());
        System.out.println("Le client a payé la facture, il lui reste : " + client.getArgent() + " euros");
        support.setEstDisponible(false);
        this.ListLocation.add(location);
        return true;
    }

    public boolean isFilmAvailableToBePicked(Film film){
        int nbFilmAvailable = 0;

        for (Support support : ListSupport) {
            if (support.getFilm() == film && support.estDisponible()){
                nbFilmAvailable += 1;
            }
        }

        // On veut conserver au moins un film avec un support dans le magasin
        if (nbFilmAvailable > 1){
            return true;
        }

        return false;
    }

    public void isFilmAvailablePrint(Film film) {
        boolean resultFromFunc = isFilmAvailableToBePicked(film);
        if (resultFromFunc) {
            System.out.println("Le film " + film.getTitre() + " n'est pas disponible dans notre agence");
        } else {
            System.out.println(film.getTitre() + " est bel et bien disponible dans notre agence");
        }
    }

    public Film clientChooseRandomFilm(){
        Film film;

        film = ListFilm.get(this.random.nextInt(this.ListFilm.size()));

        return film;
    }

    public Support clientChooseRandomSupport(){
        Support support;

        support = ListSupport.get(this.random.nextInt(this.ListSupport.size()));

        return support;
    }

    public Client randomClientFromList(){
        Client client;

        client = ListClient.get(this.random.nextInt(this.ListClient.size()));

        return client;
    }

    public boolean isAnyMovieAvailable(){

        for (Film film : ListFilm) {
            boolean result = isFilmAvailableToBePicked(film);
            if (result) {
                return true;
            }
        }

        return false;
    }

    public void isAnyMovieAvailablePrint(){
        if (isAnyMovieAvailable()){
            System.out.println("\nNous avons des films disponible dans notre agence\n");
        } else {
            System.out.println("\nIl n'y a aucun film disponible dans notre agence :(");
        }
    }

    public GlobalVals.genres randomGenre()  {
        GlobalVals.genres[] genres = GlobalVals.genres.values();
        return genres[this.random.nextInt(genres.length)];
    }

    public GlobalVals.typeSupport randomSupport()  {
        GlobalVals.typeSupport[] typeSupports = GlobalVals.typeSupport.values();
        return typeSupports[this.random.nextInt(typeSupports.length)];
    }
}
