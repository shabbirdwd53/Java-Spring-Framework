package com.dailycodebuffer.spring.importer;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) // We defined prototype bean so ideally it will be init on every request.
// By default it is singleton. As notice see constructor called twice and also the hashcode of object is different.
public class CSVImporter implements  BaseImporter {
    public CSVImporter() {
        System.out.println("CSVImporter init.");
    }
    public void importFile() {
        System.out.println("importing CSV file.");
    }
    public void getHeaders() {
        System.out.println("Providing list of headers present in CSV.");
    }
}
