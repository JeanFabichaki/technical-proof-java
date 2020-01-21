package com.tools.mapping;

import com.tools.model.Customer;

public class CustomerMapping {

    public static Customer from(final String line) {
        final String[] fields = line.split(";");
        
        return Customer.builder()
            .cnpj(fields[1])
            .name(fields[2])
            .fieldActivity(fields[3])
            .build();
    }

}
