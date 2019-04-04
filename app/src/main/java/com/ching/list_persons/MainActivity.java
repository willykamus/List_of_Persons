package com.ching.list_persons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import model.Employee;
import model.FileManager;
import model.Person;
import model.Student;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    int textviews[] = {R.id.textView3, R.id.textView4, R.id.textView5, R.id.textView6, R.id.textView7};
    Spinner spinner;
    ArrayList<TextView> textViews = new ArrayList<>();
    ArrayAdapter<CharSequence> spinner_adapter;
    ArrayAdapter<Person> list_adapter;
    ArrayList<Person> listStudents;
    ArrayList<Person> listEmployees;
    ListView listView;
    TextView textView_Title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

    }

    private void initialize() {
        // Initialize all the textviews
        for(int i = 0; i < textviews.length; i++){
            TextView textView = findViewById(textviews[i]);
            textView.setText("");
            textViews.add(textView);
        }

        initializeData();

        textView_Title = findViewById(R.id.textView_Title);

        spinner_adapter = ArrayAdapter.createFromResource(this, R.array.List_options, android.R.layout.simple_spinner_dropdown_item);
        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(spinner_adapter);
        spinner.setOnItemSelectedListener(this);

        list_adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        listView = findViewById(R.id.list_Persons);
        listView.setAdapter(list_adapter);
        listView.setOnItemClickListener(this);

    }

    private void initializeData() {

        listStudents = FileManager.readStudentsFromFile(this,"person.txt");
        listEmployees = FileManager.readEmployeesFromFile(this,"person.txt");

//        Person newStudent = new Student("William", 34, 101, "Mobile");
//        listStudents.add(newStudent);
//
//        newStudent = new Student("Ivette", 33, 102, "Business");
//        listStudents.add(newStudent);
//
//        newStudent = new Student("Tata", 25, 103, "Cooking");
//        listStudents.add(newStudent);
//
//        Person newEmployee = new Employee("Mir", 25, 1001, "Teacher", 10000.0);
//        listEmployees.add(newEmployee);
//
//        newEmployee = new Employee("Ramiro", 55, 1002, "Teacher", 15000.0);
//        listEmployees.add(newEmployee);
//
//        newEmployee = new Employee("Carlos", 45, 1003, "Administator", 8000.0);
//        listEmployees.add(newEmployee);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Person selectedPerson = (Person) parent.getItemAtPosition(position);

        for (int i = 0; i < textViews.size(); i++){
            textViews.get(i).setText("");
        }

        for (int i = 0; i < selectedPerson.displayInformation().size(); i++) {

            String str = selectedPerson.displayInformation().get(i);
            textViews.get(i).setText(str);

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String option = parent.getItemAtPosition(position).toString().toLowerCase();
        list_adapter.clear();

        switch (option){

            case "students":
                list_adapter.addAll(listStudents);
                textView_Title.setText("List of Students");
                break;

            case "employees":
                list_adapter.addAll(listEmployees);
                textView_Title.setText("List of Employees");
                break;
            case "all":
                list_adapter.addAll(listStudents);
                list_adapter.addAll(listEmployees);
                textView_Title.setText("List of Persons");
                break;
        }

        list_adapter.notifyDataSetChanged();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
