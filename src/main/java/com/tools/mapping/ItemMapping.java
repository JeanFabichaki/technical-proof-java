package com.tools.mapping;

import com.tools.model.Item;

public class ItemMapping {

    public static Item from(final String[] fields) {

        return Item.builder()
            .itemId(fields[2])
            .itemQuantity(Integer.parseInt(fields[3]))
            .itemPrice(Double.parseDouble(fields[4]))
            .build();
    }

}
