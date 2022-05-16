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
    private EditText numer1;
    //String kontakt1, message = "Zapisano zmiany";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //kontakt1 = findViewById(R.id.numer1);

    }

    public void go_back(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void saveChanges(){

        //bazaNumerow = getSharedPreferences("gromaniecki.example.sms_ratunek", Context.MODE_PRIVATE);
        //edytorNumerow = bazaNumerow.edit();
        //edytorNumerow.putString("numerkontaktowy1", String.valueOf(numer1));
        //edytorNumerow.commit();
        //EditText editText1 = (EditText)findViewById(R.id.numer1);
        //editText1.setHint(String.valueOf(numer1));


        //int duration = Toast.LENGTH_SHORT;
        //Context context = getApplicationContext();
        //Toast toast = Toast.makeText(context, message, duration);
        //toast.show();


    }

}