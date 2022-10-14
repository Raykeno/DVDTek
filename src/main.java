public class main {
    Client Ewan = new Client("Ewan",20);
    //hey



    // Création des films
    Film HarryPotter = new Film(25, "Harry Potter", "Ancien", "Fantaisie");
    Film LOTR = new Film(45, "The Lord of the Rings", "Ancien", "Fantaisie");
    Film Interstellar = new Film(28, "Interstellar", "Récent", "ScienceFiction");
    Film Alad2 = new Film(5, "Alad'2", "Récent", "Comédie");
    Film Avatar = new Film(32, "Avatar", "Ancien", "ScienceFiction");
    Film Titanic = new Film(38, "Titanic", "Ancien", "Drame romantique");

    Support TitanicK7 = new Support(true, Titanic, Support.typeSupport.K7Video);
    Support LOTRDVD = new Support(false, LOTR, Support.typeSupport.DVD);
    Support Alad2BluRay = new Support(true, Alad2, Support.typeSupport.BluRay);
    Support HarryPotterBluRay = new Support(true, HarryPotter, Support.typeSupport.BluRay);
}
