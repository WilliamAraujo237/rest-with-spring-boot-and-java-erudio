package br.com.erudio.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class Greeting_saldasaoController {
    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new Exception();
        }
        return covertToDouble(numberOne) + covertToDouble(numberTwo);
    }

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

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null){
            return false;
        }
        String number = strNumber.replaceAll(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
