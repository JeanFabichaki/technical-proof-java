package com.tools.mapping;

import com.tools.model.Sale;

public class SalesMapping {

    public static Sale from(final String line) {

        final String[] fields = line.split(";");

        return Sale.builder()
            .saleId(Integer.parseInt(fields[1]))
            .item(ItemMapping.from(fields))
            .sellerName(fields[5])
            .build();
    }
}
