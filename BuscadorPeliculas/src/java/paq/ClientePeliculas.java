/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ClientePeliculas {
    
     public static List<Pelicula> peliculasPorTema(String tema) throws ParseException,
             org.json.simple.parser.ParseException {
         List<Pelicula> listaPeliculas = new ArrayList();
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://www.omdbapi.com/")
                .queryParam("s", tema)
                .queryParam("apikey", "b8e4e707");

        Invocation.Builder invocationBuilder= target.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        System.out.println(response.getStatus());

        JSONParser parser = new JSONParser();
        JSONObject responseJSON = (JSONObject) parser.parse(response.readEntity(String.class));

        JSONArray peliculas = (JSONArray) responseJSON.get("Search");
        for(Iterator it = peliculas.iterator(); it.hasNext();){
            Object pelicula = it.next();
            JSONObject cadaPelicula = (JSONObject) pelicula; 
            
            //AQUI SE AGREGAN TODAS LAS BUSQUEDAS QUE QUERAMOS OBTENER DE LA API
            String titulo = (String) cadaPelicula.get("Title");
            String anio = (String) cadaPelicula.get("Year");
            String poster = (String) cadaPelicula.get("Poster");
            listaPeliculas.add(new Pelicula(titulo, anio, poster));    
        }
        return listaPeliculas;
    }  
}
