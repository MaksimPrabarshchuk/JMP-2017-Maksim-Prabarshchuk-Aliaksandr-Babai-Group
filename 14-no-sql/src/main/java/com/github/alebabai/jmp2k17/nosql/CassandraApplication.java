package com.github.alebabai.jmp2k17.nosql;


public class CassandraApplication {

    public final static String[] CONTACT_POINTS = {"127.0.0.1"};
    public final static int PORT = 9042;

    public static void main(String[] args) {

        final CassandraClientService client = new CassandraClientServiceImpl();

        try {
            client.connect(CONTACT_POINTS, PORT);
            client.createSchema();
            client.insertData();
            client.readData();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            client.disconnect();
        }
    }


}
