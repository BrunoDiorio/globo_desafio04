package com.globo.service;

import com.globo.entity.Moeda;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * REgras de calculo to troco
 * @author diorio
 */
public class CalculoService {

    private static final Moeda[]
            moedas  = { new Moeda(1D),  new Moeda(.50),  new Moeda(.25),  new Moeda(.10),  new Moeda(.05),  new Moeda(.01)},
            cedulas = { new Moeda(100D), new Moeda(50D), new Moeda(20D), new Moeda(10D), new Moeda(5D), new Moeda(2D)};

    public static BigDecimal calcularTroco(BigDecimal total, BigDecimal valorPago) throws Exception {
        if(valorPago.compareTo(total) < 0){
            throw new Exception("Valor pago é insuficiente");
        }
        return valorPago.subtract(total);
    }

    public static Map<Moeda, Integer> calcular(BigDecimal valor){

        Map<Moeda,Integer> map = new LinkedHashMap<>();

        valor = calcularPorVetor(valor, map, cedulas);
        calcularPorVetor(valor, map, moedas);


        return map;
    }

    private static BigDecimal calcularPorVetor(BigDecimal valor, Map<Moeda, Integer> map, Moeda[] currency) {
        for (Moeda moeda : currency) {
            while (valor.compareTo(moeda.getValor()) > -1) {
                valor = valor.subtract(moeda.getValor());

                int x = map.getOrDefault(moeda, 0) + 1;
                map.put(moeda, x);
            }
        }
        return valor;
    }
}
