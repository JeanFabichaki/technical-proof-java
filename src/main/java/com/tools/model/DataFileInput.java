package com.tools.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataFileInput {
    private String filename;
    private List<Customer> customers;
    private List<Sale> sales;
    private List<Seller> sellers;
}
