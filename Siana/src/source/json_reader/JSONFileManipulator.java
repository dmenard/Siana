/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package source.json_reader;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import source.Personnage;

/**
 *
 * @author Killdom
 */
public class JSONFileManipulator {
    
    private JSONObject jsonFile;
    
    public JSONFileManipulator(){
        jsonFile = new JSONObject();
    }

    public JSONObject getjsonFile() {
        return jsonFile;
    }
    
    public void JSONFileCreator(String accessPath) throws Exception {
        String json = FileReader.loadFileIntoString(accessPath);
        try {
            jsonFile = JSONObject.fromObject(json);
        } catch (Exception e) {
            System.out.println("Le fichier JSON est corrompu.");
        }
    }

    public JSONArray getJSONArrayByName(String jsonArrayName) {
        return jsonFile.getJSONArray(jsonArrayName);
    }

    public String obtainJSONStringContent(String contentName) {
        return jsonFile.getString(contentName);
    }
    
    public static void saveJSONFile(String jsonFileName, JSONObject jsonFileToSave) throws Exception {

        try {
            FileWriter file = new FileWriter(jsonFileName);
            file.write(jsonFileToSave.toString(4));
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
