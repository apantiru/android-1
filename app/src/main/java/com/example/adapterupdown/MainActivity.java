package com.example.adapterupdown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity  {
    private EditText emailText;
    private EditText firstTest;
    private EditText last_name_text;
    private EditText ageText;
    private EditText faculty_text;
    private Button button;
    private Button go_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailText = findViewById(R.id.email);
        firstTest = findViewById(R.id.first_name);
        last_name_text = findViewById(R.id.last_name);
        ageText = findViewById(R.id.age);
        faculty_text = findViewById(R.id.faculty);
        button = findViewById(R.id.add_button);
        go_button = findViewById(R.id.see_button);
        go_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ViewActivty.class);
                startActivity(intent);
            }
        });
//        MyApplication myApplication = new MyApplication();
        Handler handler = new Handler();

         AppDatabase appDatabase = Room.databaseBuilder(
                this,
                AppDatabase.class,
                "students_database"
        ).allowMainThreadQueries().build();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Student student = new Student(last_name_text.getText().toString(), firstTest.getText().toString(), Integer.parseInt(ageText.getText().toString()), faculty_text.getText().toString(), emailText.getText().toString());
                                Student[] students = new Student[] {student};
                                appDatabase.userDao().insertAll(students);
                            }
                        });
                    }
                });

                thread.start();
            }
        });
        }
//
//    @Override
//    public void insertStudent(String result) {
//        if (result.equals("success"))
//            Toast.makeText(getApplicationContext(), "merge", Toast.LENGTH_LONG).show();
//        else
//            Toast.makeText(getApplicationContext(), "nu merge", Toast.LENGTH_LONG).show();
//    }
//
//    private void insertStudent() {
//        Student newStudent = new Student(last_name_text.getText().toString(), firstTest.getText().toString(), Integer.parseInt(ageText.getText().toString()), faculty_text.getText().toString(), emailText.getText().toString());
//        Student[] students = new Student[] {newStudent};
//        new InsertStudentOperation(this).execute(students);
//    }

}