//Name: Ali Akcin
//Description: Tip split application intended to split the bill when out with group of people.
//Course: IS413 GUI
package edu.umbc.splitthebill;
import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    final double num1 = 0.22;
    final double num2 = 0.18;
    final double num3 = 0.14;
    private int numPeople;
    private double billTotal;
    private double billResult;
    private String serviceQuality;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText tBill = findViewById(R.id.etInput1);
        EditText numPerson = findViewById(R.id.etInput2);
        Spinner service = findViewById(R.id.spinnerService);
        TextView totalAmount = findViewById(R.id.tvResults);
        Button calc = findViewById(R.id.CalcButton);

        calc.setOnClickListener(e -> {
            billResult = Integer.parseInt(String.valueOf(tBill.getText()));
            billResult = billResult(serviceQuality);
            billTotal = billResult / numPeople;
            numPeople = Integer.parseInt(String.valueOf(numPerson.getText()));
            serviceQuality = service.getSelectedItem().toString();
            String sValue = (String) String.format("%.2f", billTotal);
            billTotal = Double.parseDouble(sValue);
            totalAmount.setText(String.valueOf(billTotal));
        });
    }
    private double billResult(String choice) {
        double price = 0.0;
        Resources res = getResources();
        String[] myArray = res.getStringArray(R.array.qualityOfServiceArray);
        Iterator<String> iterator = Arrays.asList(myArray).iterator();
        while(iterator.hasNext()){
            if ("Excellent Service".equals(choice)){
                billResult = (billResult * num1) + billResult;
                price = billResult;
                break;
            }else if("Average Service".equals(choice)){
                billResult = (billResult * num2) + billResult;
                price = billResult;
                break;
            }else if("Poor Service".equals(choice)){
                billResult = (billResult * num3) + billResult;
                price = billResult;
                break;
            }
        }
        return price;
    }
}