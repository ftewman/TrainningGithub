package com.example.quyetchu.trainninggithub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    EditText etNewName;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        etNewName = (EditText) findViewById(R.id.etNameUpdate);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);

        etNewName.setText(getIntent().getStringExtra("name"));
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName = etNewName.getText().toString();

                Intent intent = new Intent();

                intent.putExtra("new_name", newName);

                setResult(RESULT_OK, intent);

                finish();
            }
        });

    }
}
