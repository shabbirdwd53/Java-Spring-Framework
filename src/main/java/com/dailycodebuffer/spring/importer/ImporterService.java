package com.dailycodebuffer.spring.importer;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Now everything is business class
// Lets tell spring to create beans for us.
@Component
public class ImporterService {
    // DI - It means importer service is dependent on baseImporter
    // Which base importer to use that can be decided by spring Application

    private BaseImporter baseImporter;

    // Post construct helps to load pre-req data operations to be initialization after bean creation.
    // All your dI work already been done when post construct is invoked so you can utilize your dependencies if you want.
    @PostConstruct
    public void init() {
        System.out.println("Initializing data for importer service.");
        System.out.println("Is baseImporter null? ::" + (baseImporter==null));
    }

    @Autowired
    public ImporterService(BaseImporter baseImporter) {
        this.baseImporter = baseImporter;
    }

    public void importAll() {
        System.out.println("Importing file using importer : "+ baseImporter);
        baseImporter.getHeaders();
        baseImporter.importFile();
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Cleaning up data for importer service.");
    }
}
