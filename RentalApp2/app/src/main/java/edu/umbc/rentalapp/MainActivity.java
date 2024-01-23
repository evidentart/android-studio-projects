//Name: Ali Akcin
//Description: Rental App requests number of days to rent a tool, and displays the total cost.
//             User can only select 1 tool at a time and maximum 7 days rental length.
package edu.umbc.rentalapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    //Stage Data
    final double washerPrice = 59.98;
    final double tillerPrice = 30.98;
    final double leafPrice = 44.99;
    final double augerPrice = 45.99;

    //Class Variables
    private EditText rentalDaysText;
    private Button computeBtn;
    private TextView totalCostView;
    private RadioButton pressureB, tillerB, leafB, augerB;
    private RadioGroup radioGroup;
    DecimalFormat fmt;
    private final NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fetch variables by ids
        radioGroup = findViewById(R.id.rbGroup);
        pressureB = findViewById(R.id.rbWasher);
        tillerB = findViewById(R.id.rbTiller);
        leafB = findViewById(R.id.rbLeaf);
        augerB = findViewById(R.id.rbAuger);
        rentalDaysText = findViewById(R.id.etInputDays);
        totalCostView = findViewById(R.id.tvResults);
        computeBtn = findViewById(R.id.btnCompute);

        //creating on click listener to validate input and display the output
        computeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rentalDays = Integer.parseInt(rentalDaysText.getText().toString());
                double rentalCost = 0;

                //formatting output number nearest penny
                DecimalFormat df = new DecimalFormat("#.##");
                if (pressureB.isChecked() && rentalDays <= 7) {
                    rentalCost = washerPrice * rentalDays;
                    String result1 = "Total cost: $" + df.format(rentalCost) + "\nNumber of days: " + rentalDays;
                    totalCostView.setText(result1);

                } else if (tillerB.isChecked() && rentalDays <= 7) {
                    rentalCost = tillerPrice * rentalDays;
                    String result2 = "Total cost: $" + df.format(rentalCost) + "\nNumber of days: " + rentalDays;
                    totalCostView.setText(result2);

                } else if (leafB.isChecked() && rentalDays <= 7) {
                    rentalCost = leafPrice * rentalDays;
                    String result3 = "Total cost: $" + df.format(rentalCost) + "\nNumber of days: " + rentalDays;
                    totalCostView.setText(result3);

                } else if (augerB.isChecked() && rentalDays <= 7) {
                    rentalCost = augerPrice * rentalDays;
                    String result4 = "Total cost: $" + df.format(rentalCost) + "\nNumber of days: " + rentalDays;
                    totalCostView.setText(result4);

                } else if (rentalDays > 7){
                    String result5 = "You can only rent maximum 7 days";
                    totalCostView.setText(result5);
                }
            }
        });

    }
}