package com.tools.fixture;

import com.tools.model.DataFileOutput;

public class DataFileOutputFixture {

    public static DataFileOutput get() {

        return DataFileOutput.builder()
            .filename("test")
            .lessSellerSold("Renato")
            .countSellers(1l)
            .countCustomer(1l)
            .biggestSale(8)
            .build();
    }
}
