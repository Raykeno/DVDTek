import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class BddAgence {
    //doit permettre de gerer les données posséder par l'agence (films choisi par les clients,
    // liste des clients, denombrement...
    protected Object ob;

    public BddAgence() throws IOException, ParseException, ClassCastException {
        this.ob = new JSONParser().parse(new FileReader("/Users/clementseiler/IdeaProjects/DVDTek/src/bdd.json"));
    }

    public Object read_data_basic(String choix)  {
        //basic = nom, age, id
        ArrayList<Integer> age = new ArrayList<>();
        age.add(1);
        age.add(1);
        age.add(6);

        JSONObject JSON = new JSONObject();
        JSONArray tableaudemerde = new JSONArray();
        tableaudemerde.add(age);


        JSON.put("nom",age);

        //System.out.println("JSON = "+JSON);

        String[] array = {"Titou","Clemence"};
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


        switch (choix){
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
        if (JsonArray.size() > id){
            System.out.println(JsonArray.get(id));
        }
        else
            System.out.println("erreur id trop grand");

        return new Object();
    }

    public void WriteNewClient(){

    }
    public void WriteNewMovie(){

    }
    public void WriteNewMovieClient(){

    }
    public void WriteStatistic(){

    }
}

