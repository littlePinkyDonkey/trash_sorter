package com.trash_sorter.util;

import com.trash_sorter.model.Admin;
import com.trash_sorter.model.Category;
import com.trash_sorter.model.Tank;
import com.trash_sorter.model.Trash;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Builder {

    private static String getProperty(String propName){
        String value = null;
        Properties properties = new Properties();
        Builder builder = new Builder();
        try(InputStream is = builder.getClass().getClassLoader()
                .getResourceAsStream("hibernatePROP.properties")){
            properties.load(is);
            value = properties.getProperty(propName);
        }catch (IOException e){
            e.printStackTrace();
        }

        return value;
    }

    public static Configuration getConfiguration(){
        Configuration config = new Configuration();
        config.addAnnotatedClass(Tank.class);
        config.addAnnotatedClass(Category.class);
        config.addAnnotatedClass(Trash.class);
        config.addAnnotatedClass(Admin.class);

        config.setProperty("hibernate.dialect",getProperty("dialect"));
        config.setProperty("hibernate.connection.driver_class",getProperty("driver.class"));
        config.setProperty("hibernate.connection.url", getProperty("connection.url"));
        config.setProperty("hibernate.connection.username", getProperty("username"));
        config.setProperty("hibernate.connection.password", getProperty("password"));
        config.setProperty("hibernate.show_sql", getProperty("show_sql"));
        config.setProperty("hibernate.hbm2ddl.auto", getProperty("hbm2ddl.auto"));

        return config;
    }
}
