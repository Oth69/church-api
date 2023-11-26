package com.example.uploadtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    Context context;
    List<StudentModel> studentModelList;

    public StudentAdapter(Context context, List<StudentModel> studentModelList){
        this.context = context;
        this.studentModelList = studentModelList;
    }

    public StudentAdapter(FirebaseRecyclerOptions<StudentModel> options) {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.design_row_for_recyclerview,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        StudentModel studentModel = studentModelList.get(position);
        holder.city.setText("City :\n"+studentModel.getCity());
        holder.title.setText("Name :\n"+studentModel.getTitle());
        holder.description.setText("Surname :\n"+studentModel.getDescription());
        holder.skill.setText("Reason for prayer :\n"+studentModel.getSkill());
        holder.experience.setText("Name of disease :\n"+studentModel.getExperience());
        holder.extra.setText("Extra Details :\n"+studentModel.getExtra());
        holder.salary.setText("Testimony:\n"+studentModel.getSalary());

        String imageUri=null;
        imageUri=studentModel.getImage();
        Picasso.get().load(imageUri).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return studentModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView  title, description, skill, city, experience, extra, salary;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.image_recyclerView_id);
            title=itemView.findViewById(R.id.tvfirstname_recyclerview_id);
            description=itemView.findViewById(R.id.description_recyclerview_id);
            skill=itemView.findViewById(R.id.skill_recyclerview_id);
            city=itemView.findViewById(R.id.city_recyclerview_id);
            experience=itemView.findViewById(R.id.experience_recyclerview_id);
            extra=itemView.findViewById(R.id.extra_recyclerview_id);
            salary=itemView.findViewById(R.id.salary_recyclerview_id);


        }
    }
}
