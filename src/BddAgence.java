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

    public BddAgence() throws IOException, ParseException, ClassCastException {
        // this.ob = new JSONParser().parse(new FileReader(this.path));

    }

    public void NewRead() throws IOException, ParseException {
        this.ob = new JSONParser().parse(new FileReader(this.path));
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
        System.out.println("Test = " + Test);
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
        String firstName = js.get("Clients").toString();
        String lastName = (String) js.get("lastName");

       /*System.out.println("First name is: " + firstName);
        System.out.println("Last name is: " + lastName);*/


        //vrai fonction

        JSONObject Json = (JSONObject) this.ob;
        JSONObject Clients = (JSONObject) Json.get("Clients");


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
        Json = (JSONObject) Json.get("Clients");
        JsonArray = (JSONArray) Json.get("filmsDejaEmprunter");
        if (JsonArray.size() > id) {
            System.out.println(JsonArray.get(id));
        } else
            System.out.println("erreur id trop grand");

        return new Object();
    }

    public void WriteNewClient(Client client) {
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
        idJson.add(size+1);
        nomJson.add(nom);
        ageJson.add(age);

        //ajout de l'espace pour stocker les films du client
        JSONObject newFilmsDejaEmprunter = new JSONObject();
        newFilmsDejaEmprunter.put("categorie",list);
        newFilmsDejaEmprunter.put("film",list);
        filmsDejaEmprunter.add(newFilmsDejaEmprunter);

        //----------------------------

        Client.remove("nom");
        Client.put("nom",nomJson);

        Client.remove("age");
        Client.put("age",ageJson);

        Client.remove("filmsDejaEmprunter");
        Client.put("filmsDejaEmprunter",filmsDejaEmprunter);

        Client.remove("id");
        Client.put("id",idJson);

        //ecriture
       try (PrintWriter out = new PrintWriter(new FileWriter(this.path));) {
            out.write(Client.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void WriteNewMovie() {

    }

    public void WriteNewMovieClient() {

    }

    public void WriteStatistic() {

    }
}
