package com.tools.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Sale {

    private int saleId;

    private Item item;

    private String sellerName;

    public Double getItemPrice(){
        return this.item.getItemPrice().doubleValue();
    }

}
