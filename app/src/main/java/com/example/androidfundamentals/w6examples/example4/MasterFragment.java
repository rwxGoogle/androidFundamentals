package com.example.androidfundamentals.w6examples.example4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.androidfundamentals.R;

/**
 * Created by roxanan on 17,April,2019
 */
public class MasterFragment extends Fragment {
    private Listener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_master, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.item1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.showHello4Fragment();
            }
        });

        view.findViewById(R.id.item2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.showAnother4Fragment();
            }
        });
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}
