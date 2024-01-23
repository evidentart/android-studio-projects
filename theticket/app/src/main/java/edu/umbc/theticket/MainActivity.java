//Name: Ali Akcin
//Description: Concert ticket program calculates ticket cost based on the given bands
package edu.umbc.theticket;
import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    //Stage Data
    final double costPerTicket = 60.00;
    final double getCostPerTicket2 = 128.72;
    final double costPerTicket3 = 104.27;

    //hastset<key, value> == <id, BandObject(Band name, band image, ticket price, ...)>

    //class variables
    private int numberOfTickets;
    private double totalCost;
    private String groupChoice;
    private double ticketPrice;

    private DecimalFormat fmt;

    private NumberFormat numberFormat = NumberFormat.getCurrencyInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText tickets = findViewById(R.id.etInputTickets);
        Spinner group = findViewById(R.id.spinnerbands);
        TextView results = findViewById(R.id.tvResults);
        Button btnCost = findViewById(R.id.btnCostSubmit);

        //get the bands from string.xml
        Resources res = getResources();
        String[] bands = res.getStringArray(R.array.bandStringArray);
        ArrayAdapter<Object> arrayAdapter = new ArrayAdapter<>(this, R.layout.spinner_list, bands);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_list);
        group.setAdapter(arrayAdapter);

        btnCost.setOnClickListener(e -> {
            numberOfTickets = Integer.parseInt(String.valueOf(tickets.getText()));
            groupChoice = group.getSelectedItem().toString();
             //totalCost = numberOfTickets * costPerTicket;
             //results.setText(String.valueOf(totalCost));
             ticketPrice = getTicketCost(groupChoice);
             totalCost = ticketPrice * numberOfTickets;
             //alternative way to display output
             fmt = new DecimalFormat("###,###.00");
             //format output
             String resultText = " Total cost for " + groupChoice + " is " + numberFormat.format(totalCost);
             results.setText(resultText);
        });

    }

    //method for calculating ticket cost by storing array values and use of iterator
    private double getTicketCost(String band){
        double price = 0.0;
        Resources res = getResources();
        String[] bands = res.getStringArray(R.array.bandStringArray);
        Iterator<String> iterator = Arrays.asList(bands).iterator();
        while(iterator.hasNext()){
            if ("Pink Floyd".equals(band)){
                price = costPerTicket;
                break;
            }else if("The Beatles".equals(band)){
                price = getCostPerTicket2;
                break;
            }else if("Red Hot Chili Peppers".equals(band)){
                price = costPerTicket3;
                break;
            }
        }
        return price;
    }






}