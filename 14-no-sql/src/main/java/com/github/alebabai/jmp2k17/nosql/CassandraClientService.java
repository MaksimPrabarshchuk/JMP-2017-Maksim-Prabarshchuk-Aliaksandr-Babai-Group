package com.github.alebabai.jmp2k17.nosql;


public interface CassandraClientService {
    void connect(String[] contactPoints, int port);

    void createSchema();

    void insertData();

    void readData();

    void disconnect();
}
