package br.com.erudio.Controller;
import br.com.erudio.Converter.NumberConverter;
import br.com.erudio.Exception.UnsuportedMathOperationException;
import org.springframework.web.bind.annotation.*;


@RestController
public class Greeting_saldasaoController {


    //Break Point para requisições do tipo GET para o envio de valores para serem somados
    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {

        //Tratamento de Exception caso o usuário informe uma letra no local de um numero
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please informe a Numeric Value !");
        }
        //Conversao do valor informado para um Double e logo apos, a soma dos mesmos
        return NumberConverter.covertToDouble(numberOne) + NumberConverter.covertToDouble(numberTwo);
    }

    //Break point para requisicao do tipo GET para o envio de dois valores para serem subtraidos
    @RequestMapping(value = "/sub/{numberOne}/{numberTWO}", method = RequestMethod.GET)
    public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTWO") String numberTWO) throws Exception{

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTWO)){
            throw new UnsuportedMathOperationException("Please inform a Numeric Value !");
        }
        return NumberConverter.covertToDouble(numberOne) - NumberConverter.covertToDouble(numberTWO);
    }

    //Break point para requisicao do tipo GET para o envio de dois valores para serem multiplicados
    @RequestMapping(value = "/mult/{numberOne}/{numberTWO}", method = RequestMethod.GET)
    public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTWO") String numberTWO) throws Exception{

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTWO)){
            throw new UnsuportedMathOperationException("Please inform a Numeric Value !");
        }
        return NumberConverter.covertToDouble(numberOne) * NumberConverter.covertToDouble(numberTWO);
    }

    //Break point para requisicao do tipo GET para o envio de dois valores para serem divididos
    @RequestMapping(value = "/div/{numberOne}/{numberTWO}", method = RequestMethod.GET)
    public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTWO") String numberTWO) throws Exception{

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTWO)){
            throw new UnsuportedMathOperationException("Please inform a Numeric Value !");
        }
        return NumberConverter.covertToDouble(numberOne) /NumberConverter.covertToDouble(numberTWO);
    }

    //Break point para requisicao do tipo GET para o envio de dois valores para a obtencao da média entre eles
    @RequestMapping(value = "/med/{numberOne}/{numberTWO}", method = RequestMethod.GET)
    public Double med(@PathVariable("numberOne") String numberOne, @PathVariable("numberTWO") String numberTWO) throws Exception{

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTWO)){
            throw new UnsuportedMathOperationException("Please inform a Numeric Value !");
        }
        Double soma =  NumberConverter.covertToDouble(numberOne) + NumberConverter.covertToDouble(numberTWO);
        return soma / 2;
    }

    //Break point para requisicao do tipo GET para o envio de dois valores para a raiz quadrada
    @RequestMapping(value = "/sqrt/{numberOne}/{numberTWO}", method = RequestMethod.GET)
    public Double sqrt(@PathVariable("numberOne") String numberOne, @PathVariable("numberTWO") String numberTWO) throws Exception{

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTWO)){
            throw new UnsuportedMathOperationException("Please inform a Numeric Value !");
        }
        Double soma =  NumberConverter.covertToDouble(numberOne) + NumberConverter.covertToDouble(numberTWO);
        return (Double) Math.sqrt(soma);
    }
}
