package br.com.jpe.ambctrl.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AppDatabase extends SQLiteOpenHelper {

    public AppDatabase(Context context, String name) {
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_DB);
        db.execSQL(SQL_INIT_DB);
        System.out.println("*** Created database " + super.getDatabaseName());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("*** Upgraded database " + super.getDatabaseName());
    }

    public static final String SQL_CREATE_DB = new StringBuilder()
            .append("CREATE TABLE Threat (")
            .append(" Threat TEXT NOT NULL, ")
            .append(" Address TEXT NOT NULL, ")
            .append(" Neighborhood TEXT NOT NULL, ")
            .append(" ThreatLevel INTEGER NOT NULL ")
            .append(")")
            .toString();

    public static final String SQL_INIT_DB = new StringBuilder()
            .append("INSERT INTO Threat VALUES ")
            .append(" ('Perin', 'Novo Hamburgo' , 'Canudos', 666)")
            .toString();
}
