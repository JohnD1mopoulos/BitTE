package com.BitTE.OptimizationProject;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Manages the database connection pool using HikariCP.
 */
public class ConnectionPool {
    private static final HikariDataSource DATA_SOURCE;
    private static final Logger logger = LoggerFactory.getLogger(ConnectionPool.class);
    private static final int MAX_RETRIES = 4;

    static {
        Properties dbProps = new Properties();
        try (InputStream is = ConnectionPool.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (is == null) {
                logger.error("config.properties file not found. Cannot connect to database.");
                throw new RuntimeException("config.properties file not found");
            }
            dbProps.load(is);

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(dbProps.getProperty("dataSource.url"));
            config.setUsername(dbProps.getProperty("dataSource.user"));
            config.setPassword(dbProps.getProperty("dataSource.password"));
            config.setDriverClassName(dbProps.getProperty("dataSourceClassName"));
            config.setMinimumIdle(Integer.parseInt(dbProps.getProperty("hikari.minimumIdle")));
            config.setMaximumPoolSize(Integer.parseInt(dbProps.getProperty("hikari.maximumPoolSize")));
            config.setIdleTimeout(Long.parseLong(dbProps.getProperty("hikari.idleTimeout")));
            config.setMaxLifetime(Long.parseLong(dbProps.getProperty("hikari.maxLifetime")));
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", dbProps.getProperty("hikari.prepStmtCacheSize"));
            config.addDataSourceProperty("prepStmtCacheSqlLimit", dbProps.getProperty("hikari.prepStmtCacheSqlLimit"));

            DATA_SOURCE = new HikariDataSource(config);
        } catch (Exception e) {
            logger.error("Failed to load and configure database settings", e);
            throw new RuntimeException("Failed to load and configure database settings", e);
        }
    }

    /**
     * Retrieves a connection from the pooled datasource.
     *
     * @return A database connection from the pool.
     * @throws SQLException if a database access error occurs or the connection limit is reached.
     */
    public static Connection getConnection() throws SQLException {
        SQLException lastException = null;
        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
            try {
                return DATA_SOURCE.getConnection();
            } catch (SQLException e) {
                lastException = e;
                logger.error("Attempt {} failed to get database connection: {}", attempt, e.getMessage());
                if (attempt < MAX_RETRIES) {
                    try {
                        Thread.sleep(2000); // Wait 2 seconds before retrying
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        logger.error("Thread was interrupted during connection retry wait.", ie);
                        throw new SQLException("Thread interrupted during connection retries", ie);
                    }
                }
            }
        }
        logger.error("Failed to get database connection after {} attempts.", MAX_RETRIES, lastException);
        throw new SQLException("Failed to get database connection after " + MAX_RETRIES + " attempts.", lastException);
    }
}
