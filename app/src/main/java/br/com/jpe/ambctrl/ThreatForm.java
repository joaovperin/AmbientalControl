package br.com.jpe.ambctrl;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.jpe.ambctrl.bean.Threat;
import br.com.jpe.ambctrl.dao.ThreatDAO;
import br.com.jpe.ambctrl.db.Connection;
import br.com.jpe.ambctrl.db.ConnectionFactory;

public class ThreatForm extends Activity implements Constants {

    private String action;
    private Threat t;

    private TextView tv_action;
    private EditText tv_threat;
    private EditText tv_address;
    private EditText tv_neighborhood;
    private EditText tv_threatLevel;

    private Button bt_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threat_form);

        Bundle bundle = getIntent().getExtras();

        this.tv_action = (TextView) findViewById(R.id.tv_action);
        this.tv_threat = (EditText) findViewById(R.id.et_treat);
        this.tv_address = (EditText) findViewById(R.id.et_address);
        this.tv_neighborhood = (EditText) findViewById(R.id.et_neighborhood);
        this.tv_threatLevel = (EditText) findViewById(R.id.et_threatLevel);
        this.bt_confirm = (Button) findViewById(R.id.button);

        action = (String) bundle.get(P_ACTION);
        if (ACTION_INCLUDE.equals(action)){
            t = new Threat();
        } else {
            t = (Threat) bundle.get(P_THREAT);
            tv_threat.setText(t.getThreat());
            tv_address.setText(t.getAddress());
            tv_neighborhood.setText(t.getNeighborhood());
            tv_threatLevel.setText(String.valueOf(t.getThreatLevel()));
        }
        tv_action.setText(action);
    }

    public void onConfirmClick(View v){

        Connection conn = ConnectionFactory.getTransactionConnection(this);
        ThreatDAO dao = new ThreatDAO(conn);

        t.setThreat(tv_threat.getText().toString());
        t.setAddress(tv_address.getText().toString());
        t.setNeighborhood(tv_neighborhood.getText().toString());
        t.setThreatLevel(Integer.valueOf(tv_threatLevel.getText().toString()));

        if (ACTION_INCLUDE.equals(action)){
            dao.insert(t);
        } else {
            dao.update(t);
        }
        conn.commit();
        conn.close();
        finish();
    }

}
