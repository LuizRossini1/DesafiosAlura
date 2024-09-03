package challenges.challenge01.main;
import challenges.challenge01.controller.ApiCep;
import challenges.challenge01.services.CepInfo;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter your cep to check: ");

        ApiCep apiCep = new ApiCep();
        try {
            CepInfo cepInfo = apiCep.apiCepInfo();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}