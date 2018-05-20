package com.example.anphoqua.bundleandintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {
    TextView textView_hello;
    Button btn_sign_out;

    String user_first_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        textView_hello = findViewById(R.id.sub_activity_textview_hello);
        btn_sign_out = findViewById(R.id.sub_activity_btn_sign_out);

        final Bundle bundle = getIntent().getExtras();
        user_first_name = bundle.getString("first_name");
        textView_hello.setText(getString(R.string.activity_sub_textview_hello,user_first_name));


        btn_sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("user_first_name", user_first_name);
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });



    }

}
