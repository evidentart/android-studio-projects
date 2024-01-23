//Name: Ali Akcin
//Description: Program displays the name of the hotel, an image and a button.
//             When user clicks the button, second activity displays the details.
//Course: IS413 GUI
package edu.umbc.hotelapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //variable declaration for button
    Button btnMessageUpdate;

    //onCreate method runs super for the constructor inheritance & set the content for main activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create objects for button to initialize  the button
        Button btnMessageUpdate = findViewById(R.id.button);

        //create event handler calls btnMessageUpdate
        btnMessageUpdate.setOnClickListener(v -> {
            openActivity2();
        });
    }

    //method for opening second activity
    public void openActivity2() {

        //start activity 2
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

}