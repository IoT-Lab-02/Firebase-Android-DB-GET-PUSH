// https://console.firebase.google.com/project/fir-test2-ad6d3/database/fir-test2-ad6d3/data

package com.example.firebasetest2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase db = FirebaseDatabase.getInstance ();
    DatabaseReference myRef = db.getReference ("message");
//    DatabaseReference myRef = db.getReference ();

    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        setTitle ("Hello Firebase");

        textView = (TextView) findViewById (R.id.textView);
        editText = (EditText)findViewById(R.id.inputText);
    }

    public void put_btn_Click(View view)
    {
        String inData = editText.getText().toString ();
        //myRef.setValue(inData);
        //myRef.push.setValue(inData);
        myRef.push().child("test").setValue(inData);
        editText.setText ("");
    }

    public  void get_btn_Click(View view) {

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String data = dataSnapshot.getValue().toString();
                textView.append (data.toString() + "\n");
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
