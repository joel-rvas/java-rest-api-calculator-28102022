package com.coralogix.calculator;

import com.coralogix.calculator.model.Exange;
import com.coralogix.calculator.model.Result;
import com.coralogix.calculator.services.AddService;

import com.coralogix.calculator.services.NumeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("add")
public class AddController {

    @Autowired
    private AddService addService;

    @Autowired
    private NumeroService numeroService;

    @GetMapping
    public Result add(@RequestParam(name = "numeroUno") int a, @RequestParam(name = "numeroDos") int b) {
        return addService.add(a, b);
    }

    @GetMapping(value = "/exanges", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Exange> getNumeros() {
        return numeroService.listExange();
    }

    @GetMapping(value = "/getExchangeRate/{originCurrency}/{finalCurrency}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getMatrizByValue(@PathVariable String originCurrency, @PathVariable String finalCurrency) {
        return  numeroService.getMatrizByValue(originCurrency,finalCurrency);
    }

    // pendiente
    @GetMapping(value = "/getMatrizByValue/{uservalue}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int[][] getMatrizByValue(@PathVariable int uservalue) {
        return  numeroService.getMatrizByValue(uservalue);
    }


   /* @GetMapping(value = "/numeros", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Exange> getNumeros() {
        return numeroService.listNumeros();
    }

    @GetMapping(value = "/numeroMenor", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Exange> getNumerosMenor(@RequestParam(name = "numero") Double numero) {
        return numeroService.findByNumber1LessThan(numero);
    }

    @GetMapping(value = "/numeroMayor/{numero}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Exange> getNumerosMayor(@PathVariable Double numero) {
        return numeroService.findByNumber2GreaterThanEqual(numero);
    }

    @PostMapping("/numero")
    public Exange guardarTipoCambio(@RequestBody Exange numero) throws Exception {
        return numeroService.save(numero);
    }

    @PutMapping("/numero")
    public void actualizarTipoCambio(@RequestBody Exange numero) throws Exception {
        numeroService.update(numero);
    }

    @PutMapping("/numeros")
    public void actualizarTipoCambio(@RequestBody List<Exange> numeros) throws Exception {
        numeroService.updates(numeros);
    }*/

}
