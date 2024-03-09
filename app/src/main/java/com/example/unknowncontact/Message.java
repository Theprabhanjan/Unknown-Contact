package com.example.unknowncontact;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);

        EditText messageEditText = findViewById(R.id.textmsgfill);
        Button  SendTextMesaageButton;

        SendTextMesaageButton= (Button) findViewById(R.id.sendbutton);
        SendTextMesaageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String messgae = messageEditText.getText().toString();
            if(messgae.length()==0){
                Toast.makeText(Message.this,"Please Type something",Toast.LENGTH_LONG).show();
            }
                SmsManager sm= SmsManager.getDefault();
            }
        });


    }
}
