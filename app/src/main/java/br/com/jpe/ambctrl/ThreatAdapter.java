package br.com.jpe.ambctrl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.jpe.ambctrl.bean.Threat;

public class ThreatAdapter extends BaseAdapter {

    final List<Threat> list;
    final LayoutInflater inflater;

    public ThreatAdapter(LayoutInflater inflater, List<Threat> list){
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
        TextView tv0 = (TextView) convertView.findViewById(R.id.textView);
        TextView tv1 = (TextView) convertView.findViewById(R.id.textView1);
        TextView tv2 = (TextView) convertView.findViewById(R.id.textView2);
        TextView tv3 = (TextView) convertView.findViewById(R.id.textView3);

        tv0.setText(ct.getThreat());
        tv1.setText(ct.getAddress());
        tv2.setText(ct.getNeighborhood());
        tv3.setText(String.valueOf(ct.getThreatLevel()));

        // returns the view for the current row
        return convertView;
    }
}
