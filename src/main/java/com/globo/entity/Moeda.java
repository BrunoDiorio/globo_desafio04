package com.globo.entity;

import com.globo.format.DecimalFormater;

import java.math.BigDecimal;

/**
 * POJO da moeda corrente
 * @author diorio
 */
public class Moeda {

    private BigDecimal valor;

    public Moeda(Double valor) {
        this.valor = BigDecimal.valueOf(valor);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return DecimalFormater.format(valor);
    }
}
