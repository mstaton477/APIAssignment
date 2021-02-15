
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 *   This class calls the Rick and Morty API and gets
 *   information about the character specified and the location
 *   where they preside.
 *   Last Updated: 02/12/21
 *   @author mstaton477 McKenzie
 *
 * */


public class RickAndMortyAPI {
    public static void getCharacterInfo() {
        //creating HTTP connection.
        String baseUrl = " https://rickandmortyapi.com/api";
        //No api key is required for this API.
        //And all requests are get requests within this api.
        String callAction = "/character/";
        //Getting info about a character named Morty Smith, he's the second character within the database.
        String characterId = "2";
        String urlString = baseUrl + callAction + characterId;
        URL url;
        try {
            url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            //All requests are get requests so no need to set request method.

            int status = con.getResponseCode();
            if (status != 200) {
                System.out.println("Error: couldn't load info: " + status);
            } else {
                //Parsing input stream into a text string.
                BufferedReader in = new BufferedReader(new InputStreamReader((con.getInputStream())));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                //Closing connections.
                in.close();
                con.disconnect();
                // Print out complete JSON string.
                System.out.println("Output: " + content.toString());
                // Parse object into usable Java JSON object.
                JSONObject obj = new JSONObject(content.toString());
                //Printing out info about character.
                String characterName = obj.getString("name");
                System.out.println("Character name: " + characterName);

                String characterStatus = obj.getString("status");
                System.out.println("Character Status: " + characterStatus);

                String characterSpecies = obj.getString("species");
                System.out.println("Character Species: " + characterSpecies);

            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            return;
        }


    }

    public static void getLocationInfo() {
        //creating HTTP connection.
        String baseUrl = " https://rickandmortyapi.com/api";
        //No api key is required for this API.
        //And all requests are get requests within this api.
        String callAction = "/location/";
        //Getting info about the location where the character Morty Smith lives.
        String characterId = "1";
        String urlString = baseUrl + callAction + characterId;
        URL url;
        try {
            url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            //All requests are get requests so no need to set request method.

            int status = con.getResponseCode();
            if (status != 200) {
                System.out.println("Error: couldn't load info: " + status);
            } else {
                //Parsing input stream into a text string.
                BufferedReader in = new BufferedReader(new InputStreamReader((con.getInputStream())));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                //Closing connections.
                in.close();
                con.disconnect();
                //Not going to print JSON string because I want the format to flow.
                //Parsing object into Java JSON object.
                JSONObject obj = new JSONObject(content.toString());
                //Printing out location info.
                String locationName = obj.getString("name");
                System.out.println("Location Name: " + locationName);

            }
        }catch(Exception ex){
            System.out.println("Error: " + ex);
            return;
        }
    }
}
