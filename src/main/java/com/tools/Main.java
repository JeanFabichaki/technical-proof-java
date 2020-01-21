package com.tools;

import java.io.IOException;

import com.tools.exception.TechnicalProofException;
import com.tools.util.DirectoryWatcher;
import com.tools.util.Util;

public class Main {

    public static void main(String[] args)
        throws TechnicalProofException, IOException {
        Util.createPathStructure();
        Util.readFilesAlreadyAdded();
        DirectoryWatcher.watch();
    }
}
