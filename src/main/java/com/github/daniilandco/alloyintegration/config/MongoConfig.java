package com.github.daniilandco.alloyintegration.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Configuration class for setting up transaction functionality of mongo db.
 *
 * @author com.github.daniilandco
 * @version 1.0
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.github.daniilandco.alloyintegration")
@Profile("!test")
public class MongoConfig extends AbstractMongoClientConfiguration {
    @Value("${spring.data.mongodb.database}")
    private String databaseName;
    @Value("${spring.data.mongodb.uri}")
    private String connectionURI;

    /**
     * @param dbFactory instance of MongoDatabaseFactory which sets up mongo db
     * @return MongoTransactionManager instance which will be used by Spring to execute transactions in mongo db
     */
    @Bean
    MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }

    /**
     * Returns string representation of database name.
     *
     * @return name of the database
     */
    @Override
    @Profile("!test")
    protected String getDatabaseName() {
        return databaseName;
    }

    /**
     * @return MongoClient instance which will be used by Spring to execute transactions in mongo db and other operations
     */
    @Override
    public MongoClient mongoClient() {
        final ConnectionString connectionString = new ConnectionString(connectionURI);
        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }
}
