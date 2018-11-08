package br.com.jpe.ambctrl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
        System.out.println("OPEN FORM");
    }
    public void openList(View v){
        System.out.println("OPEN LIST");
    }

    private String getInfoText(){
        return new StringBuilder().
                append("Hello, I'm Perin :D").
                toString();
    }

}
