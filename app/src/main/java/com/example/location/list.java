package com.example.location;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class list extends AppCompatActivity {
    List<Traffic> mTraffic;
    DatabaseReference databaseArtiest;
    private ListView fineList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        databaseArtiest = FirebaseDatabase.getInstance().getReference("abcd");
        mTraffic = new ArrayList<>();

    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseArtiest.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mTraffic.clear();
                for (DataSnapshot artiestSnapshot : dataSnapshot.getChildren()) {
                    Traffic traffic = artiestSnapshot.getValue(Traffic.class);
                    mTraffic.add(traffic);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });
    }
}

