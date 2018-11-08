package br.com.jpe.ambctrl;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import br.com.jpe.ambctrl.bean.Threat;
import br.com.jpe.ambctrl.dao.ThreatDAO;
import br.com.jpe.ambctrl.db.Connection;
import br.com.jpe.ambctrl.db.ConnectionFactory;

import static br.com.jpe.ambctrl.Constants.ACTION_ALTER;
import static br.com.jpe.ambctrl.Constants.P_ACTION;

public class ThreatAdapter extends BaseAdapter {

    final Activity at;
    final List<Threat> list;
    final LayoutInflater inflater;

    public ThreatAdapter(Activity at, LayoutInflater inflater, List<Threat> list){
        this.at=at;
        this.inflater = inflater;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.threat_list_item, parent, false);
        }

        // get current item to be displayed
        Threat ct = (Threat) getItem(position);
        // get the TextView for item name and item description
        final TextView tv0 = (TextView) convertView.findViewById(R.id.textView);
        final TextView tv1 = (TextView) convertView.findViewById(R.id.textView1);
        final TextView tv2 = (TextView) convertView.findViewById(R.id.textView2);
        final TextView tv3 = (TextView) convertView.findViewById(R.id.textView3);

        // EXCLUDE
        Button btExc = (Button) convertView.findViewById(R.id.bt_exc);
        btExc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = tv0.getText().toString();

                Connection conn = ConnectionFactory.getTransactionConnection(at);
                ThreatDAO dao = new ThreatDAO(conn);
                dao.delete(text);
                conn.commit();
                conn.close();
            }
        });
        // ALTER
        Button btAlt = (Button) convertView.findViewById(R.id.bt_alt);
        btAlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(at, ThreatForm.class);
                it.putExtra(P_ACTION, ACTION_ALTER);
                at.startActivity(it);
            }
        });

        tv0.setText(ct.getThreat());
        tv1.setText(ct.getAddress());
        tv2.setText(ct.getNeighborhood());
        tv3.setText(String.valueOf(ct.getThreatLevel()));

        // returns the view for the current row
        return convertView;
    }
}
