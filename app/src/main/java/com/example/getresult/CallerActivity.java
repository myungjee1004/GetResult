package com.example.getresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class CallerActivity extends AppCompatActivity {
    private final int REQUEST_CODE_CALLEEACTIVITY = 1;
    // 상수. 변경을 금한다. 변수랑 구분하기 위해 대문자 사용.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflation
        setContentView(R.layout.activity_caller);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CallerActivity.this, CalleeActivity.class);
                intent.putExtra("data-number", 10);
                intent.putExtra("data-string", "Android");

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == REQUEST_CODE_CALLEEACTIVITY){
            if(resultCode != Activity.RESULT_OK){
                return;
            }
            else{
                int dataNumber = intent.getIntExtra("data-number", -1);
                String dataString = intent.getStringExtra("data-string");
                String data = "data number:" + dataNumber + ", data-string" + dataString;
                ((TextView)findViewById(R.id.tv_data)).setText(data);
            }
        }
        else{

        }
    }
}
