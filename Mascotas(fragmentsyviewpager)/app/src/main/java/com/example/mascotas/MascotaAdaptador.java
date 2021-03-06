package com.example.mascotas;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {


    //Array List con objetos tipo Mascota (Método constructor de la clase Mascota)
    ArrayList<Mascota> mascotas;

     //-------------------------------------------------------------------------------------------------------------------------


    //Metodo constructor de MascotaAdaptador, construye la lista de mascotas que pasara a lista de mascotas global

    Activity activity;

    public MascotaAdaptador (ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity  = activity;
        mascotasFavoritas = new ArrayList<Mascota>();
    }

    ArrayList<Mascota> mascotasFavoritas;

    //-----------------------------------------------------------------------------------------------------------------
    //IMPLEMENTACION DE METODOS


    //METODO 1 DE 3
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Genera un "inflador" para darle la vida a el layout cardview_contacto, asociarlo al RecycleView
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }


    //METODO 2 DE 3
    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder MascotaViewholder, final int position) {

        //Pasa lista de contactos a cada elemento dentro del RecycleViewholder
        //Asocia cada elemento de la lista con cada view


        final Mascota mascota = mascotas.get(position);
        MascotaViewholder.ivfotoPerro.setImageResource(mascota.getFotoPerro());
        MascotaViewholder.tvnombreMascota.setText(mascota.getNombreMascota());
        MascotaViewholder.tvnumeroLikes.setText(String.valueOf(mascota.getLikesPerro()));

        MascotaViewholder.ibPataGris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mascota.setLikesPerro(mascota.getLikesPerro() + 1);
                MascotaViewholder.tvnumeroLikes.setText(String.valueOf(mascota.getLikesPerro()));

                /*
                ArrayList<Mascota> mascotasFavoritas;
                mascotasFavoritas = new ArrayList<Mascota>();

                 */

                mascotasFavoritas.add(new Mascota(mascota.getNombreMascota(), mascota.getFotoPerro(),mascota.getLikesPerro()));

                /*

                Intent intent = new Intent(activity, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Mascotas",mascotasFavoritas);
                intent.putExtras(bundle);

                 */

            }
        });


    }

    //METODO 3 DE 3
    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    //PRIMERA CLASE ANIDADA EN CLASE MascotaAdaptador

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        //CREACION DE OBJETOS
        private ImageView ivfotoPerro;
        private ImageButton ibPataGris;
        private TextView tvnombreMascota;
        private TextView tvnumeroLikes;
        private ImageButton ibPataDorada;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            //ASIGNACION DE OBJETOS CREADOS CON LOS VIEWS DEL LAYOUT cardview_mascota
            ivfotoPerro     = (ImageView) itemView.findViewById(R.id.ivfotoPerro);
            ibPataGris      = (ImageButton) itemView.findViewById(R.id.ibPataGris);
            tvnombreMascota = (TextView) itemView.findViewById(R.id.tvnombreMascota);
            tvnumeroLikes   = (TextView) itemView.findViewById(R.id.tvnumeroLikes);
            ibPataDorada    = (ImageButton) itemView.findViewById(R.id.ibPataDorada);
        }
    }



}
