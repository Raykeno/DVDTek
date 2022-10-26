public class Main {
    Client Ewan = new Client("Ewan", 20);


    public static void main(String[] args) {
        // Scénario 1 : Le client arrive dans l'agence et demande plusieurs films et leurs durées
        System.out.println("Scenario 1 \n");
        // Méthode envoyer une list de film a Agence
        System.out.println("Le client choisi [Nom des Film/s]");
        // Agence va utiliser des méthodes pour vérifier si les films en question existe et répond en conséquences
        System.out.println("Il y a [Film] disponible, et [Film pas disponible");
        System.out.println("Prix : [prixFilm0], [prixFilm1], [prixFilmN]");
        System.out.println("Choisir Durée : [DuréeLocationFilm1],[DuréeLocationFilm2],[DuréeLocationFilmN],");
        System.out.println("Prix Total : [ToutLesPrixFinalFilms]?");
    }


    // Création des films
    Film HarryPotter = new Film(25, "Harry Potter", "Ancien", "Fantaisie");
    Film LOTR = new Film(45, "The Lord of the Rings", "Ancien", "Fantaisie");
    Film Interstellar = new Film(28, "Interstellar", "Récent", "ScienceFiction");
    Film Alad2 = new Film(5, "Alad'2", "Récent", "Comédie");
    Film Avatar = new Film(32, "Avatar", "Ancien", "ScienceFiction");
    Film Titanic = new Film(38, "Titanic", "Ancien", "DrameRomantique");
    Film StarWars = new Film(38, "Start Wars", "Ancien", "ScienceFiction");

    Support HarryPoterDVD = new Support(true, HarryPotter, Support.typeSupport.DVD);
    Support TitanicBluRay = new Support(true, Titanic, Support.typeSupport.BluRay);
    Support Alad2BluRay = new Support(false, Alad2, Support.typeSupport.BluRay);
}
