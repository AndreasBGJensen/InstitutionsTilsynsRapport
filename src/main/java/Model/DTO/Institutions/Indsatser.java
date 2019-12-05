package Model.DTO.Institutions;

import lombok.*;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Indsatser {

    private HashMap<String, String> indsatser = new HashMap<String, String>();
    private String tilsyn = "";

//    public Indsatser(JSONObject json) {
//        this.setIndsatser((HashMap) json.get("indstsers"));
//        this.setTilsyn((String) json.get("tilsyn"));
//
//    }

//    public Indsatser() {
//
//    }

    public void addIndsats(String beskrivelse, String indsats) {
        indsatser.put(beskrivelse, indsats);
    }

    public void setTilsyn(String tilsyn) {
        this.tilsyn = tilsyn;
    }

    public HashMap<String, String> getIndsatser() {
        return indsatser;
    }

    public void setIndsatser(HashMap<String, String> indsatser) {
        this.indsatser = indsatser;
    }


}
