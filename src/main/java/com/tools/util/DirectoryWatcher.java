package com.tools.util;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import com.tools.exception.TechnicalProofException;
import com.tools.business.DataFileManager;
import com.tools.conf.Configuration;

public class DirectoryWatcher {

    public static void watch() throws TechnicalProofException {

        try {

            WatchService watchService
                = FileSystems.getDefault().newWatchService();

            Path path = Util.getPathInput();

            path.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE);

            WatchKey key;
            while ((key = watchService.take()) != null) {
                for (WatchEvent<?> event : key.pollEvents()) {

                    if (event.context().toString().endsWith(Configuration.extensionFIle)) {
                        String filePath = path.toString().concat("\\").concat(event.context().toString());

                        DataFileManager fileManager = new DataFileManager();
                        fileManager.transFormatFile(filePath, event.context().toString());
                    }
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            throw new TechnicalProofException("Erro ao escutar modificações do pasta de input");
        }
    }


}
