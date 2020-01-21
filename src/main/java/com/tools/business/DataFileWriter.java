package com.tools.business;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.tools.exception.TechnicalProofException;
import com.tools.transform.DataFileOutputTransform;
import com.tools.model.DataFileInput;
import com.tools.model.DataFileOutput;
import com.tools.util.Util;

public class DataFileWriter {

    public void createConsolidateFile(final DataFileInput dataFileInput) throws TechnicalProofException {
        DataFileOutputTransform mapping = new DataFileOutputTransform();
        final DataFileOutput dataFileOutput = mapping.from(dataFileInput);
        writeFileOutput(dataFileOutput);
    }

    private void writeFileOutput(final DataFileOutput dataFileOutput) throws TechnicalProofException {
        Path path = Util.getPathOutputFile(dataFileOutput.getFilename());

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {

            writer.write("1. Quantidade de Clientes: " + dataFileOutput.getCountCustomer());
            writer.newLine();
            writer.write("2. Quantidade de Vendedores: " + dataFileOutput.getCountSellers());
            writer.newLine();
            writer.write("3. ID da Venda de valor mais alto: " + dataFileOutput.getBiggestSale());
            writer.newLine();
            writer.write("4. Nome do Vendedor que menos vendeu: " + dataFileOutput.getLessSellerSold());

        } catch (IOException e) {
           throw new TechnicalProofException("Erro ao criar arquivo consolidado.");
        }
    }


}
