package com.example;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import com.example.resource.UserResource;
import com.example.db.UserDAO;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class MyApplication extends Application<MyConfiguration> {
    public static void main(String[] args) throws Exception {
        new MyApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<MyConfiguration> bootstrap) {
        // Nothing fancy here for now
    }

    @Override
    public void run(MyConfiguration config, Environment env) {
        final Jdbi jdbi = Jdbi.create(config.getDatabaseUrl());
        // Create the table if it doesn't exist
        jdbi.useHandle(handle -> {
            handle.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "id IDENTITY PRIMARY KEY, " +
                    "name VARCHAR(100), " +
                    "email VARCHAR(100)" +
                    ")");
        });

        jdbi.installPlugin(new SqlObjectPlugin());

        final UserDAO userDAO = jdbi.onDemand(UserDAO.class);

        final UserResource userResource = new UserResource(userDAO);
        env.jersey().register(userResource);
    }
}
