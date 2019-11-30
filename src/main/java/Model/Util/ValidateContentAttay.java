package Model.Util;

import java.util.ArrayList;

public class ValidateContentAttay {


    public static boolean validateContent(ArrayList<String> links, String link){
        for (String a:links
             ) {
            if(a.equals(link)){
                return false;
            }

        }
        return true;
    }

}
