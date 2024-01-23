package edu.umbc.coffeeart;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<CoffeeItem> mData;

    // Constructors
    public RecyclerViewAdapter(Context mContext, List<CoffeeItem> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.cardview_coffee, parent, false);

        return new MyViewHolder(view);
    }

    // Bind data to view holder (final int position
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.creator_art_id.setText(mData.get(position).getName());
        holder.coffee_art_img.setImageResource(mData.get(position).getArt());

        // Set click listener for the card view
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the adapter position of the clicked item
                int clickedPosition = holder.getAdapterPosition();

                // Check if the clicked position is valid
                if (clickedPosition != RecyclerView.NO_POSITION) {
                    // Create an intent to start the Coffee activity
                    Intent intent = new Intent(mContext, Coffee.class);

                    // Pass data to the Coffee activity using the adapter position
                    intent.putExtra("Creator Name", mData.get(clickedPosition).getName());
                    intent.putExtra("Coffee Art", mData.get(clickedPosition).getArt());

                    // Start the Coffee activity
                    mContext.startActivity(intent);
                }
            }
        });
    }

    // Get item count
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // View holder class
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView creator_art_id;
        ImageView coffee_art_img;
        CardView cardView;

        // Constructor
        public MyViewHolder(View itemView) {
            super(itemView);

            creator_art_id = itemView.findViewById(R.id.creator_icon_id);
            coffee_art_img = itemView.findViewById(R.id.coffee_icon_id);
            cardView = itemView.findViewById(R.id.cardview_id);
        }
    }
}
