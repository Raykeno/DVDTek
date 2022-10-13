public class Client {
    private String nom;
    private int age;
    private String choixFilm;
    private Agence agence;

    public Client(String nom,int age){
        this.nom = nom;
        this.age = age;

    }

    public void demande(String filmDemander){
        this.choixFilm = filmDemander;
    }
}
