package com.tools.business;

import java.io.IOException;

import com.tools.exception.TechnicalProofException;
import com.tools.model.DataFileInput;

public class DataFileManager {

    private DataFileReader dataFileReader;

    private DataFileWriter dataFileWriter;

    public DataFileManager() {
        dataFileReader = new DataFileReader();
        dataFileWriter = new DataFileWriter();
    }

    public void transFormatFile(final String filePath, final String filename){

        final DataFileInput dataFileInput;
        try {
            dataFileInput = dataFileReader.populateDataFile(filePath, filename);
            dataFileWriter.createConsolidateFile(dataFileInput);
        } catch (IOException | TechnicalProofException e) {
            System.out.println("Erro ao ler arquivos na pasta input.");
        }


    }
}
