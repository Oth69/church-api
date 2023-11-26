package com.example.uploadtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends FirebaseRecyclerAdapter<StudentModel,MainAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter(@NonNull FirebaseRecyclerOptions<StudentModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull StudentModel model) {
        holder.city.setText("City :\n"+model.getCity());
        holder.title.setText("Name :\n"+model.getTitle());
        holder.description.setText("Surname :\n"+model.getDescription());
        holder.skill.setText("Reason for prayer :\n"+model.getSkill());
        holder.experience.setText("Name of disease :\n"+model.getExperience());
        holder.extra.setText("Extra Details :\n"+model.getExtra());
        holder.salary.setText("Testimony:\n"+model.getSalary());


        Glide.with(holder.img.getContext())
                .load(model.getImage())
                .placeholder(com.google.firebase.storage.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new myViewHolder(v);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        CircleImageView img;
        TextView  title, description, skill, city, experience, extra, salary;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = (CircleImageView)itemView.findViewById(R.id.image_recyclerView_id);
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
