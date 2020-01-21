package com.tools.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataFileOutput {

    private String filename;
    private Long countCustomer;
    private Long countSellers;
    private Integer biggestSale;
    private String lessSellerSold;

}
