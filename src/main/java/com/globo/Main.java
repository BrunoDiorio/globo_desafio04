package com.globo;

import com.globo.entity.Moeda;
import com.globo.format.DecimalFormater;
import com.globo.service.CalculoService;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * Metodo main
 * @author diorio
 */
public class Main {

    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Valor a ser pago:");
            BigDecimal total = BigDecimal.valueOf(in.nextDouble());

            System.out.println("Valor efetivamente pago:");
            BigDecimal pago = BigDecimal.valueOf(in.nextDouble());


            BigDecimal troco = CalculoService.calcularTroco(total, pago);

            Map<Moeda, Integer> trocoMap = CalculoService.calcular(troco);

            System.out.println("Troco:" + DecimalFormater.format(troco));

            for (Moeda moeda : trocoMap.keySet()) {
                System.out.println(trocoMap.get(moeda) + " x " + moeda);
            }
        } catch (InputMismatchException e) {
            System.out.println("Apenas números reais separados por virgula");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
