package com.trash_sorter.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private Properties prop;

    public PropertyReader(String fileName){
        Properties properties = new Properties();
        try(InputStream is = PropertyReader.class.getClassLoader().getResourceAsStream(fileName)) {
            properties.load(is);
            this.prop = properties;
        } catch (IOException e) {
            System.out.println("Ошибка загрузки проперти файла");
        }
    }
    public String getProperty (String nameProperties){
        return this.prop.getProperty(nameProperties);
    }
}
