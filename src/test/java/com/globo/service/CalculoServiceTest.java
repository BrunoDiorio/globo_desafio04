package com.globo.service;

import com.globo.entity.Moeda;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculoServiceTest {


    @Test
    public void calcularTroco() throws Exception{
        BigDecimal valor = BigDecimal.valueOf(70D);
        BigDecimal valorPago = BigDecimal.valueOf(100D);

        BigDecimal troco = CalculoService.calcularTroco(valor, valorPago);
        assertEquals(troco, BigDecimal.valueOf(30D));
    }

    @Test
    public void calcularSemTroco() throws Exception{
        BigDecimal valor = BigDecimal.valueOf(10D);

        BigDecimal troco = CalculoService.calcularTroco(valor, valor);
        assertEquals( 0, troco.intValue()  );
    }

    @Test(expected = Exception.class)
    public void calcularValorPagoInsuficiente() throws Exception{
        BigDecimal valor = BigDecimal.valueOf(100D);
        BigDecimal valorPago = BigDecimal.valueOf(70D);

        BigDecimal troco = CalculoService.calcularTroco(valor, valorPago);
        assertEquals(troco, BigDecimal.valueOf(30D));
    }

    @Test
    public void calcularZeroTroco() {
        Map<Moeda, Integer> map = CalculoService.calcular(BigDecimal.ZERO);
        assertTrue(map.isEmpty());
    }

    @Test
    public void calcularValorNegativo() {
        Map<Moeda, Integer> map = CalculoService.calcular(BigDecimal.ONE.negate());
        assertTrue(map.isEmpty());
    }

    @Test
    public void calcularValorUm() {
        Map<Moeda, Integer> map = CalculoService.calcular(BigDecimal.ONE);
        assertEquals(1, map.size());
    }
}