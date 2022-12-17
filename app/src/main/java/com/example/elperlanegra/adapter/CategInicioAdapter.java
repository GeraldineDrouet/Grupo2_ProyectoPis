package com.example.elperlanegra.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.elperlanegra.R;
import com.example.elperlanegra.modelos.ModeloCategInicio;

import java.util.List;

public class CategInicioAdapter extends RecyclerView.Adapter<CategInicioAdapter.ViewHolder>{

    Context context;
    List<ModeloCategInicio> modeloCategInicioList;

    public CategInicioAdapter(Context context, List<ModeloCategInicio> modeloCategInicioList) {
        this.context = context;
        this.modeloCategInicioList = modeloCategInicioList;
    }

    @NonNull
    @Override
    public CategInicioAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.categoria_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategInicioAdapter.ViewHolder holder, int position) {
        ModeloCategInicio modeloCategoriasInicio = modeloCategInicioList.get(position);
        Glide.with(context).load(modeloCategoriasInicio.getImg_url()).into(holder.catImg);
        holder.nombre.setText(modeloCategoriasInicio.getNombre());
    }

    @Override
    public int getItemCount() {
        return modeloCategInicioList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView catImg;
        TextView nombre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            catImg = itemView.findViewById(R.id.home_cat_img);
            nombre = itemView.findViewById(R.id.cat_home_name);
        }
    }
}
