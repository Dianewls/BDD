package com.example.bdd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

public class FragmentPlanete extends DialogFragment {

    private EditText editnom,edittaille;
    private TextView textnom,texttaille;
    private Button ok;

    public static FragmentPlanete newInstance(String title) {
        FragmentPlanete frag = new FragmentPlanete();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.planete_form, container, false);
        ok = view.findViewById(R.id.ok);

        textnom = view.findViewById(R.id.nom);
        texttaille = view.findViewById(R.id.taille);

        editnom= view.findViewById(R.id.editnom);
        edittaille= view.findViewById(R.id.edittaille);


        return view;
    }

}
