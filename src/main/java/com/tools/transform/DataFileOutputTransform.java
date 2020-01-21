package com.tools.transform;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tools.model.DataFileInput;
import com.tools.model.DataFileOutput;
import com.tools.model.Sale;

public class DataFileOutputTransform {

    public DataFileOutput from(final DataFileInput dataFileInput) {

        final Optional<Entry<Integer, Double>> maxSale = dataFileInput.getSales()
            .stream()
            .collect(Collectors.groupingBy(Sale::getSaleId, Collectors.summingDouble(Sale::getItemPrice)))
            .entrySet().stream()
            .max(Comparator.comparingDouble(value -> value.getValue()));

        final Optional<Entry<String, Double>> minSales = dataFileInput.getSales()
            .stream()
            .collect(Collectors.groupingBy(Sale::getSellerName, Collectors.summingDouble(Sale::getItemPrice)))
            .entrySet().stream()
            .min(Comparator.comparingDouble(value -> value.getValue()));

        return DataFileOutput.builder()
            .countCustomer(dataFileInput.getCustomers().stream().distinct().count())
            .countSellers(dataFileInput.getSellers().stream().distinct().count())
            .biggestSale(maxSale.get().getKey())
            .lessSellerSold(minSales.get().getKey())
            .filename(dataFileInput.getFilename())
            .build();
    }

}
