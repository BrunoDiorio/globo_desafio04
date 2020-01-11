package com.globo.entity;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class MoedaTest {

    @Test
    public void getValor() {
        BigDecimal bd = BigDecimal.valueOf(10D);
        Moeda m = new Moeda(bd.doubleValue());
        assertEquals(bd, m.getValor());
    }

    @Test
    public void setValor() {
        BigDecimal bd = BigDecimal.valueOf(10D);
        Moeda m = new Moeda(bd.doubleValue());
        m.setValor(bd);
        assertEquals(bd, m.getValor());
    }
}