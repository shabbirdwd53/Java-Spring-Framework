package com.dailycodebuffer.spring;

import com.dailycodebuffer.spring.importer.CSVImporter;
import com.dailycodebuffer.spring.importer.ImporterService;
import com.dailycodebuffer.spring.importer.JSONImporter;

public class JavaCouplingExample {
    public static void main(String[] args) {
        var csvImporter = new CSVImporter();
        // This is example of loose coupling using java interface. we have BASEImporter which helps us to change the behaviour of importer service
        // without making change to our business logic where are using this importers. So say tomorrow we have requirements of adding new import type of xml.
        // so we just need to define our new importer utils without changing our core business service.
        var importerService = new ImporterService(csvImporter);
        importerService.importAll();

        var jsonImporter = new JSONImporter();
        var importerServiceJson = new ImporterService(jsonImporter);
        importerServiceJson.importAll();
    }
}
