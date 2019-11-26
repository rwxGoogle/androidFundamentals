package com.example.androidfundamentals.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidfundamentals.R;

import java.util.List;

/**
 * Created by roxanan on 19,November,2019
 */
public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarsViewHolder> {
    private final List<String> cars;

    public CarsAdapter(List<String> cars) {
        this.cars = cars;
    }

    @NonNull
    @Override
    public CarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View recyclerRow = layoutInflater.inflate(R.layout.item_car_of_the_day, parent, false);
        return new CarsViewHolder(recyclerRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CarsViewHolder holder, final int position) {
        String carName = cars.get(position);
        holder.carName.setText(carName);

        holder.updateCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(CarsAdapter.class.getSimpleName(), "item click position: " + position);

                Toast.makeText(view.getContext(),
                        "item click position: " + position,
                        Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    static class CarsViewHolder extends RecyclerView.ViewHolder {
        final TextView carName;
        final ImageView carImage;
        final Button updateCar;


        public CarsViewHolder(@NonNull View itemView) {
            super(itemView);

            carName = itemView.findViewById(R.id.car);
            carImage = itemView.findViewById(R.id.car_image);
            updateCar = itemView.findViewById(R.id.update_car);
        }
    }
}
