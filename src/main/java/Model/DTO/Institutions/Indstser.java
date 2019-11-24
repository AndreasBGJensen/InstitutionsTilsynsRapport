package Model.DTO.Institutions;

import java.util.HashMap;

public class Indstser {

    private HashMap<String, String> indsatser = new HashMap<String, String>();
    private String tilsyn = "";


    public Indstser(){}

    public void addIndsats(String beskrivelse, String indsats){
        indsatser.put(beskrivelse,indsats);
    }

    public void setTilsyn(String tilsyn){
        this.tilsyn = tilsyn;
    }

    public HashMap<String, String> getIndsatser(){
        return indsatser;
    }
}
