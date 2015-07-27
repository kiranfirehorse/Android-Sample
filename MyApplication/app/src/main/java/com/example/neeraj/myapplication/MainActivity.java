package com.example.neeraj.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private Spinner spinner;
    private Button loginButton,registerButton;
    private TextView nameField,passwordField;
    private String name,password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField=(TextView)findViewById(R.id.nameField);
        passwordField=(TextView)findViewById(R.id.passwordField);

        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);

        registerButton=(Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(this);

        spinner=(Spinner) findViewById(R.id.spinner1);
        List<String> list= new ArrayList<>();
        list.add("Customer");
        list.add("Employee");
        list.add("Intern");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list);
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginButton:  // Starting login Activity
                nameField=(TextView)findViewById(R.id.nameField);
                passwordField=(TextView)findViewById(R.id.passwordField);
                name=nameField.getText().toString();
                password=passwordField.getText().toString();

                if(name.equals("admin")&& password.equals("apple")){
                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                    startActivity(intent);
                }
                else {
                        Toast.makeText(MainActivity.this,"Incorrect Credentials !", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.registerButton: // Starting Register Activity
                Intent intent= new Intent(MainActivity.this,Register.class);
                startActivity(intent);
        }
    }
}
