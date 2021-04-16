package com.example.bdd;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MonRecyclerViewAdapter extends RecyclerView.Adapter<MonRecyclerViewAdapter.ConteneurDeDonnee>{
    private List<Planete> planetes;
    private static DetecteurDeClicSurRecycler detecteurDeClicSurRecycler;



    public MonRecyclerViewAdapter(List<Planete> planetes) {
        this.planetes = planetes;
    }



    @Override
    public ConteneurDeDonnee onCreateViewHolder(ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new ConteneurDeDonnee(view);
    }


    @Override
    public void onBindViewHolder(ConteneurDeDonnee conteneur, int position) {
        conteneur.tv_principal.setText(planetes.get(position).getNom());
        conteneur.tv_auxiliaire.setText(planetes.get(position).getTaille()+"");
        //conteneur.img.setImageResource(planetes.get(position).getImg());
    }


    @Override
    public int getItemCount() {
        return planetes.size();

    }


    public static class ConteneurDeDonnee extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_principal;
        TextView tv_auxiliaire;
        ImageView img;


        public ConteneurDeDonnee(View itemView) {
            super(itemView);
            tv_principal = (TextView) itemView.findViewById(R.id.tv_principal);
            tv_auxiliaire = (TextView) itemView.findViewById(R.id.tv_auxiliaire);
            itemView.setOnClickListener(this);
            img= itemView.findViewById(R.id.img);


        }


        @Override
        public void onClick(View v) {
            ((CardView)v).setCardBackgroundColor(Color.rgb(255,0,0));
            detecteurDeClicSurRecycler.clicSurRecyclerItem(getAdapterPosition(), v);
            ((CardView)v).setCardBackgroundColor(Color.rgb(255, 0, 0));

        }
    }
    public void setDetecteurDeClicSurRecycler(DetecteurDeClicSurRecycler detecteurDeClicSurRecycler) {
        this.detecteurDeClicSurRecycler = detecteurDeClicSurRecycler;
    }


}
