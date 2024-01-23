//Name: Ali Akcin
//Description: Application displays customers coffee art. User can click on the given row-
// to display a full-size image representation of the icon.
//Course: IS413 GUI
package edu.umbc.coffeeart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    List<CoffeeItem> coffeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        coffeeList = new ArrayList<>();
        coffeeList.add(new CoffeeItem("Anthony Otto", R.drawable.coffee1));
        coffeeList.add(new CoffeeItem("Regina Scott", R.drawable.coffee2));
        coffeeList.add(new CoffeeItem("Hazel Aguilar", R.drawable.coffee3));
        coffeeList.add(new CoffeeItem("Tracey Ortiz", R.drawable.coffee4));
        coffeeList.add(new CoffeeItem("Gerard Mik", R.drawable.coffee5));
        coffeeList.add(new CoffeeItem("Jeremy Mendez", R.drawable.coffee6));
        coffeeList.add(new CoffeeItem("Anthony Otto", R.drawable.coffee1));
        coffeeList.add(new CoffeeItem("Regina Scott", R.drawable.coffee2));
        coffeeList.add(new CoffeeItem("Hazel Aguilar", R.drawable.coffee3));
        coffeeList.add(new CoffeeItem("Tracey Ortiz", R.drawable.coffee4));
        coffeeList.add(new CoffeeItem("Gerard Mik", R.drawable.coffee5));
        coffeeList.add(new CoffeeItem("Jeremy Mendez", R.drawable.coffee6));
        coffeeList.add(new CoffeeItem("Anthony Otto", R.drawable.coffee1));
        coffeeList.add(new CoffeeItem("Regina Scott", R.drawable.coffee2));
        coffeeList.add(new CoffeeItem("Hazel Aguilar", R.drawable.coffee3));


        RecyclerView myRecycler = findViewById(R.id.recycleview_id);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, coffeeList);
        myRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        myRecycler.setAdapter(adapter);

    }
}