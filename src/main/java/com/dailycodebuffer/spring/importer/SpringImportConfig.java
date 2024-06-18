package com.dailycodebuffer.spring.importer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.dailycodebuffer.spring.importer") // Explain the role of component scan
public class SpringImportConfig {
    //We don't need this code now as we are need to let  spring now for scanning beans for us.
    // thats where component scan come into picture
    /*@Bean
    public BaseImporter importer() {
        return new CSVImporter();
    }

    @Bean
    public BaseImporter jsonImporter() {
        return new JSONImporter();
    }

    @Bean
    @Primary
    public ImporterService importerService() {
        return new ImporterService(importer());
    }

    @Bean
    public ImporterService jsonImporterService(@Qualifier("jsonImporter") BaseImporter importer) {
        return new ImporterService(importer);
    }*/

}
