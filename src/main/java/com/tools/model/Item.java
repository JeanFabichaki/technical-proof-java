package com.tools.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {

    private String itemId;

    private Integer itemQuantity;

    private Double itemPrice;

}
