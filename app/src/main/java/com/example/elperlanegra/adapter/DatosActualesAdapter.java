package com.example.elperlanegra.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elperlanegra.R;
import com.example.elperlanegra.modelos.ModeloDatosActualesUser;

import java.util.List;

public class DatosActualesAdapter extends RecyclerView.Adapter<DatosActualesAdapter.ViewHolder> {

    Context context;
    List<ModeloDatosActualesUser> modeloDatosActualesUserList;

    public DatosActualesAdapter(Context context, List<ModeloDatosActualesUser> modeloDatosActualesUserList) {
        this.context = context;
        this.modeloDatosActualesUserList = modeloDatosActualesUserList;
    }

    @NonNull
    @Override
    public DatosActualesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.datosactuales_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DatosActualesAdapter.ViewHolder holder, int position) {
        holder.nombre.setText(modeloDatosActualesUserList.get(position).getNombre());
        holder.apellido.setText(modeloDatosActualesUserList.get(position).getApellido());
        holder.direccion.setText(modeloDatosActualesUserList.get(position).getDireccion());
        holder.correo.setText(modeloDatosActualesUserList.get(position).getCorreo());
        holder.telefono.setText(modeloDatosActualesUserList.get(position).getTelefono());
    }

    @Override
    public int getItemCount() {
        return modeloDatosActualesUserList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre,apellido,direccion,telefono,correo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.datos_nombre_rec);
            apellido = itemView.findViewById(R.id.datos_apellidoo_rec);
            direccion = itemView.findViewById(R.id.datos_direccion_rec);
            correo = itemView.findViewById(R.id.datos_correo_rec);
            telefono = itemView.findViewById(R.id.datos_telefono_rec);
        }
    }
}
