package com.example.submitspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner, spinner2;
    ImageView img;
    CheckBox checkBox1, checkBox2,checkBox,checkBox3,checkBox4;
    RadioButton radioButtonMale, radioButtonFemale;
    RadioGroup radioGroup;
    RatingBar ratingBar;
   Button btnSub3;
    TextView result;
    String sex;
    String rate;
    String textResult = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnSub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String platform ="";
                textResult="";
                String favorite ="";
                if (checkBox1.isChecked()) {
                    platform = platform + "," + checkBox1.getText();
                }
                if (checkBox2.isChecked()) {
                    platform = platform + "," + checkBox2.getText();
                }
                platform = platform.substring(1);
                textResult = textResult + "Your platform: " + platform +'\n';
                //=======================================================
                if (checkBox.isChecked()) {
                    favorite = favorite + "," + checkBox.getText();
                }
                if (checkBox3.isChecked()) {
                    favorite = favorite + "," + checkBox3.getText();
                }
                if (checkBox4.isChecked()) {
                    favorite = favorite + "," + checkBox4.getText();
                }
                favorite = favorite.substring(1);
                textResult = textResult + "Your favorite: " + favorite + '\n';
                //======================================================
                textResult = textResult + "Your vote: " + ratingBar.getNumStars() + '\n';
                //======================================================
                textResult = textResult + "Your country: " + spinner.getSelectedItem().toString() + '\n';
                //============================================================
                textResult = textResult + "Your university: " + spinner2.getSelectedItem().toString() + '\n';
                //=============================================================
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        int id=group.getCheckedRadioButtonId();
                        RadioButton rb=(RadioButton) findViewById(id);

                        String radioText=rb.getText().toString();

                        textResult = textResult + "Your gender: " + radioText + '\n';
                    }
                });

                result.setText(textResult);
            }
        });


        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> country  = new ArrayList<String>();
        country.add("Vietnam");
        country.add("China");
        country.add("USA");
        country.add("Russia");
        country.add("Japan");
        country.add("Laos");

        List<String> universiry = new ArrayList<String>();
        universiry.add("PTIT");
        universiry.add("HUST");
        universiry.add("NEU");
        universiry.add("NUCE");
        universiry.add("RMIT");
        universiry.add("HANU");

        // Creating adapter for spinner
        ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,country);
        ArrayAdapter<String> univerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, universiry);
        // Drop down layout style - list view with radio button
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        univerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(countryAdapter);
        spinner2.setAdapter(univerAdapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    private void init(){
        // Spinner element
        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        img = findViewById(R.id.imageView);
        checkBox= findViewById(R.id.checkBox);
        checkBox1=findViewById(R.id.checkBox1);
        checkBox2=findViewById(R.id.checkBox2);
        checkBox3=findViewById(R.id.checkBox3);
        checkBox4=findViewById(R.id.checkBox4);
        radioGroup=findViewById(R.id.radioGroup);
        radioButtonMale = findViewById(R.id.rbtnMale);
        radioButtonFemale=findViewById(R.id.rbtnFemale);
        ratingBar = findViewById(R.id.ratingBar);
        btnSub3=findViewById(R.id.btnSub3);
        result = findViewById(R.id.textResult);
    }
}
