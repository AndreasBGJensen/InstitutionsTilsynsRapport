package Model.DTO.Institutions;

import org.json.JSONObject;

import java.util.HashMap;

public class Indstser {

    private HashMap<String, String> indsatser = new HashMap<String, String>();
    private String tilsyn = "";


    public Indstser(){}

    public Indstser(JSONObject json){
        this.setIndsatser((HashMap)json.get("indstsers"));
        this.setTilsyn((String)json.get("tilsyn"));

    }

    public void addIndsats(String beskrivelse, String indsats){
        indsatser.put(beskrivelse,indsats);
    }

    public void setTilsyn(String tilsyn){
        this.tilsyn = tilsyn;
    }

    public HashMap<String, String> getIndsatser(){
        return indsatser;
    }

    public void setIndsatser(HashMap<String, String> indsatser) {
        this.indsatser = indsatser;
    }


}
