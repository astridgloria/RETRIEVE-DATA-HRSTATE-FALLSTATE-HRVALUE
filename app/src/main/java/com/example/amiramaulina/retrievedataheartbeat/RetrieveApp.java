package com.example.amiramaulina.retrievedataheartbeat;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RetrieveApp extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;


    Integer hrValue;
    String dateValueHR;
    String dateFallState;
    String fallstateValue;
    String dateHRState;
    String hrstateValue;


    //ArrayAdapter adapter;
    ArrayList<String> array;
    ArrayList<String> array1; //array untuk date HR
    ArrayList<Integer> array2; //array untuk HR
    ArrayList<String> array3; //array untuk date fallstate
    ArrayList<String> array4; //array untuk fallstateValue
    ArrayList<String> array5; //array untuk date hrstate
    ArrayList<String> array6; //array untuk hrstate



    private ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_app);

        DatabaseReference userdatabase = FirebaseDatabase.getInstance().getReference().child("Users");
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        DatabaseReference ref = userdatabase.child(user.getUid());


        array = new ArrayList<>();
        array1 = new ArrayList<>(); //array untuk Date hr
        array2 = new ArrayList<>(); //array untuk hr
        array3 = new ArrayList<>(); //array untuk Date fallstate
        array4 = new ArrayList<>(); //array untuk fallstate value
        array5 = new ArrayList<>(); //array untuk date hrstate
        array6 = new ArrayList<>(); //array untuk hrstate
        //adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, array);


        //RETRIEVE DATA HR VALUE + DATE
        ref.child("hrvalue").child("nilaihr").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                dateValueHR = dataSnapshot.child("Date").getValue(String.class);
                hrValue = dataSnapshot.child("tmpHR").getValue(Integer.class);
                Log.i("date value", "date value " + dateValueHR);
                Log.i("hr value", "hr value " + hrValue);
                showData(dataSnapshot);
            }


            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //RETRIEVE DATA FALLSTATE VALUE + DATE
        ref.child("fallstate").child("nilaifallstate").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                dateFallState = dataSnapshot.child("Date").getValue(String.class);
                fallstateValue = dataSnapshot.child("fallstate").getValue(String.class);
                Log.i("date fallstate", "date fallstate " + dateFallState);
                Log.i("fallstate value", "fallstate value " + fallstateValue);
                showData(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //RETRIEVE DATA HRSTATE VALUE + DATE
        ref.child("hrstate").child("nilaihrstate").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                dateHRState = dataSnapshot.child("Date").getValue(String.class);
                hrstateValue = dataSnapshot.child("hrstate").getValue(String.class);
                Log.i("date hrstate", "date hrstate " + dateHRState);
                Log.i("hrstate value", "hrstate value " + hrstateValue);
                showData(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


    private void showData(DataSnapshot dataSnapshot) {

        //Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
        String nameval = dataSnapshot.child("name").getValue(String.class); //set the name
        String emailval = dataSnapshot.child("email").getValue(String.class); //set the email


        /*array = dataSnapshot.child("hrvalue").child("nilaihr").getValue(CreateHR.class);
        Log.i("database value", "name " + nameval);*/
        //uInfo.setPhone_num(ds.child(userID).getValue(CreateUser.class).getPhone_num()); //set the phone_num

        array1.add(dateValueHR);
        array2.add(hrValue);
        array3.add(dateFallState);
        array4.add(fallstateValue);
        array5.add(dateHRState);
        array6.add(hrstateValue);
        // array.add(uInfo.getPhone_num());
        //mListView.setAdapter(adapter);
    }
}

