package com.example.testsqlite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddEmployeeActivity extends AppCompatActivity {

    com.example.testsqlite.databinding.ActivityMainBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.testsqlite.databinding.ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= binding.etName.getText().toString();
                String deparment = binding.etDepartment.getText().toString();
                int age = Integer.parseInt(binding.etAge.getText().toString());
                int salary = Integer.parseInt(binding.etSalary.getText().toString());

                Employee employee  = new Employee(name,deparment,salary,age);
                boolean status = EmployeeDAO.save(employee,AddEmployeeActivity.this);
                if(status)
                    Toast.makeText(AddEmployeeActivity.this, "Employee saved", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AddEmployeeActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
