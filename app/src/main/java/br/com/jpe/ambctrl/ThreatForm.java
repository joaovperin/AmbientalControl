package br.com.jpe.ambctrl;

import android.os.Bundle;
import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

import br.com.jpe.ambctrl.bean.Threat;

public class ThreatForm extends Activity implements Constants {

    private String action;
    private Threat t;

    private TextView tv_action;
    private EditText tv_threat;
    private EditText tv_address;
    private EditText tv_neighborhood;
    private EditText tv_threatLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threat_form);

        action = (String) savedInstanceState.get(P_ACTION);
        t = (Threat) savedInstanceState.get(P_THREAT);

        this.tv_action = (TextView) findViewById(R.id.tv_action);
        this.tv_threat = (EditText) findViewById(R.id.et_treat);
        this.tv_address = (EditText) findViewById(R.id.et_address);
        this.tv_neighborhood = (EditText) findViewById(R.id.et_neighborhood);
        this.tv_threatLevel = (EditText) findViewById(R.id.et_threatLevel);

        tv_action.setText(action);

        tv_threat.setText(t.getThreat());
        tv_address.setText(t.getAddress());
        tv_neighborhood.setText(t.getNeighborhood());
        tv_threatLevel.setText(String.valueOf(t.getThreatLevel()));

        if(ACTION_QUERY.equals(action) || ACTION_ALTER.equals(ACTION_ALTER)){
            //tv_threat.disable();
            //tv_address.disable
            //tv_neighborhood.disable
            //tv_threatLevel.disable
        }
    }

}
