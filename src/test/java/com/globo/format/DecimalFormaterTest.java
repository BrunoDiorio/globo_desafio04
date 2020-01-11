package com.globo.format;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class DecimalFormaterTest {

    @Test
    public void formatZero() {
        assertEquals("R$ 0,00", DecimalFormater.format(BigDecimal.ZERO));
    }


    @Test
    public void formatValorUmPositivo() {
        assertEquals("R$ 1,00", DecimalFormater.format(BigDecimal.ONE));
    }

    @Test
    public void formatValorMilPositivo() {
        assertEquals("R$ 1.000,00", DecimalFormater.format(BigDecimal.TEN.pow(3)));
    }

    @Test
    public void formatValorMilaoPositivo() {
        assertEquals("R$ 1.000.000,00", DecimalFormater.format(BigDecimal.TEN.pow(6)));
    }

    @Test
    public void formatValorNegativo() {
        assertEquals("R$ -1,00", DecimalFormater.format(BigDecimal.ONE.negate()));
    }

    @Test
    public void formatValorMilNegativo() {
        assertEquals("R$ -1.000,00", DecimalFormater.format(BigDecimal.TEN.pow(3).negate()));
    }

    @Test
    public void formatValorMilaoNegativo() {
        assertEquals("R$ -1.000.000,00", DecimalFormater.format(BigDecimal.TEN.pow(6).negate()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void formatValorNull() {
        DecimalFormater.format(null);
    }

}