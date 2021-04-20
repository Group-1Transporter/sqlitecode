package com.example.testsqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.testsqlite.databinding.ActivityMainBinding;
import com.example.testsqlite.databinding.EmployeeListBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EmployeeListBinding binding;
    ArrayList<Employee>al;
    EmployeeAdapter adapter;

    @Override
    protected void onStart() {
        super.onStart();
        binding = EmployeeListBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        al = EmployeeDAO.getEmployeeList(this);
        adapter = new EmployeeAdapter(this,al);
        binding.rv.setAdapter(adapter);
        binding.rv.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Add Employee");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent in = new Intent(this,AddEmployeeActivity.class);
        startActivity(in);
        return super.onOptionsItemSelected(item);
    }
}