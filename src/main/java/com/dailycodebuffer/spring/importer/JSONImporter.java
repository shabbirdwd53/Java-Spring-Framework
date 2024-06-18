package com.dailycodebuffer.spring.importer;

import org.springframework.stereotype.Component;

@Component("jsonImporter")
public class JSONImporter  implements BaseImporter{
    public void importFile() {
        System.out.println("importing JSON file.");
    }
    public void getHeaders() {
        System.out.println("Providing list of headers present in JSON.");
    }
}
