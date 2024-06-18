package com.dailycodebuffer.spring;

import com.dailycodebuffer.spring.importer.DependencyByFieldImporterService;
import com.dailycodebuffer.spring.importer.DependencyByMethodImporterService;
import com.dailycodebuffer.spring.importer.ImporterService;
import com.dailycodebuffer.spring.importer.SpringImportConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class LooselyCoupledSpringApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(SpringImportConfig.class);
        System.out.println("Started application and init completed.");
        var importerService = context.getBean(ImporterService.class);
        importerService.importAll();

        var dependencyByFieldImporterService = context.getBean(DependencyByFieldImporterService.class);
        dependencyByFieldImporterService.importAll();

        var dependencyByMethodImporterService = context.getBean(DependencyByMethodImporterService.class);
        dependencyByMethodImporterService.importAll();

        // Lets add one more time and see how json exporter is behaving
        var dependencyByMethodImporterService2 = context.getBean(DependencyByMethodImporterService.class);
        dependencyByMethodImporterService2.importAll();
        context.close(); // We need this when we are working with non-web application in case of web application server takes care of it and fires the pre destroy method.

    }
}
