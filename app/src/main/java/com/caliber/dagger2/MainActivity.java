package com.caliber.dagger2;


import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText inUsername, inNumber;
    Button btnSave, btnGet;
    @Inject SharedPreferences sharedPreferences;
    private MyComponent myComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
       /* myComponent = DaggerMyComponent.builder()
                      .sharedPrefModule(new SharedPrefModule(this))
                      .build();
       myComponent.inject(this);*/
        App.myComponent(getApplicationContext()).inject(this);

    }
    private void initViews() {
        btnGet = findViewById(R.id.btnGet);
        btnSave = findViewById(R.id.btnSave);
        inUsername = findViewById(R.id.inUsername);
        inNumber = findViewById(R.id.inNumber);
        btnSave.setOnClickListener(this);
        btnGet.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btnGet:
                inUsername.setText(sharedPreferences.getString("username", "default"));
               // inUsername.setText(sharedPreferences.getString("username", "default"));
                inNumber.setText(sharedPreferences.getString("number", "12345"));
                Toast.makeText(this, "getButton clicked", Toast.LENGTH_SHORT).show();
                break;
               //inUsername.setText(sharedPrefModule.provideSharedPreferences());
            case R.id.btnSave:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", inUsername.getText().toString().trim());
                editor.putString("number", inNumber.getText().toString().trim());
                editor.apply();
                break;

        }
    }
}
