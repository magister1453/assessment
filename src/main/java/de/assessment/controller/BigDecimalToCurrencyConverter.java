package de.assessment.controller;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.math.BigDecimal;

/**
 * Created by Marc on 2/3/2019.
 */
public class BigDecimalToCurrencyConverter extends StdConverter<BigDecimal, String> {
    @Override
    public String convert(BigDecimal bigDecimal) {
        String currency = bigDecimal.toString();
        StringBuilder stringBuilder = new StringBuilder(currency);
        int count = 0;
        for (int i = currency.split("[.]")[0].length() - 1; i > 0; i--) {
            count++;
            if(count == 3){
                stringBuilder.insert(i, ",");
            }
        }
        stringBuilder.insert(0, "$");
        return stringBuilder.toString();
    }
}
