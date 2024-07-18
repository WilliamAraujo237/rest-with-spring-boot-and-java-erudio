package br.com.erudio.Converter;

public class NumberConverter {


    //Conversao do valor informado para um Double
    public static Double covertToDouble(String strNumber) {
        if (strNumber == null){
            return 0D;
        }
        String number = strNumber.replaceAll(",",".");
        if (isNumeric(number)){
            return Double.parseDouble(number);
        }
        return 0D;
    }

    //Verificacao pontuacao do valor informado
    public static boolean isNumeric(String strNumber) {
        if (strNumber == null){
            return false;
        }
        String number = strNumber.replaceAll(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
