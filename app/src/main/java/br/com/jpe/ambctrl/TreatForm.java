package br.com.jpe.ambctrl;

import android.os.Bundle;
import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

public class TreatForm extends Activity implements Constants {

    private TextView action;
    private EditText threat;
    private EditText address;
    private EditText neighborhood;
    private EditText threatLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treat_form);

        this.action = (TextView) findViewById(R.id.tv_action);
        this.threat = (EditText) findViewById(R.id.et_treat);
        this.address = (EditText) findViewById(R.id.et_address);
        this.neighborhood= (EditText) findViewById(R.id.et_neighborhood);
        this.threatLevel = (EditText) findViewById(R.id.et_threatLevel);

    }

}
