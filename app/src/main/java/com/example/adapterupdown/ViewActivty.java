package com.example.adapterupdown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ViewActivty extends AppCompatActivity {
    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_activty);

        lst= (ListView) findViewById(R.id.list_view);


        List<Student> students = new ArrayList<>();
        AppDatabase appDatabase = Room.databaseBuilder(
                this,
                AppDatabase.class,
                "students_database"
        ).allowMainThreadQueries().build();
        students = appDatabase.userDao().getAll();

        ArrayAdapter<Student> arrayadapter=new ArrayAdapter<Student>(this,android.R.layout.simple_list_item_1,students);
        lst.setAdapter(arrayadapter);
    }
}