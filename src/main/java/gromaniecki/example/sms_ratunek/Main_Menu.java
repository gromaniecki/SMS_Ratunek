package gromaniecki.example.sms_ratunek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main_Menu extends AppCompatActivity {
    SharedPreferences bazaNumerow;
    SharedPreferences.Editor edytorNumerow;
    private EditText kontakt1, kontakt2, kontakt3, kontakt4, kontakt5, message;
    //String kontakt1, message = "Zapisano zmiany";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //bazaNumerow = getSharedPreferences("gromaniecki.example.sms_ratunek", Context.MODE_PRIVATE);
        bazaNumerow = getSharedPreferences("gromaniecki.example.sms_ratunek", Context.MODE_PRIVATE);
        edytorNumerow = bazaNumerow.edit();

        kontakt1 = findViewById(R.id.numer1);
        kontakt2 = findViewById(R.id.numer2);
        kontakt3 = findViewById(R.id.numer3);
        kontakt4 = findViewById(R.id.numer4);
        kontakt5 = findViewById(R.id.numer5);
        message =  findViewById(R.id.trescSMS);

        //kontakt1 = findViewById(R.id.numer1);

    }

    public void go_back(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void saveChanges(View view){

        String[] tablicaKontaktow = {kontakt1.getText().toString(), kontakt2.getText().toString(),
                kontakt3.getText().toString(), kontakt4.getText().toString(),
                kontakt5.getText().toString(), message.getText().toString()};

        for (int i=0; i<5; i++){
            String number = tablicaKontaktow[i];
            String index = "numerkontaktowy"+Integer.toString(i);
            edytorNumerow.putString(index,number);
            edytorNumerow.commit();
        }

        edytorNumerow.putString("message", tablicaKontaktow[5]);
        edytorNumerow.commit();

    }

}