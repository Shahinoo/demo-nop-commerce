package org.example.data;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;


public class JsonDataReader {
    public String firstName, lastName, email, password;

    public void JsonReader() throws JsonIOException, JsonSyntaxException, IOException, ParseException {

        String filePath = System.getProperty("user.dir") + "/src/test/java/org";
        File srcFile = new File(filePath);
        // change the path just for learn
        String newPath = filePath.replace(srcFile.getName(), "org/example/data/userData.json");
        File newFile = new File(newPath);
        // use the new path
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(newFile));

        for (Object jsonObj : jsonArray) {
            JSONObject person = (JSONObject) jsonObj;
            firstName = (String) person.get("firstname");
            lastName = (String) person.get("lastname");
            email = (String) person.get("email");
            password = (String) person.get("password");

        }
    }
    //TODO >> Create JsonDataWriterClass
}
