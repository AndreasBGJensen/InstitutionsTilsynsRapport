package Model.DTO.Institutions;

import org.jongo.marshall.jackson.oid.MongoId;
import org.jongo.marshall.jackson.oid.MongoObjectId;
import org.jongo.marshall.jackson.oid.ObjectId;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Vuggestue {
    @MongoId
    private String _id;
    private String navn = "";
    private String adresse = "";
    private String åbningstider = "";
    private String tlf = "";
    private String venteliste = "";
    private ArrayList<String> link = new ArrayList<String>();
    private ArrayList<String> tilsynsPath= new ArrayList<>();
    private ArrayList<Indstser> indstsers = new ArrayList<>();

    public Vuggestue(JSONObject json){
        this.setNavn((String)json.get("navn"));
        this.setAdresse((String)json.get("adresse"));
        this.setTlf((String)json.get("tlf"));
        this.setVenteliste((String)json.get("venteliste"));
        this.setÅbningstider((String)json.get("åbningstider"));

        JSONArray arr = json.getJSONArray("link");

        for (int i = 0; i < arr.length(); i++) {
            this.addLink(arr.get(i).toString());
        }

        JSONArray path = json.getJSONArray("tilsynsPath");
        for (int i = 0; i < path.length(); i++) {
            this.addTilsynsPath(path.get(i).toString());
        }

        JSONArray indsatser = json.getJSONArray("indstsers");
        for (int i = 0; i < path.length(); i++) {
            Indstser a = new Indstser(indsatser.getJSONObject(i));
            this.addIndsts(a);
        }

    }


   public Vuggestue(String navn, String adresse, String åbningstider, String tlf, String venteliste, String link) {
        this.navn = navn;
        this.adresse = adresse;
        this.åbningstider = åbningstider;
        this.tlf = tlf;
        this.venteliste = venteliste;
        this.link.add(link);
    }

   public Vuggestue(String navn, String adresse, String åbningstider, String tlf, String venteliste) {
        this.navn = navn;
        this.adresse = adresse;
        this.åbningstider = åbningstider;
        this.tlf = tlf;
        this.venteliste = venteliste;

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

    public void setTilsynsPath(ArrayList<String> tilsynsPath) {
        this.tilsynsPath = tilsynsPath;
    }

    public void setIndstsers(ArrayList<Indstser> indstsers) {
        this.indstsers = indstsers;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }



    public String getID(){ //Konverterer ObjectID'et til en pæn string
        return _id;
    }
    public void setID(String id){this._id=id;}
    public String getBaseLink() {
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

    public void addIndsts(Indstser indsats) {
        this.indstsers.add(indsats);
    }

    public Indstser getIndsats(int i){
       return indstsers.get(i);
    }


    public ArrayList<String> getTilsynsPath(){
        return this.tilsynsPath;
    }

    public void addTilsynsPath(String path){
           this.tilsynsPath.add(path);
    }

    public void setTilsynsPath(int i, String newPath){
       String oldPath = this.tilsynsPath.get(i);
       this.tilsynsPath.get(i).replace(oldPath,newPath);
    }


    public void addLink(String link){
        this.link.add(link);
    }

}