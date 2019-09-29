package com.trash_sorter.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DbHelper {
    private final SessionFactory factory;

    private static DbHelper instance;
    private DbHelper(Configuration configuration){
        factory = createSessionFactory(configuration);
    }
    public static DbHelper getInstance(Configuration config){
        if (instance == null){
            synchronized (DbHelper.class){
                if (instance == null)
                    instance = new DbHelper(config);
            }
        }
        return instance;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
