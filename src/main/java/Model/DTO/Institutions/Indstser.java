package Model.DTO.Institutions;

import org.json.JSONObject;

import java.util.HashMap;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Indstser {

    private HashMap<String, String> indsatser = new HashMap<String, String>();
    private String tilsyn = "";




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
