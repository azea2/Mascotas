package com.example.mascotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    ArrayList<Mascota> mascotasLista;

    //Array List con objetos tipo Mascota (Método constructor de la clase Mascota)
    ArrayList<Mascota> mascotas;


    //Nombro el RecylcerView del layout activity_main
    private RecyclerView rvMascotas;
    private ImageButton star;
    private Toolbar Actionbar;



    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);



        star = v.findViewById(R.id.star);


        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MascotasFavoritas.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("Mascotas", mascotasLista);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });



        //Doy vida a la lista de contactos tipo RecycleView, ya es un objeto manipulable con java
        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        //De qué forma quiero mostrar mi RecycleView por medio de un objeto LinearLayoutManager o grid layout manager

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //Hago que el objeto rvContactos se comporte como un LinearLayout
        rvMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        iniciarAdaptador();



        // Inflate the layout for this fragment

        return v;


    }
/*
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_opciones,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

 */

    private void iniciarAdaptador() {
        //Instanciación de contactoAdaptador, crear un objeto de contactoAdaptador, pasar la lista y pueda hacer lo configurado
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        rvMascotas.setAdapter(adaptador);
        mascotasLista = (ArrayList<Mascota>) adaptador.mascotasFavoritas;

    }


    //Método para Inicializar u obtener la lista de masctotas en el ArrayLista mascotas
    public void inicializarListaMascotas () {

        //Genero Array List dentro del método
        mascotas = new ArrayList<Mascota>();

        //Agrego los valores correspondientes para cada objeto dentro del ArrayList
        mascotas.add(new Mascota("Pepe", R.mipmap.dog1, 0));
        mascotas.add(new Mascota("Lala", R.mipmap.dog2, 0));
        mascotas.add(new Mascota("Lalo", R.mipmap.dog3, 0));
        mascotas.add(new Mascota("Toby", R.mipmap.dog4, 0));
        mascotas.add(new Mascota("Luna", R.mipmap.dog5, 0));
    }


}