package com.github.alebabai.jmp2k17.nosql;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Objects;
import java.util.UUID;

import static java.lang.System.out;

public class CassandraClientServiceImpl implements CassandraClientService {

    private Cluster cluster;
    private Session session;

    private static String insertQuery() {
        return "INSERT INTO jmp.songs (id, title) " +
                "VALUES (" +
                UUID.randomUUID().toString() + "," +
                "'" + RandomStringUtils.randomAlphabetic(10) + "'" +
                ");";
    }

    private static String batchInsertQuery() {
        final StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("BEGIN BATCH\n");
        for (long i = 0; i < 1000L; i++) {
            queryBuilder.append(insertQuery()).append("\n");
        }
        queryBuilder.append("APPLY BATCH;");
        return queryBuilder.toString();
    }

    /**
     * Initiates a connection to the cluster
     * specified by the given contact point.
     *
     * @param contactPoints the contact points to use.
     * @param port          the port to use.
     */
    @Override
    public void connect(String[] contactPoints, int port) {

        cluster = Cluster.builder()
                .addContactPoints(contactPoints).withPort(port)
                .build();

        out.printf("Connected to cluster: %s%n", cluster.getMetadata().getClusterName());

        session = cluster.connect();
    }

    /**
     * Creates the schema (keyspace) and tables
     * for this example.
     */
    @Override
    public void createSchema() {
        final Session safeSession = Objects.requireNonNull(this.session, "Connection required!");

        safeSession.execute("CREATE KEYSPACE IF NOT EXISTS jmp WITH replication " +
                "= {'class':'SimpleStrategy', 'replication_factor':1};");

        safeSession.execute(
                "CREATE TABLE IF NOT EXISTS jmp.songs (" +
                        "id uuid PRIMARY KEY," +
                        "title text" +
                        ");");
    }

    /**
     * Inserts data into the tables.
     */
    @Override
    public void insertData() {
        final Session safeSession = Objects.requireNonNull(this.session, "Connection required!");

        out.println("Perform inserts in cycle\n");
        for (long i = 0; i < 10L; i++) {
            safeSession.execute(insertQuery());
        }

        out.println("Perform inserts in batch mode\n");
        safeSession.execute(batchInsertQuery());
    }

    /**
     * Queries and displays data.
     */
    @Override
    public void readData() {
        final Session safeSession = Objects.requireNonNull(this.session, "Connection required!");

        safeSession.execute("SELECT * FROM jmp.songs")
                .forEach(result -> out.printf("%-30s\t%-20s%n", result.getUUID("id").toString(), result.getString("title")));
    }

    /**
     * Closes the session and the cluster.
     */
    @Override
    public void disconnect() {
        if (session != null && cluster != null) {
            session.close();
            cluster.close();
        }
    }
}
