package conversor;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.ResultadoConversao;
import utils.EntradaDeDados;
import utils.GeradorDeArquivos;
import utils.ObterCodigoMoeda;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitorEntrada = new Scanner(System.in);
        GeradorDeArquivos geradorDeArquivos = new GeradorDeArquivos();
        HttpClient clienteHttp = HttpClient.newHttpClient();

        System.out.println("♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦");
        System.out.println("♦BEM VINDO AO CONVERSOR DE MOEDAS ONLINE - SIMPLES, RÁPIDO E PRECISO!♦");
        System.out.println("♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦");

        int opcaoSair = 1;

        while (opcaoSair != 0) {
            int[] codigosMoedas = EntradaDeDados.selecionarMoedas(leitorEntrada);
            int indiceMoedaOrigem = codigosMoedas[0];
            int indiceMoedaDestino = codigosMoedas[1];

            double valorOriginal = EntradaDeDados.validarValor(leitorEntrada);

            String codigoMoedaOrigem = ObterCodigoMoeda.obterCodigoMoeda(indiceMoedaOrigem);
            String codigoMoedaDestino = ObterCodigoMoeda.obterCodigoMoeda(indiceMoedaDestino);

            if (codigoMoedaOrigem == null || codigoMoedaDestino == null) {
                System.out.println("Opção de moeda inválida. Tente novamente.");
                continue;
            }

            String urlApi = "https://v6.exchangerate-api.com/v6/b794bbdf80ff0b784195c2da/latest/USD" + codigoMoedaOrigem + "/" + codigoMoedaDestino;

            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(urlApi))
                        .GET()
                        .build();

                HttpResponse<String> response = clienteHttp.send(request, HttpResponse.BodyHandlers.ofString());

                JsonParser parserJson = new JsonParser();
                JsonElement elementoRaizJson = parserJson.parse(response.body());
                JsonObject objetoJsonResposta = elementoRaizJson.getAsJsonObject();

                double taxaConversao = objetoJsonResposta.get("conversion_rate").getAsDouble();
                double valorFinal = converterMoeda(valorOriginal, taxaConversao);

                EntradaDeDados.exibirResultado(valorFinal, codigoMoedaDestino, taxaConversao, codigoMoedaOrigem, valorOriginal);

                ResultadoConversao resultadoConversao = new ResultadoConversao(valorOriginal, valorFinal, codigoMoedaOrigem, codigoMoedaDestino, taxaConversao);
                geradorDeArquivos.geradorJson(resultadoConversao, "resultadoConversao");

            } catch (IOException | InterruptedException e) {
                System.out.println("Erro ao tentar conectar. Tente novamente");
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }

            System.out.println("Deseja realizar outra conversão? (1 - Sim, 0 - Não)");
            opcaoSair = leitorEntrada.nextInt();
        }

        leitorEntrada.close();
    }

    public static double converterMoeda(double valor, double taxa) {
        return valor * taxa;
    }
}
