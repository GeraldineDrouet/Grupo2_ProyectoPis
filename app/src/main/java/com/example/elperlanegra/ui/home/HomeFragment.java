package com.example.elperlanegra.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elperlanegra.R;
import com.example.elperlanegra.adapter.CategInicioAdapter;
import com.example.elperlanegra.modelos.ModeloCategInicio;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    RecyclerView inicioCatRec;
    FirebaseFirestore db;

    //Categorias items
    List<ModeloCategInicio> modeloCategInicioList;
    CategInicioAdapter categInicioAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        db = FirebaseFirestore.getInstance();
        inicioCatRec = root.findViewById(R.id.rec_categInicio);

        //CATEGORÍAS INICIO
        inicioCatRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        modeloCategInicioList = new ArrayList<>();
        categInicioAdapter = new CategInicioAdapter(getActivity(),modeloCategInicioList);
        inicioCatRec.setAdapter(categInicioAdapter);

        db.collection("Categorias")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                ModeloCategInicio modeloCategInicio = document.toObject(ModeloCategInicio.class);
                                modeloCategInicioList.add(modeloCategInicio);
                                categInicioAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), "Error: "+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        return root;
    }


}