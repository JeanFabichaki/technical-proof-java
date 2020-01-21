package com.tools.business;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.tools.conf.Configuration;
import com.tools.mapping.CustomerMapping;
import com.tools.mapping.SalesMapping;
import com.tools.mapping.SellerMapping;
import com.tools.model.Customer;
import com.tools.model.DataFileInput;
import com.tools.model.InformationType;
import com.tools.model.Sale;
import com.tools.model.Seller;

public class DataFileReader {

    public DataFileInput populateDataFile(final String filePath, final String filename) throws IOException {

        List<String> lines = new ArrayList<>();

        lines = Files.lines(Paths.get(filePath))
            .collect(Collectors.toList());

        final List<Seller> sellers = lines.stream()
            .filter(line -> line.startsWith(InformationType.SELLER.code))
            .map(lineSeller -> SellerMapping.from(lineSeller))
            .collect(Collectors.toList());

        final List<Customer> customers = lines.stream()
            .filter(line -> line.startsWith(InformationType.CUSTOMER.code))
            .map(lineCustomer -> CustomerMapping.from(lineCustomer))
            .collect(Collectors.toList());

        final List<Sale> sales = lines.stream()
            .filter(line -> line.startsWith(InformationType.SALES.code))
            .map(line -> SalesMapping.from(line))
            .collect(Collectors.toList());

        return DataFileInput.builder()
            .filename(getFileNameWithoutExtension(filename))
            .sales(sales)
            .sellers(sellers)
            .customers(customers)
            .build();
    }

    private String getFileNameWithoutExtension(final String filename) {
        return filename.replaceFirst(Configuration.extensionFIle, "");
    }
}
