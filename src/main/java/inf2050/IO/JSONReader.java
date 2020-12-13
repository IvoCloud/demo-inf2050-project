package inf2050.IO;

import java.util.*;

import java.io.*;

import net.sf.json.*;

import java.nio.charset.StandardCharsets;

public class JSONReader {

    public static String jsonOpen(String path) throws FileNotFoundException {
        String data = "";
        File file = new File(path);
        Scanner scanner = new Scanner(file, StandardCharsets.UTF_8.name());
        while (scanner.hasNextLine()) {
            data += scanner.nextLine();
        }
        scanner.close();
        return data;
    }

    public static String[] jsonToArray(String jsonString, String champ) throws Exception {
        try {
            JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(jsonString);
            JSONArray jsonArray = (JSONArray) jsonObject.get(champ);
            Object[] objectArray = jsonArray.toArray();
            String[] array = Arrays.asList(objectArray).toArray(new String[objectArray.length]);
            return array;
        } catch (NullPointerException e) {
            throw new Exception("Le champ est vide!");
        } catch (Exception e) {
            throw new Exception("String Json est invalide!");
        }
    }
}