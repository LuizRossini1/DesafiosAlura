package challenges.challenge01.controller;
import challenges.challenge01.services.CepInfo;
import com.google.gson.*;
import java.io.*;
import java.net.*;
import java.net.http.*;
import java.util.*;

public class ApiCep {
    Scanner scanner = new Scanner(System.in);
    private String search = scanner.nextLine();

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public CepInfo apiCepInfo() throws IOException, InterruptedException{
        String url = "https://viacep.com.br/ws/" +search+ "/json/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 400) {
            System.out.println("Error! Zip code not found!");
        }

        //writing in json
        System.out.println("Status code: " +response.statusCode());
        FileWriter fileJson = new FileWriter("JsonJson");
        fileJson.write(response.body());
        fileJson.close();
        System.out.println("File has been written successfully");

        //writing in different archive toString
        CepInfo cepInfo = gson.fromJson(response.body(), CepInfo.class);
        FileWriter fileToString = new FileWriter("JSONtoString");
        fileToString.write(cepInfo.toString());
        fileToString.close();
        System.out.println("File has been written successfully!");

        return cepInfo;
    }
}