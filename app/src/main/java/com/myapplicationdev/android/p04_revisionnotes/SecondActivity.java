package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class SecondActivity extends AppCompatActivity {
    ArrayAdapter aa;
    ArrayList<Note> notes;
    DBHelper db;
    ListView lvNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO implement the Custom ListView
        setContentView(R.layout.activity_second);
        lvNote = (ListView) findViewById(R.id.lvDetail);

        db = new DBHelper(this);
        db.getWritableDatabase();
        notes = db.getAllNotes();
        db.close();
        aa = new RevisionNotesArrayAdapter(SecondActivity.this, R.layout.row, notes);
        lvNote.setAdapter(aa);
    }

}
