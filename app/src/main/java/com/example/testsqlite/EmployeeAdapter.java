package com.example.testsqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testsqlite.databinding.ItemListBinding;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {
    Context context;
    ArrayList<Employee>al;
    public EmployeeAdapter(Context context,ArrayList<Employee>al){
        this.context = context;
        this.al = al;
    }
    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // item_list.xml
        ItemListBinding binding = ItemListBinding.inflate(LayoutInflater.from(context),parent,false);
        return new EmployeeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee e = al.get(position);
        holder.binding.tvName.setText(e.getName());
        holder.binding.tvDepartment.setText(e.getDepartment());
        holder.binding.tvSalary.setText("Salary : "+e.getSalary()+" Age: "+e.getAge());
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder{
      // item_list.xml
      ItemListBinding binding;
      public EmployeeViewHolder(ItemListBinding binding){
          super(binding.getRoot());
          this.binding = binding;
      }
  }
}
