package com.coralogix.calculator.services;

import com.coralogix.calculator.dao.NumeroRepository;
import com.coralogix.calculator.model.Exange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


@Service
public class NumeroService {

    @Autowired
    NumeroRepository numeroRepository;

    public List<Exange> listExange() {
        return Streamable.of(numeroRepository.findAll()).toList();
    }

    /*
    5: Crear un endpointde nombre getMatrizByValue que haga el siguiente ejercicio. Dado un valor parámetro “userValue”
     que será enviado en el request se creará una matriz 10 x 10 donde en cada posición de la matriz i,j
     se coloque el valor:“(userValue* i) + valor de la matriz en la posición (i-1,j)”. El valor del parámetro
      “userValue” será ingresado desde consola (10 Min)
     */

    //getMatrizByValue
    public int[][] getMatrizByValue(int userValue) {
        int[][] matriz = new int[10][10];

        matriz[0][0] = 2;
        matriz[0][1] = 4;
        matriz[0][2] = 4;
        matriz[1][0] = 6;
        matriz[1][1] = 6;
        matriz[1][2] = 9;
        matriz[2][0] = 8;
        matriz[2][1] = 10;
        matriz[2][2] = 12;

        for (int x=0; x < matriz.length; x++) {
            for (int y=0; y < matriz[x].length; y++) {
               matriz[x][y] = (userValue * x) + (x-1);
            }
        }

        return matriz;
    }

    public String getMatrizByValue(String originCurrency, String finalCurrency){
        HttpClient client = HttpClient.newHttpClient();

        //http://api.apilayer.com/fixer/latest?base=USD&symbols=EUR

        HttpResponse<String> response;
        //builder.setParameter("parts", "all").setParameter("action", "finish");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.apilayer.com/fixer/latest?base="+originCurrency+"&symbols="+finalCurrency))
                .GET()
                .build();


        try {
             response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

         return response.toString();

    }



    /*
    public NumeroService(NumeroRepository numeroRepository) {
        this.numeroRepository = numeroRepository;
    }

    public List<Exange> listNumeros() {
        return Streamable.of(numeroRepository.findAll()).toList();
    }

    public List<Exange> findByNumber1LessThan(Double numero) {
        return Streamable.of(numeroRepository.findByNumber1LessThan(numero)).toList();
    }

    public List<Exange> findByNumber2GreaterThanEqual(Double numero) {
        return Streamable.of(numeroRepository.findByNumber2GreaterThanEqual(numero)).toList();
    }

    public Exange save(Exange numero) {
        return numeroRepository.save(numero);
    }


    public void update(Exange numero) {
        numeroRepository
                .findById(numero.getId())
                .ifPresent(num -> {
                    num.setNumber1(numero.getNumber1());
                    num.setNumber2(numero.getNumber2());
                    numeroRepository.save(num);
                });

    }

    public void updates(List<Exange> numeros) {
        numeros.forEach(numero -> {
            numeroRepository
                    .findById(numero.getId())
                    .ifPresent(num -> {
                        num.setNumber1(numero.getNumber1());
                        num.setNumber2(numero.getNumber2());
                        numeroRepository.save(num);
                    });
        });
    }*/

}
