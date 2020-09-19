package abdi.barbershop.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class BarberActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barber);


    }

    public void bookAppointment(View view) {

        startActivity(new Intent(BarberActivity.this,BarberBookAppointmentActivity.class));
        finish();
    }
}