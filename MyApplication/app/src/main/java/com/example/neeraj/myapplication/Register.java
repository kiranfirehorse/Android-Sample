package com.example.neeraj.myapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Register extends ActionBarActivity implements View.OnClickListener {


    private Spinner spinner;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    private Button regSubmitBtn;
    private RegisteredEmployee emp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        spinner=(Spinner) findViewById(R.id.regNewSpinner);
        regSubmitBtn=(Button) findViewById(R.id.regSubmitBtn);
        regSubmitBtn.setOnClickListener(this);

        List<String> list= new ArrayList<>();
        list.add("Customer");
        list.add("Employee");
        list.add("Intern");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list);
        spinner.setAdapter(dataAdapter);

        //Calander
        dateView = (TextView) findViewById(R.id.dateView);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        //Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2+1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
        String name=((TextView)findViewById(R.id.regNameEditText)).getText().toString();
        String type=((Spinner)findViewById(R.id.regNewSpinner)).getSelectedItem().toString();
        String mobileno= ((TextView)findViewById(R.id.regMobileEditText)).getText().toString();
        String email=((TextView)findViewById(R.id.regEmailEditText)).getText().toString();
        int genId=((RadioGroup)findViewById(R.id.GenderRadioGroup)).getCheckedRadioButtonId();
        String gender;
        if(genId==((RadioButton)findViewById(R.id.radioButton)).getId()){
            gender="Male";
        }
        else{
            gender ="Female";
        }
        String hobby =" ";
        CheckBox photo=(CheckBox)findViewById(R.id.checkPhoto);
        CheckBox driving=(CheckBox)findViewById(R.id.checkDriving);
        CheckBox sing=(CheckBox)findViewById(R.id.checkSinging);
        TextView otherHobbies=(TextView)findViewById(R.id.regHobbiesEditText);
        if(photo.isChecked()) {
            hobby = " Photography ";
        }
        if(driving.isChecked()){
            hobby=hobby+" Driving ";
        }
        if (sing.isChecked()){
            hobby=hobby+" Singing ";
        }
        if(!otherHobbies.getText().toString().matches("")){
            hobby=hobby+otherHobbies.getText().toString();
        }

        String dob=((TextView)findViewById(R.id.dateView)).getText().toString();
        String password=((TextView)findViewById(R.id.regPasswordEditText)).getText().toString();
        String about=((TextView)findViewById(R.id.regAboutMeEditText)).getText().toString();

        RegisteredEmployee emp;
        emp=new RegisteredEmployee(name,type,mobileno,email,gender,hobby,dob,password,about);

        Intent intent=new Intent(Register.this,DisplayRegistration.class);
        intent.putExtra("Employee",emp);
        startActivity(intent);
    }
}
