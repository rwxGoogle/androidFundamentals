package com.example.androidfundamentals.w6examples.example1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.androidfundamentals.R;

import static com.example.androidfundamentals.w6examples.example1.Example1Activity.LABEL;
import static com.example.androidfundamentals.w6examples.example1.Example1Activity.LABEL_INT;

/**
 * Created by roxanan on 17,April,2019
 */
public class HelloFragment extends Fragment {

    private String label;
    private int labelInt;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            this.label = getArguments().getString(LABEL, "Buuu!");
            this.labelInt = getArguments().getInt(LABEL_INT, 0);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hello, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((TextView) view.findViewById(R.id.hello_label)).setText(label + labelInt);
    }
}
