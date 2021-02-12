package com.example.modelclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.modelclass.Model.Cars;
import com.example.modelclass.adapter.CarsAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Like extends AppCompatActivity {

    FirebaseFirestore firebaseFirestore;
    List<Cars> carsList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);

        firebaseFirestore = FirebaseFirestore.getInstance();
        carsList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycleView) ;


        firebaseFirestore.collection("Cars").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()) {
                    for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {

                        carsList.add(snapshot.toObject(Cars.class));
                    }

                    CarsAdapter carsAdapter = new CarsAdapter(Like.this, carsList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(Like.this, LinearLayoutManager.VERTICAL, false));
                    recyclerView.setAdapter(carsAdapter);
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });



    }
}