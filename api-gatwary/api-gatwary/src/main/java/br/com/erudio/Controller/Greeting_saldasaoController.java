package br.com.erudio.Controller;

import br.com.erudio.Greeting_saldacao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Greeting_saldasaoController {
    private static final String template = "Hello,%s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting_saldacao greetingSaldacao(@RequestParam(value = "name",defaultValue = "World") String name){
        return new Greeting_saldacao(counter.incrementAndGet(),String.format(template,name));
    }
}
