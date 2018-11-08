package br.com.jpe.ambctrl;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.jpe.ambctrl.bean.Threat;
import br.com.jpe.ambctrl.dao.ThreatDAO;
import br.com.jpe.ambctrl.db.Connection;
import br.com.jpe.ambctrl.db.ConnectionFactory;

public class ThreatList extends Activity {

    ListView listView;
    final List<Threat> list = new ArrayList<>();
    ThreatAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threat_list);

        listView = (ListView) findViewById(R.id.listThreat);
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        listAdapter = new ThreatAdapter(layoutInflater, list);
        listView.setAdapter(listAdapter);

        Connection conn = ConnectionFactory.getReadConnection(this);
        ThreatDAO dao = new ThreatDAO(conn);
        for (Threat n : dao.select()){
            list.add(n);
        }
    }

}
