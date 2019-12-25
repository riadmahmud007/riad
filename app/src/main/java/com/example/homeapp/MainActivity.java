package com.example.homeapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    public Switch light1, lidht2,fan ;
    private DatabaseReference mDatabase ,db;
    private home h = new home();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        light1 = findViewById(R.id.lamp1);
        lidht2 = findViewById(R.id.lamp2);
        fan = findViewById(R.id.fan);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        db = FirebaseDatabase.getInstance().getReference("home");







       // light1.setChecked(true);
        light1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Toast.makeText(getApplicationContext(),"On light1",Toast.LENGTH_SHORT).show();
                    h.setLight1(1);
                    mDatabase.child("home").setValue(h);

                }
                else {
                    Toast.makeText(getApplicationContext(), "OFF light1", Toast.LENGTH_SHORT).show();
                    h.setLight1(0);
                    mDatabase.child("home").setValue(h);
                }
            }
        });
        lidht2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Toast.makeText(getApplicationContext(),"On lght2",Toast.LENGTH_SHORT).show();
                    h.setLight2(1);
                    mDatabase.child("home").setValue(h);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"OFF light2",Toast.LENGTH_SHORT).show();
                    h.setLight2(0);
                    mDatabase.child("home").setValue(h);
                }
            }
        });
        fan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Toast.makeText(getApplicationContext(),"On fan",Toast.LENGTH_SHORT).show();
                    h.setFan(1);
                    mDatabase.child("home").setValue(h);
                }
                else {
                    Toast.makeText(getApplicationContext(), "OFF fan", Toast.LENGTH_SHORT).show();
                    h.setFan(0);
                    mDatabase.child("home").setValue(h);
                }
            }
        });



        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                h = dataSnapshot.getValue(home.class);
                if(h.getFan()==1)
                {
                    fan.setChecked(true);
                }
                if(h.getLight1()==1)
                {
                    light1.setChecked(true);
                }
                if(h.getLight2()==1)
                {
                    lidht2.setChecked(true);
                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
