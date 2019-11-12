package Model.DTO.Institutions;

import org.jongo.marshall.jackson.oid.MongoObjectId;
import org.json.JSONArray;
import org.json.JSONObject;


import java.util.ArrayList;

public class Institution extends Object {
    @MongoObjectId
    private String _id;
    private String navn = "";
    private String adresse = "";
    private String åbningstider = "";
    private String tlf = "";
    private String venteliste = "";
    private ArrayList<String> link = new ArrayList<String>();
    //private Indstser indsats = null;


    public Institution(String navn, String adresse, String åbningstider, String tlf, String venteliste, String link) {
        this.navn = navn;
        this.adresse = adresse;
        this.åbningstider = åbningstider;
        this.tlf = tlf;
        this.venteliste = venteliste;
        this.link.add(link);
    }

    public Institution(String navn, String adresse, String åbningstider, String tlf, String venteliste) {
        this.navn = navn;
        this.adresse = adresse;
        this.åbningstider = åbningstider;
        this.tlf = tlf;
        this.venteliste = venteliste;

    }

    //This constructor is used for Database
    Institution(){}
/*
Constructor user for converting JSONObjects into objects
 */

    public Institution(JSONObject json){
        this.setNavn((String)json.get("navn"));
        this.setAdresse((String)json.get("adresse"));
        this.setTlf((String)json.get("tlf"));
        this.setVenteliste((String)json.get("venteliste"));
        this.setÅbningstider((String)json.get("åbningstider"));

        JSONArray arr = json.getJSONArray("link");

        for (int i = 0; i < arr.length(); i++) {
            this.addLink(arr.get(i).toString());
        }

    }



    public String getId(){ //Konverterer ObjectID'et til en pæn string
        return _id;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setÅbningstider(String åbningstider) {
        this.åbningstider = åbningstider;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public void setVenteliste(String venteliste) {
        this.venteliste = venteliste;
    }

    public void setLink(ArrayList<String> link) {
        this.link = link;
    }



//This was before "getBaseList" it is changed so that this getter will not be included when JSONobject is created i CreateJSONClass.class
    public String returnBaseLink() {
        return this.link.get(0);
    }

    public String getNavn() {
        return navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getAabningstider() {
        return åbningstider;
    }

    public String getTlf() {
        return tlf;
    }

    public String getVenteliste() {
        return venteliste;
    }

    public void setID(String id){ //Konverterer en HexString til ObjectID
        _id =id;
    }


    /*public void setIndsats(Indstser indsats){
        this.indsats = indsats;
    }*/


    public void printAllLinks(){
        for(int i = 0; i<this.link.size();i++){
            System.out.println(this.link.get(i));
        }
    }

    public ArrayList<String> getLinks(){
        return this.link;
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("{navn: " + navn).append(", ").append("adresse: "+adresse).append(", ").append("aabningstider:" +åbningstider).append(", ").append("telefon:" +tlf).append(", ").append("venteliste: "+venteliste).append(", ").append("link:" +link+"}");
        return string.toString(); //To string method for StringBuilder

    }


    public void addLink(String link){
        this.link.add(link);
    }

}





