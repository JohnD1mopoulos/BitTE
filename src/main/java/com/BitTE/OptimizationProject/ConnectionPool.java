import java.sql.Connection;
import java.sql.SQLException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides database connection management using HikariCP connection pooling.
 * This class configures and provides a HikariDataSource for efficient database access.
 */
public class ConnectionPool {
    private static final HikariDataSource DATA_SOURCE;
    private static final int MAX_RETRIES = 4;
    private static final Logger logger = LoggerFactory.getLogger(ConnectionPool.class);

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/Bite_DB"); // Database URL
        config.setUsername("root"); // Database username
        config.setPassword("Bite2005!"); // Database password
        config.addDataSourceProperty("cachePrepStmts", "true"); // Enables caching of prepared statements
        config.addDataSourceProperty("prepStmtCacheSize", "250"); // The size of the prepared statements cache
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "3000"); // The maximum length of a prepared SQL statement
        config.setMaximumPoolSize(10); // Sets the maximum number of connections in the pool
        config.setMinimumIdle(5); // Sets the minimum number of idle connections in the pool
        config.setIdleTimeout(300000); // Sets the maximum time a connection can stay idle before being closed
        config.setMaxLifetime(600000); // Sets the maximum lifetime in milliseconds of a pool connection
        DATA_SOURCE = new HikariDataSource(config);
    }

    /**
     * Gets a database connection from the pool.
     *
     * @return A database connection.
     * @throws SQLException If a database access error occurs or the connection limit is reached.
     */
    public static Connection getConnection() throws SQLException {
        SQLException lastException = null;
        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
            try {
                return DATA_SOURCE.getConnection();
            } catch (SQLException e) {
                lastException = e;
                logger.error(Attempt {} failed to get database connection: {} attempt, e);
                if (attempt < MAX_RETRIES) {
                    try {
                        Thread.sleep(2000); // wait for 2 seconds before retrying
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt(); // restore interrupted status
                        logger.error("Thread was interrupted during connection retry wait.");
                        throw new SQLException("Thread interrupted during connection retries", ie);
                    }
                }
            }
        }
        logger.error("Failed to get database connection after {} attempts.", MAX_RETRIES, lastException);
        throw new SQLException("Failed to get database connection after " + MAX_RETRIES + " attempts.", lastException);
    }
}
