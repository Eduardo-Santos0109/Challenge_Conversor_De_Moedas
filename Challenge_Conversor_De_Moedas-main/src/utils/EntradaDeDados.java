package utils;
import java.util.Scanner;


public class EntradaDeDados{
    public static int[] selecionarMoedas(Scanner menu) {
        int[] moedasSelecionadas = new int[2];

        System.out.println("Por favor, selecione a moeda de origem: ");
        System.out.println("1 - Dólar (USD)");
        System.out.println("2 - Peso Argentino (ARS)");
        System.out.println("3 - Real (BRL)");
        System.out.println("4 - Euro (EUR)");
        System.out.println("5 - Peso Colombiano (COP)");
        moedasSelecionadas[0] = menu.nextInt();

        System.out.println("Agora, selecione a moeda de destino: ");
        System.out.println("1 - Dólar (USD)");
        System.out.println("2 - Peso Argentino (ARS)");
        System.out.println("3 - Real (BRL)");
        System.out.println("4 - Euro (EUR)");
        System.out.println("5 - Peso Colombiano (COP)");
        moedasSelecionadas[1] = menu.nextInt();

        return moedasSelecionadas;
    }

    public  static double validarValor (Scanner menu){
        double valor;
        while (true){
            System.out.println("Digite o valor a ser convertido: ");
            valor = menu.nextDouble();
            if (valor >= 0){
                break;
            }
            System.out.println("O valor informado deve ser maior ou igual a zero.");
        }
        return valor;

    }
    public static void exibirResultado (double valorConvertido,
                                        String codigoMoedaDestino,
                                        double taxaDeCambio,
                                        String codigoMoedaOrigem,
                                        double valorParaConverter ) {

        System.out.println("Você selecionou: ");
        System.out.println("Moeda de origem:" + codigoMoedaOrigem);
        System.out.println("Moeda do destino: " + codigoMoedaDestino);
        System.out.println("Valor a ser convertido: " + valorParaConverter);
        System.out.println("A taxa de câmbio é " + taxaDeCambio);
        System.out.println("Valor convertido: " + valorConvertido + " " + codigoMoedaDestino);
    }
}

