import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BddAgence {
    //doit permettre de gerer les données posséder par l'agence (films choisi par les clients,
    // liste des clients, denombrement...
    protected Object ob;
    protected PrintWriter out;
    protected String path = "./src/bdd.json";
    Integer size;

    public BddAgence() throws IOException, ParseException, ClassCastException {
        this.ob = new JSONParser().parse(new FileReader(this.path));
        JSONObject read = (JSONObject) this.ob;
        JSONArray array = (JSONArray) read.get("id");
        this.size = array.size();
    }

    public void NewRead() throws IOException, ParseException {
        this.ob = new JSONParser().parse(new FileReader(this.path));
        JSONObject read = (JSONObject) this.ob;
        JSONArray array = (JSONArray) read.get("id");
        this.size = array.size();
    }

    public Object read_data_basic(String choix) {
        //basic = nom, age, id
        ArrayList<Integer> age = new ArrayList<>();
        age.add(1);
        age.add(1);
        age.add(6);

        JSONObject JSON = new JSONObject();
        JSONObject Test = new JSONObject();
        String[] essai = {"hey", "pote"};
        Test.put("amis", List.of(essai));
        JSONArray tableaudemerde = new JSONArray();
        tableaudemerde.add(age);


        JSON.put("nom", age);

        //System.out.println("JSON = "+JSON);

        String[] array = {"Titou", "Clemence"};
        JSONObject js = (JSONObject) this.ob;
        //JSONObject Clients = (JSONObject) js.get("Clients");
        //System.out.println("Client = "+Clients);

        //Clients.remove("nom");


        //System.out.println("tab = "+tableaudemerde);

//        JSONArray nomArray = (JSONArray) Clients.get("nom");
        // Clients.put("nom",age);
        //String tab = nomArray.toString();
        //System.out.println("Client apres remove "+Clients);


       /*System.out.println("First name is: " + firstName);
        System.out.println("Last name is: " + lastName);*/


        //vrai fonction

        JSONObject Clients = (JSONObject) this.ob;


        switch (choix) {
            case "nom":
                return Clients.get("nom");
            case "age":
                return Clients.get("age");
            case "id":
                return Clients.get("id");
            /*case "id+film":
                JSONArray test = (JSONArray) Clients.get("filmsDejaEmprunter");
                return test.get(1);*/
        }


        return null;
    }

    public Object Read_FilmsDejaEmprunter(int id) {
        JSONObject Json = (JSONObject) this.ob;
        JSONArray JsonArray = new JSONArray();

        JsonArray = (JSONArray) Json.get("filmsDejaEmprunter");
        if (JsonArray.size() > id) {
            System.out.println(JsonArray.get(id));
        } else
            System.out.println("erreur id trop grand");

        return new Object();
    }

    public void WriteNewClient(Client client) throws IOException, ParseException {
        String nom = client.getNom();
        Integer age = client.getAge();
        float argent = client.getArgent();
        //----------------

        JSONObject Json = (JSONObject) this.ob;
        JSONObject Client = (JSONObject) Json;
        JSONArray idJson = (JSONArray) Client.get("id");
        JSONArray nomJson = (JSONArray) Client.get("nom");
        JSONArray ageJson = (JSONArray) Client.get("age");
        JSONArray filmsDejaEmprunter = (JSONArray) Client.get("filmsDejaEmprunter");
        ArrayList<String> list = new ArrayList<>();
        Integer size = idJson.size();

        //ajout du nouveau client
        idJson.add(size + 1);
        nomJson.add(nom);
        ageJson.add(age);

        //ajout de l'espace pour stocker les films du client
        JSONObject newFilmsDejaEmprunter = new JSONObject();
        newFilmsDejaEmprunter.put("categorie", list);
        newFilmsDejaEmprunter.put("film", list);
        filmsDejaEmprunter.add(newFilmsDejaEmprunter);

        //----------------------------

        Client.remove("nom");
        Client.put("nom", nomJson);

        Client.remove("age");
        Client.put("age", ageJson);

        Client.remove("filmsDejaEmprunter");
        Client.put("filmsDejaEmprunter", filmsDejaEmprunter);

        Client.remove("id");
        Client.put("id", idJson);

        //ecriture
        try (PrintWriter out = new PrintWriter(new FileWriter(this.path));) {
            out.write(Client.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        NewRead();
        System.out.println("Le nouveau client " + nom + " à été ajoué a la BDD de l'agence");

    }


    public void WriteNewMovieClient(int id, String newFilm, String genre) throws IOException, ParseException {
        JSONObject Json = (JSONObject) this.ob;
        JSONArray filmsDejaEmprunter = (JSONArray) Json.get("filmsDejaEmprunter");
        JSONObject filmClient = (JSONObject) filmsDejaEmprunter.get(id);

        JSONArray film = (JSONArray) filmClient.get("film");
        JSONArray categorie = (JSONArray) filmClient.get("categorie");
        film.add(newFilm);
        categorie.add(genre);

        filmClient.remove("film");
        filmClient.put("film",film);

        filmClient.remove("categorie");
        filmClient.put("categorie",categorie);

        filmsDejaEmprunter.remove(id);
        filmsDejaEmprunter.add(id,filmClient);

        Json.remove("filmsDejaEmprunter");
        Json.put("filmsDejaEmprunter",filmsDejaEmprunter);

        NewRead();

        //ecriture
        try (PrintWriter out = new PrintWriter(new FileWriter(this.path));) {
            out.write(Json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Le film " + newFilm + " à été ajouté a la liste des films du client possédant l'id : " + id);


    }

}

