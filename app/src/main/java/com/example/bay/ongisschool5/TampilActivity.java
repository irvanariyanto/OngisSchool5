package com.example.bay.ongisschool5;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by BAY on 6/1/2016.
 */
public class TampilActivity extends Activity{
    TextView textId;
    TextView textName;
    TextView textAddress;
    EditText editId;
    Button buttonEdit;
    Button buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampil_database);

        textId=(TextView)findViewById(R.id.textId);
        textName=(TextView)findViewById(R.id.textNama);
        textAddress=(TextView)findViewById(R.id.textAddress);
        editId=(EditText)findViewById(R.id.editId);
        buttonEdit=(Button)findViewById(R.id.buttonEdit);
        buttonDelete=(Button)findViewById(R.id.buttonDelete);
        final DatabaseHelper databaseHelper=new DatabaseHelper(this);
        ArrayList<Person> arrayList=databaseHelper.getAll();

        if(!arrayList.isEmpty()){
            int length=arrayList.size();
            for (int i=0;i<length;i++) {
                Person person = arrayList.get(i);
                textId.append("\n"+person.getId());
                textName.append("\n"+person.getName());
//                textName.setText(person.getName());
                textAddress.append("\n"+person.getAddress());
//                textAddress.setText(person.getAddress());

            }
        }
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.deletePerson(Integer.parseInt(textId.getText().toString()));
//                ArrayList<Person> arrayList=databaseHelper.getAll();
//
//                if(!arrayList.isEmpty()){
//                    int length=arrayList.size();
//                    for (int i=0;i<length;i++) {
//                        Person person = arrayList.get(i);
//                        textId.append("\n"+person.getId());
//                        textName.append("\n"+person.getName());
////                textName.setText(person.getName());
//                        textAddress.append("\n"+person.getAddress());
////                textAddress.setText(person.getAddress());
//
//                    }
//                }
            }
        });
    }
}
