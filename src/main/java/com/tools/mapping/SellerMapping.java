package com.tools.mapping;

import java.math.BigDecimal;

import com.tools.model.Seller;

public class SellerMapping {

    public static Seller from(final String line) {

        final String[] fields = line.split(";");

        return Seller.builder()
            .cpf(fields[1])
            .name(fields[2])
            .salary(new BigDecimal(fields[3]))
            .build();
    }

}
