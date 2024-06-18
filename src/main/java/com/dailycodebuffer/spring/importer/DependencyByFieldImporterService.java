package com.dailycodebuffer.spring.importer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DependencyByFieldImporterService {

    // DI - It means importer service is dependent on baseImporter
    // Which base importer to use that can be decided by spring Application
    @Autowired
    private BaseImporter baseImporter; // We are injecting using do wiring at field level

    public DependencyByFieldImporterService() {
        System.out.println("DependencyByFieldImporterService init.");
    }
    public void importAll() {
        System.out.println("Importing file using importer : "+ baseImporter);
        baseImporter.getHeaders();
        baseImporter.importFile();
    }
}
