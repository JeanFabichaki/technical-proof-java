package com.tools.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Seller {

    private String cpf;

    private String name;

    private BigDecimal salary;

}
