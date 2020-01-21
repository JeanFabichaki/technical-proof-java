package com.tools.fixture;

import java.math.BigDecimal;
import java.util.Arrays;

import com.tools.model.Customer;
import com.tools.model.DataFileInput;
import com.tools.model.Item;
import com.tools.model.Sale;
import com.tools.model.Seller;

public class DataFileInputFixture {

    public static DataFileInput get() {

        final Seller seller = Seller.builder()
            .cpf("1234567891234")
            .name("Diego")
            .salary(new BigDecimal(5000.00))
            .build();

        final Customer customer = Customer.builder()
            .cnpj("2345675434544345")
            .name("Jose da Silva")
            .fieldActivity("Rural")
            .build();

        final Item item = Item.builder()
            .itemId("13410")
            .itemQuantity(540)
            .itemPrice(2400.10)
            .build();

        final Sale sale = Sale.builder()
            .saleId(8)
            .item(item)
            .sellerName("Renato")
            .build();

        return DataFileInput.builder()
            .customers(Arrays.asList(customer))
            .sellers(Arrays.asList(seller))
            .sales(Arrays.asList(sale))
            .filename("test")
            .build();
    }

}
