package br.com.erudio.Controller;
import br.com.erudio.Exception.UnsuportedMathOperationException;
import org.springframework.web.bind.annotation.*;


@RestController
public class Greeting_saldasaoController {

    //Break Point para requisições do tipo GET para o envio de valores para serem somados
    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {

        //Tratamento de Exception caso o usuário informe uma letra no local de um numero
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please informe a Numeric Value !");
        }
        //Conversao do valor informado para um Double e logo apos, a soma dos mesmos
        return covertToDouble(numberOne) + covertToDouble(numberTwo);
    }

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
