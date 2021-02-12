package com.example.modelclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.example.modelclass.Model.Cars;
import com.example.modelclass.adapter.CarsAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextInputEditText edtModel,edtPrice;
    Button btnAddcar,btnGetcar;
    FirebaseFirestore firebaseFirestore;
    String TAG="TAGER";
    RecyclerView recyclerView;
    List<Cars> carsList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtModel=findViewById(R.id.edtModel);
        edtPrice=findViewById(R.id.edtPrice);
        btnAddcar=findViewById(R.id.btnAddcar);
        btnGetcar=findViewById(R.id.btnGetcar);
        firebaseFirestore=FirebaseFirestore.getInstance();
        recyclerView=findViewById(R.id.recycleView);
        carsList =new ArrayList<>();

        btnAddcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cars cars=new Cars(edtModel.getText().toString(),edtPrice.getText().toString());
                firebaseFirestore.collection("Cars").document(edtModel.getText().toString()).set(cars).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "Successfull", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Log.d(TAG, "onFailure: "+e.getMessage());                    }
                });
            }
        });

        btnGetcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Like.class);
                startActivity(intent);
            }
        });





//        btnAddcar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Cars cars=new Cars(edtModel.getText().toString(),edtPrice.getText().toString());
//
//                firebaseFirestore.collection("Cars").document(edtModel.getText().toString()).set(cars).addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        Toast.makeText(MainActivity.this, "successful Added", Toast.LENGTH_SHORT).show();
//
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//
//                        Log.d(TAG, "onFailure: "+e.getMessage());
//
//                    }
//                });
//            }
//        });
//
//        btnGetcar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                firebaseFirestore.collection("Cars").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//
//                       if(!queryDocumentSnapshots.isEmpty()){
//
//
//                           for(DocumentSnapshot snapshot:queryDocumentSnapshots.getDocuments()){
//                            carsList.add(snapshot.toObject(Cars.class));
//                           }
//
//                           CarsAdapter carsAdapter=new CarsAdapter(MainActivity.this,carsList);
//                           recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
//                           recyclerView.setAdapter(carsAdapter);
//                       }
//
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.d(TAG, "onFailure: "+e.getMessage());
//                    }
//                });
//            }
//        });





    }
}
