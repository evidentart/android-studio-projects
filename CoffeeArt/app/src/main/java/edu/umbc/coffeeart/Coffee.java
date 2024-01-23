package edu.umbc.coffeeart;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;

public class Coffee extends AppCompatActivity {

    private TextView tvTitle;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);


        tvTitle = findViewById(R.id.creator_txt_id);
        img = findViewById(R.id.coffee_img_id);


        Intent intent = getIntent();
        String title = intent.getExtras().getString("Creator Name");
        int thumbnail = intent.getExtras().getInt("Coffee Art");


        tvTitle.setText(title);
        img.setImageResource(thumbnail);
    }
}