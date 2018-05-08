package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgStars;
    EditText etNote;
    Button btnInsert;
    Button btnShowList;
    DBHelper db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        db = new DBHelper(this);
        db.getWritableDatabase();

        rgStars = (RadioGroup)findViewById(R.id.radioGroupStars);
        etNote = (EditText)findViewById(R.id.editTextNote);
        btnInsert = (Button)findViewById(R.id.buttonInsertNote);
        btnShowList = (Button)findViewById(R.id.buttonShowList);

        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                int selectedButtonId = rgStars.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton)findViewById(selectedButtonId);
                String rbText = rb.getText().toString();
                int starValue;

                if(rbText.equals("1")){
                    starValue = 1;
                }
                else if (rbText.equals("2")){
                    starValue = 2;

                }
                else if (rbText.equals("3")){
                    starValue = 3;

                }
                else if (rbText.equals("5")){
                    starValue = 4;

                }
                else{
                    starValue = 5;
                }
                db.insertNote(etNote.getText().toString(), starValue);
                db.close();
                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_LONG).show();

            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
