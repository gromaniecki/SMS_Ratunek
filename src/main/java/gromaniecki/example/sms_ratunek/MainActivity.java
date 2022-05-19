package gromaniecki.example.sms_ratunek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

public class MainActivity extends AppCompatActivity {
    //Initialize variable
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    private EditText editTextNumber;
    private EditText editTextMessage;
    FusedLocationProviderClient fusedLocationProviderClient;

    //shared Preferences
    public SharedPreferences bazaNumerow;
    public SharedPreferences.Editor edytorNumerow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Assign variable
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS},PackageManager.PERMISSION_GRANTED);

        editTextMessage = findViewById(R.id.editText);
        editTextNumber = findViewById(R.id.editTextNumber);
        //Initialize usedLocationProvider
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        // SHARED PREFerences
        bazaNumerow = getSharedPreferences("gromaniecki.example.sms_ratunek", Context.MODE_PRIVATE);
        edytorNumerow = bazaNumerow.edit();

    }
    public void sendSMS(View view){

        //String message = editTextMessage.getText().toString();
        //String number = editTextNumber.getText().toString();
        String number = bazaNumerow.getString("numerkontaktowy1","");
        String message = bazaNumerow.getString("message", "");

        SmsManager mySmsManager = SmsManager.getDefault();
        mySmsManager.sendTextMessage(number, null, message,null,null);

    }

    public void openMain_Menu (View view){

        Intent intent = new Intent (this, Main_Menu.class);
        startActivity(intent);
    }


    public void zapisz(View view) {

            String message = editTextNumber.getText().toString();

            edytorNumerow.putString("numerkontaktowy1", message);
            edytorNumerow.commit();

    }
}