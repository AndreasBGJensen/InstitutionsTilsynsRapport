package Model.DTO.Institutions;

import lombok.*;
import org.jongo.marshall.jackson.oid.MongoId;
import java.util.ArrayList;


/*
TODO: Organize this class so that it only relys on Lombok: Problem When using Lombok
it will not instanciate Arraylists if it is not present in the build.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
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



    public Vuggestue(String navn, String adresse, String åbningstider, String tlf, String venteliste, String link) {
        this.navn = navn;
        this.adresse = adresse;
        this.åbningstider = åbningstider;
        this.tlf = tlf;
        this.venteliste = venteliste;
        this.link.add(link);
    }


    public String getBaseLink() {
        return this.link.get(0);
    }


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