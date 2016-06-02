package com.example.bay.ongisschool5;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by BAY on 6/1/2016.
 */
public class DatabaseActivity extends Activity{
    DatabaseHelper databaseHelper;
    EditText editName;
    EditText editAddress;
    Button buttonAdd;
    Button buttonView;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("ISLOGGEDIN",false);

        editor.apply();


        Boolean a=sharedPreferences.getBoolean("ISLOGGEDIN",true);

//        if(!a){
//            editor.putBoolean("ISLOGGEDIN",false);
//            editor.apply();
//            Intent i = new Intent(DatabaseActivity.this, TampilActivity.class);
//            startActivity(i);
//
//        }else {
            setContentView(R.layout.database);

            editName = (EditText) findViewById(R.id.editName);
            editAddress = (EditText) findViewById(R.id.editAddress);
            buttonAdd = (Button) findViewById(R.id.buttonAdd);
            buttonView = (Button) findViewById(R.id.buttonView);

            databaseHelper = new DatabaseHelper(this);

            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Person person = new Person(editName.getText().toString(), editAddress.getText().toString());
                    databaseHelper.addPerson(person);
                    editName.setText("");
                    editAddress.setText("");
                }
            });
            buttonView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(DatabaseActivity.this, TampilList.class);
                    startActivity(i);

                }
            });
//        }
    }
}
