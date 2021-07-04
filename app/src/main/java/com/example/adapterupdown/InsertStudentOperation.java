package com.example.adapterupdown;

import android.os.AsyncTask;

public class InsertStudentOperation extends AsyncTask<Student, Void, String> {
    StudentOperations studentOperations;

    public InsertStudentOperation(StudentOperations studentOperations) {
        this.studentOperations = studentOperations;
    }

    @Override
    protected String doInBackground(Student... students) {
        try {
            MyApplication.getAppDatabase().userDao().insertAll(students);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        studentOperations.insertStudent(s);
    }
}
