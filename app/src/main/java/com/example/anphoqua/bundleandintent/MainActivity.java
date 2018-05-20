package com.example.anphoqua.bundleandintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText_first_name, editText_last_name;
    Button btn_sign_in;
    TextView textView_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_first_name = findViewById(R.id.main_activity_edt_first_name);
        editText_last_name = findViewById(R.id.main_activity_edt_last_name);
        btn_sign_in = findViewById(R.id.main_activity_btn_sign_in);
        textView_message = findViewById(R.id.main_activity_textview_message);

        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("first_name", editText_first_name.getText().toString().trim());
                bundle.putString("last_name", editText_last_name.getText().toString().trim());
                intent.putExtras(bundle);
                startActivityForResult(intent, 9);
//                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==9 && resultCode==RESULT_OK ) {

            String message = data.getExtras().getString("user_first_name");

            textView_message.setVisibility(View.VISIBLE);
            textView_message.setText(getString(R.string.activity_main_textview_message, message ));
        }
    }
}
