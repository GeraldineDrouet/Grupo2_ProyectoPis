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
import com.example.elperlanegra.modelos.ModeloProducto;

import java.util.List;

public class ProductosInicioAdapter extends RecyclerView.Adapter<ProductosInicioAdapter.ViewHolder> {

    Context context;
    List<ModeloProducto> modeloProductoList;

    public ProductosInicioAdapter(Context context, List<ModeloProducto> modeloProductoList) {
        this.context = context;
        this.modeloProductoList = modeloProductoList;
    }

    @NonNull
    @Override
    public ProductosInicioAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductosInicioAdapter.ViewHolder holder, int position) {

        final ModeloProducto modeloProducto = modeloProductoList.get(position);
        Glide.with(context).load(modeloProducto.getImg_url()).into(holder.img_prod);
        holder.nombre.setText(modeloProducto.getNombreProd());
        holder.rating.setText(modeloProducto.getRating());
        holder.precio.setText(modeloProducto.getPrecio());
    }

    @Override
    public int getItemCount() {
        return modeloProductoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img_prod;
        TextView nombre, rating, precio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_prod = itemView.findViewById(R.id.img_product_inicio);
            nombre = itemView.findViewById(R.id.nombreProducto);
            rating = itemView.findViewById(R.id.rating);
            precio = itemView.findViewById(R.id.precio);
        }
    }
}
