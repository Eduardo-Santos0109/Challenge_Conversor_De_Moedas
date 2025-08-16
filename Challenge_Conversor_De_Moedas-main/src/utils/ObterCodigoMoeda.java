package utils;

public class ObterCodigoMoeda {
    public static String obterCodigoMoeda(int selecionarMoeda) {
        switch (selecionarMoeda) {
            case 1: return "USD";
            case 2: return "ARS";
            case 3: return "BRL";
            case 4: return "EUR";
            case 5: return "COP";
            default: return null;
        }
    }
}
