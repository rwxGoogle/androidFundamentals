package com.example.androidfundamentals.w6examples.example2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.androidfundamentals.R;

/**
 * Created by roxanan on 17,April,2019
 */
public class Hello2Fragment extends Fragment {

    private TextView helloLabel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hello2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.helloLabel = ((TextView) view.findViewById(R.id.hello_label));
    }

    void setLabel(String label) {
        helloLabel.setText(label);
    }
}
