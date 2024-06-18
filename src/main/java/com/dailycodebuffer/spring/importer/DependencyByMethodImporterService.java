package com.dailycodebuffer.spring.importer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy // This annotation is used to do lazy loading in the application which means if this bean get injected somewhere it will be init.
// Also this annotation can be used either on bean or component anywhere.
// Few advantage of Lazy is loading a bean which loads data helps to save memory until it get used.
// Other major advantage is cyclic dependency in the system.
public class DependencyByMethodImporterService {

    private BaseImporter baseImporter; // We are injecting using do wiring at setter method level and also notice we did similar thing for qualifier

    public DependencyByMethodImporterService() {
        System.out.println("DependencyByMethodImporterService init.");
    }
    @Autowired
    @Qualifier("jsonImporter")
    public void setBaseImporter(BaseImporter baseImporter) {
        this.baseImporter = baseImporter;
    }

    public void importAll() {
        System.out.println("Importing file using importer : "+ baseImporter);
        baseImporter.getHeaders();
        baseImporter.importFile();
    }
}
