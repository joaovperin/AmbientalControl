package br.com.jpe.ambctrl.dao;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.jpe.ambctrl.bean.Threat;
import br.com.jpe.ambctrl.db.Connection;

public class ThreatDAO {

    public static final String TABLE_NAME = "Threat";
    public static final String COLUMN_THREAT = "Threat";
    public static final String COLUMN_ADDRESS = "Address";
    public static final String COLUMN_NEIGHBORHOOD = "Neighborhood";
    public static final String COLUMN_THREAT_LEVEL = "ThreatLevel";

    private final Connection conn;

    public ThreatDAO(Connection conn) {
        this.conn = conn;
    }

    public void insert(Threat bean){
        ContentValues values = new ContentValues();
        values.put(COLUMN_THREAT, bean.getThreat());
        values.put(COLUMN_ADDRESS, bean.getAddress());
        values.put(COLUMN_NEIGHBORHOOD, bean.getNeighborhood());
        values.put(COLUMN_THREAT_LEVEL, bean.getThreatLevel());
        conn.getDb().insert(TABLE_NAME, null, values);
    }

    public void update(Threat bean){
        ContentValues values = new ContentValues();
        values.put(COLUMN_ADDRESS, bean.getAddress());
        values.put(COLUMN_NEIGHBORHOOD, bean.getNeighborhood());
        values.put(COLUMN_THREAT_LEVEL, bean.getThreatLevel());
        conn.getDb().update(TABLE_NAME, values, COLUMN_THREAT.concat(" = ? "), new String[]{bean.getThreat()});
    }

    public void delete(String threat){
        conn.getDb().delete(TABLE_NAME, COLUMN_THREAT.concat(" = ? "), new String[]{threat});
    }

    public List<Threat> select(){
        return select(COLUMN_THREAT);
    }

    public List<Threat> select(String order){
        List<Threat> list = new ArrayList<>();
        String[] columns = {COLUMN_THREAT, COLUMN_ADDRESS, COLUMN_NEIGHBORHOOD,COLUMN_THREAT_LEVEL};
        Cursor cursor = conn.getDb().query(TABLE_NAME, columns,null,null,null,null, order);
        // Iterates the query result
        if(cursor.getCount() != 0){
            cursor.moveToFirst();
            do{
                Threat bean = new Threat();
                bean.setThreat((cursor.getString(cursor.getColumnIndex(COLUMN_THREAT))));
                bean.setAddress((cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS))));
                bean.setNeighborhood((cursor.getString(cursor.getColumnIndex(COLUMN_NEIGHBORHOOD))));
                bean.setThreatLevel((cursor.getInt(cursor.getColumnIndex(COLUMN_THREAT_LEVEL))));
                list.add(bean);
            } while(cursor.moveToNext());
        }
        return list;
    }

}
