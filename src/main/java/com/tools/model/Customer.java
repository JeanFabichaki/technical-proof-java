package com.tools.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

    private String cnpj;

    private String name;

    private String fieldActivity;

}
