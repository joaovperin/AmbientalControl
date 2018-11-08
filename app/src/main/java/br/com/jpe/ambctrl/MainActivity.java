package br.com.jpe.ambctrl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.jpe.ambctrl.bean.Threat;

public class MainActivity extends Activity implements Constants {

    private TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.tv_info);
        tvInfo.setText(getInfoText());
    }

    public void openForm(View v){
        Intent it = new Intent(this, ThreatForm.class);
        it.putExtra(P_ACTION, ACTION_INCLUDE);
        startActivity(it);
    }
    public void openList(View v){
        Intent it = new Intent(this, ThreatList.class);
        startActivity(it);
    }

    private String getInfoText(){
        return new StringBuilder().
                append("Hello, I'm Perin :D").
                toString();
    }

}
