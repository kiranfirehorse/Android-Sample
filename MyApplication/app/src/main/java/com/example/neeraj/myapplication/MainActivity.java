package com.example.neeraj.myapplication;

import android.content.Intent;
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
    private Button loginButton;
    private TextView nameField,passwordField;
    private String name,password;
    private String toastMessage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);

        spinner=(Spinner) findViewById(R.id.spinner1);
        List<String> list= new ArrayList<String>();
        list.add("Customer");
        list.add("Employee");
        list.add("Intern");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,list);
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
            case R.id.loginButton:
                //Toast.makeText(MainActivity.this,"Jumanji",Toast.LENGTH_LONG).show();
                nameField=(TextView)findViewById(R.id.nameField);
                name=nameField.getText().toString();
                passwordField=(TextView)findViewById(R.id.passwordField);
                password=passwordField.getText().toString();

                if(name.equals("admin")&& password.equals("apple")){
                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                    startActivity(intent);
                }
                else {
                //        Intent intent = new Intent(MainActivity.this, HomePage.class);
                //        startActivity(intent);
                        toastMessage = "Incorrect Credentials !";
                    Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
