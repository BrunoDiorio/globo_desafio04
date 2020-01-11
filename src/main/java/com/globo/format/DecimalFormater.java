package com.globo.format;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Formatador de moeda corrente
 * @author diorio
 */
public class DecimalFormater {

    public static String format(BigDecimal bd){
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("R$ #,##0.00;R$ -#,##0.00");

        return df.format(bd);
    }
}
