package br.com.jpe.ambctrl.db;

import android.database.sqlite.SQLiteDatabase;

public interface Connection {

    void commit();
    void close();
    void execute(String sql);
    void execute(String sql, Object[] bindings);

    SQLiteDatabase getDb();

}
