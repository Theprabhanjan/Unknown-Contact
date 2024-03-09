package com.example.unknowncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

//import com.example.unknowncontact.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
//    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding = ActivityMainBinding.inflate(getLayoutInflater() );
        setContentView(R.layout.activity_main);

        //button defination
        EditText phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
        Button sendMessageButton,callButton, TextMesaageButton;
         sendMessageButton =(Button) findViewById(R.id.sendMessageButton);
         callButton =(Button)findViewById(R.id.call);
         TextMesaageButton= (Button) findViewById(R.id.TextMessageButton);

//            button fuctioning code
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phoneNumber = phoneNumberEditText.getText().toString().trim();
                if (!phoneNumber.isEmpty()){
                    String whatsappLink = "https://api.whatsapp.com/send?phone=91" + phoneNumber;

                    // Open the link in the browser
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(whatsappLink));
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Messging to " + phoneNumber, Toast.LENGTH_LONG).show();

                }
                else
                    Toast.makeText(MainActivity.this, "Invalid Input !" ,Toast.LENGTH_LONG).show();


            }
        });
        EditText et1;

        callButton.setOnClickListener(new View.OnClickListener() {
            EditText et1;
            @Override
            public void onClick(View v) {
                et1 =(EditText) findViewById(R.id.phoneNumberEditText);

                String phoneNumber = et1.getText().toString();

                if (!phoneNumber.isEmpty()) {
                    String dial = "tel:" + phoneNumber;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                    Toast.makeText(MainActivity.this,"calling ..",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(MainActivity.this, "Invalid Input !" ,Toast.LENGTH_LONG).show();

            }
        });
        TextMesaageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1 = new Intent(MainActivity.this, Message.class);
//                String messgae = messageEditText.getText().toString();
                startActivity(it1);

            }
        });
    }
}
