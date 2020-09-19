package abdi.barbershop.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class BarberBookAppointmentActivity extends AppCompatActivity {

    private EditText nameEt, phoneEt, addressEt, timeEt, servicesEt;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barber_book_appointment);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        nameEt = findViewById(R.id.nameEt);
        phoneEt = findViewById(R.id.phoneEt);
        addressEt = findViewById(R.id.addressEt);
        timeEt = findViewById(R.id.timeEt);
        servicesEt = findViewById(R.id.servicesEt);

    }

    public void bookAppointment(View view) {

        String name = nameEt.getText().toString().trim();
        String phone = phoneEt.getText().toString().trim();
        String address = addressEt.getText().toString().trim();
        String time = timeEt.getText().toString().trim();
        String service = servicesEt.getText().toString().trim();

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name", "" + name);
        hashMap.put("phone", "" + phone);
        hashMap.put("address", "" + address);
        hashMap.put("time", "" + time);
        hashMap.put("service", "" + service);

        db.collection("BarberBookAppointment")
                .add(hashMap)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(BarberBookAppointmentActivity.this, "Appointment placed successful!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(BarberBookAppointmentActivity.this, "Error " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}