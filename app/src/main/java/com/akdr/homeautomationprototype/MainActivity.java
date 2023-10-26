package com.akdr.homeautomationprototype;

import android.content.Intent;
import android.os.Bundle;

import android.provider.ContactsContract;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    public Switch D1, D2, D3, D4, D5, D6, D7, D8;

    public Boolean Dt1=false, Dt2=false, Dt3=false, Dt4=false, Dt5=false, Dt6=false, Dt7=false, Dt8=false;

    public ImageView Sta1, Sta2, Sta3, Sta4, Sta5, Sta6, Sta7, Sta8;

    private final String D_PATH ="HA/";

    private final FirebaseAuth auth = FirebaseAuth.getInstance();

    private final FirebaseDatabase FBD = FirebaseDatabase.getInstance();
    private final DatabaseReference DREF= FBD.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton LO = (ImageButton) findViewById(R.id.LOGOUT);
        ImageButton AO = (ImageButton) findViewById(R.id.AllOFF);

        D1 = (Switch) findViewById(R.id.D1);
        D2 = (Switch) findViewById(R.id.D2);
        D3 = (Switch) findViewById(R.id.D3);
        D4 = (Switch) findViewById(R.id.D4);
        D5 = (Switch) findViewById(R.id.D5);
        D6 = (Switch) findViewById(R.id.D6);
        D7 = (Switch) findViewById(R.id.D7);
        D8 = (Switch) findViewById(R.id.D8);

        Sta1 = (ImageView) findViewById(R.id.Stat1);
        Sta2 = (ImageView) findViewById(R.id.Stat2);
        Sta3 = (ImageView) findViewById(R.id.Stat3);
        Sta4 = (ImageView) findViewById(R.id.Stat4);
        Sta5 = (ImageView) findViewById(R.id.Stat5);
        Sta6 = (ImageView) findViewById(R.id.Stat6);
        Sta7 = (ImageView) findViewById(R.id.Stat7);
        Sta8 = (ImageView) findViewById(R.id.Stat8);

        LO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LOGOUT();
            }
        });

        AO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ALLOFF();
            }
        });

        D1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(D1.isChecked()){
                    DREF.child(D_PATH+"Hall").setValue(1);
                    Sta1.setImageResource(R.drawable.on);
                }
                else{
                    DREF.child(D_PATH+"Hall").setValue(0);
                    Sta1.setImageResource(R.drawable.off);
                }
            }
        });

        D2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(D2.isChecked()){
                    DREF.child(D_PATH+"Hall Fan").setValue(1);
                    Sta2.setImageResource(R.drawable.on);
                    }
                else{
                    DREF.child(D_PATH+"Hall Fan").setValue(0);
                    Sta2.setImageResource(R.drawable.off);
                }
            }
        });

        D3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(D3.isChecked()){
                    DREF.child(D_PATH+"B1").setValue(1);
                    Sta3.setImageResource(R.drawable.on);}
                else{
                    DREF.child(D_PATH+"B1").setValue(0);
                    Sta3.setImageResource(R.drawable.off);
                }
            }
        });

        D4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(D4.isChecked()){
                    DREF.child(D_PATH+"B1 Fan").setValue(1);
                    Sta4.setImageResource(R.drawable.on);
                }
                else{
                    DREF.child(D_PATH+"B1 Fan").setValue(0);
                    Sta4.setImageResource(R.drawable.off);
                }
            }
        });

        D5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(D5.isChecked()){
                    DREF.child(D_PATH+"B2").setValue(1);
                    Sta5.setImageResource(R.drawable.on);
                }
                else{
                    DREF.child(D_PATH+"B2").setValue(0);
                    Sta5.setImageResource(R.drawable.off);
                }
            }
        });

        D6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(D6.isChecked()){
                    DREF.child(D_PATH+"B2 Fan").setValue(1);
                    Sta6.setImageResource(R.drawable.on);
                }
                else{
                    DREF.child(D_PATH+"B2 Fan").setValue(0);
                    Sta6.setImageResource(R.drawable.off);
                }
            }
        });

        D7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(D7.isChecked()){
                    DREF.child(D_PATH+"B3").setValue(1);
                    Sta7.setImageResource(R.drawable.on);
                }
                else{
                    DREF.child(D_PATH+"B3").setValue(0);
                    Sta7.setImageResource(R.drawable.off);
                }
            }
        });

        D8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(D8.isChecked()){
                    DREF.child(D_PATH+"B3 Fan").setValue(1);
                    Sta8.setImageResource(R.drawable.on);
                }
                else{
                    DREF.child(D_PATH+"B3 Fan").setValue(0);
                    Sta8.setImageResource(R.drawable.off);
                }
            }
        });

    }
    private void ALLOFF() {

        // Hall Light Switch
        DREF.child(D_PATH+"Hall").setValue(0);
        Sta1.setImageResource(R.drawable.off);

        // Hall Fan Switch
        DREF.child(D_PATH+"Hall Fan").setValue(0);
        Sta2.setImageResource(R.drawable.off);

        // B1 Light Switch
        DREF.child(D_PATH+"B1").setValue(0);
        Sta3.setImageResource(R.drawable.off);

        // B1 Fan Switch
        DREF.child(D_PATH+"B1 Fan").setValue(0);
        Sta4.setImageResource(R.drawable.off);

        // B2 Light Switch
        DREF.child(D_PATH+"B2").setValue(0);
        Sta5.setImageResource(R.drawable.off);

        // B2 Fan Switch
        DREF.child(D_PATH+"B2 Fan").setValue(0);
        Sta6.setImageResource(R.drawable.off);

        // B3 Light Switch
        DREF.child(D_PATH+"B3").setValue(0);
        Sta7.setImageResource(R.drawable.off);

        // B3 Fan Switch
        DREF.child(D_PATH+"B3 Fan").setValue(0);
        Sta8.setImageResource(R.drawable.off);

        Toast.makeText(MainActivity.this, "All Equipments\n Turned \"OFF\" Successfully", Toast.LENGTH_SHORT).show();

    }

    private void LOGOUT(){
        auth.signOut();
        Toast.makeText(MainActivity.this, "Logged out Successfully!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }



}