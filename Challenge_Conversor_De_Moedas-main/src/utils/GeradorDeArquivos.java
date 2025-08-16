package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivos {
    public void geradorJson(Object resultadoConversao, String nomeArquivo) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter escrita = new FileWriter(nomeArquivo + ".json")) {
            escrita.write(gson.toJson(resultadoConversao));
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
            throw e;
        }
    }
}
