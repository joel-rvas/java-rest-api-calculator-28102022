package com.coralogix.calculator.model;

import javax.persistence.*;
import java.util.Date;

@Entity
//@SequenceGenerator(name = "seq", initialValue = 5, allocationSize = 100)
@Table(name = "tbl_exange")
public class Exange {


    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    @Column(name = "origin_currency")
    private String originCurrency;
    @Column(name = "final_currency")
    private String finalCurrency;
    @Column
    private Date date;
    @Column
    private Double value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginCurrency() {
        return originCurrency;
    }

    public void setOriginCurrency(String originCurrency) {
        this.originCurrency = originCurrency;
    }

    public String getFinalCurrency() {
        return finalCurrency;
    }

    public void setFinalCurrency(String finalCurrency) {
        this.finalCurrency = finalCurrency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
