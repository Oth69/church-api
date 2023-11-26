package com.example.uploadtest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity3 extends AppCompatActivity {
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    FirebaseStorage mStorage;
    ImageButton imageButton;

    EditText title,description,skill,city,experience,extra,salary;
    Button post;
    private static  final int Gallery_Code=1;
    Uri imageUrl=null;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        imageButton=findViewById(R.id.imageButton);
        title=findViewById(R.id.job_title);
        description=findViewById(R.id.job_description);
        skill=findViewById(R.id.job_skill);
        city=findViewById(R.id.job_city);
        experience=findViewById(R.id.job_experience);
        extra=findViewById(R.id.job_extra);
        salary=findViewById(R.id.job_salary);
        post=findViewById(R.id.btn_job_post);

        mDatabase=FirebaseDatabase.getInstance();
        mRef=mDatabase.getReference().child("Student");
        mStorage=FirebaseStorage.getInstance();
        progressDialog=new ProgressDialog(this);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,Gallery_Code);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == Gallery_Code && resultCode==RESULT_OK)
        {
            imageUrl=data.getData();
            imageButton.setImageURI(imageUrl);
        }

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fn= title.getText().toString().trim();
                String ln=description.getText().toString().trim();
                String xn=skill.getText().toString().trim();
                String gn=city.getText().toString().trim();
                String hn=experience.getText().toString().trim();
                String pn=extra.getText().toString().trim();
                String an=salary.getText().toString().trim();

                if(!(fn.isEmpty() && xn.isEmpty() && gn.isEmpty() && hn.isEmpty() && pn.isEmpty() && an.isEmpty() && ln.isEmpty() && imageUrl!=null ))
                {
                    progressDialog.setTitle("Uploading...");
                    progressDialog.show();
                    Toast.makeText(MainActivity3.this, "You have uploaded successfully!", Toast.LENGTH_LONG).show();


                    StorageReference filepath=mStorage.getReference().child("imagePost").child(imageUrl.getLastPathSegment());
                    filepath.putFile(imageUrl).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> downloadUrl=taskSnapshot.getStorage().getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {

                                    String t=task.getResult().toString();
                                    DatabaseReference newPost=mRef.push();


                                    newPost.child("Title").setValue(fn);
                                    newPost.child("Description").setValue(ln);
                                    newPost.child("Skill").setValue(xn);
                                    newPost.child("City").setValue(gn);
                                    newPost.child("Experience").setValue(hn);
                                    newPost.child("Extra").setValue(pn);
                                    newPost.child("Salary").setValue(an);
                                    newPost.child("image").setValue(task.getResult().toString());
                                    progressDialog.dismiss();

                                    Intent intent = new Intent(MainActivity3.this, RetrieveDataInRecyclerView.class);
                                    startActivity(intent);

                                }
                            });
                        }
                    });
                }

            }
        });
    }
}