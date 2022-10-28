package com.coralogix.calculator.dao;

import com.coralogix.calculator.model.Exange;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NumeroRepository extends CrudRepository<Exange, Long> {



    /*
    List<Exange> findByNumber1LessThan(Double numero);

    List<Exange> findByNumber2GreaterThanEqual(Double numero);

    */

}
