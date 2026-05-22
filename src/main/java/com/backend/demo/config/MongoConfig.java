package com.backend.demo.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.lang.NonNull;

import java.util.Objects;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected @NonNull String getDatabaseName() {
        // Cámbialo por el nombre de tu base de datos en Atlas si no es "test"
        return "test";
    }

    @Override
    public @NonNull MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://211182_db_user:WpsoT9w9n8zjwnEr@cluster0.ioumynv.mongodb.net/?appName=Cluster0");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
        return Objects.requireNonNull(MongoClients.create(mongoClientSettings));
    }
}