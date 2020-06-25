package com.example.firebasetest2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase db = FirebaseDatabase.getInstance ();
    DatabaseReference myRef = db.getReference ("message");
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        setTitle ("Hello Firebase");

        textView = (TextView) findViewById (R.id.textView);
        editText = (EditText)findViewById(R.id.inputText);

//        Button btnListener = (Button) findViewById(R.id.button);

        //myRef.setValue ("Hello Firebase");

//        btnListener.setOnClickListener (new View.OnClickListener () {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText (MainActivity.this, "Click event occured", Toast.LENGTH_SHORT).show();
//            }
//        });

//        myRef.addListenerForSingleValueEvent (new ValueEventListener () {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String val = (String) dataSnapshot.getValue ();
//                textView.setText (val);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
    }

    public void put_btn_Click(View view)
    {
//        TextView textView = (TextView)findViewById(R.id.textView);
//        EditText editText = (EditText)findViewById(R.id.inputText);
        String inData = editText.getText().toString ();

        //textView.setText(editText.getText());
        //textView.setText (myRef.getKey ())
        myRef.setValue(inData);
        editText.setText ("");
    }

    public  void get_btn_Click(View view) {
        String getData = myRef.getKey ();
        textView.setText (getData);

        myRef.addListenerForSingleValueEvent (new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String val = (String) dataSnapshot.getValue ();
                textView.setText (val);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}
