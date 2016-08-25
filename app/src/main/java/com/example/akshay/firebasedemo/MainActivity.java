package com.example.akshay.firebasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.client.core.Context;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText editTextName;
    private EditText editTextAddress;
    private TextView textViewPersons;
    private Button buttonSave;
    Context c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSave = (Button) findViewById(R.id.buttonSave);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);

        textViewPersons = (TextView) findViewById(R.id.textViewPersons);

        //Firebase.setAndroidContext(this);
        //Click Listener for button
        buttonSave.setOnClickListener(this) ;


}


    @Override
        public void onClick(View v) {
            //Creating firebase object
            Firebase ref = new Firebase(Config.FIREBASE_URL);

            //Getting values to store
            String name = editTextName.getText().toString().trim();
            String address = editTextAddress.getText().toString().trim();

            //Creating Person object
            Person person = new Person();

            //Adding values
            person.setName(name);
            person.setAddress(address);

            //Storing values to firebase
            ref.child("Person").setValue(person);
        }
    }