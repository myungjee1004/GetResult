package com.example.getresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class CalleeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Inflation
        setContentView(R.layout.activitiy_callee);

        /*
        Intent intent = getIntent();
        int dataNumber = intent.getIntExtra("data-number", -1);
        String dataString = intent.getStringExtra("data-string");

        String data = "data number:" + dataNumber + "data string:" + dataString;

        View view = findViewById(R.id.tv_data);
        ((TextView) view).setText(data);
        */

        // 더 간단한 방법으로
        findViewById(R.id.btn_finish).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("data-number", 10);
                intent.putExtra("data-string", "Android");
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
