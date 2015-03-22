package esi.dz.myapplication;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lenovo on 21/03/2015.
 */
// La classe qui représente un fragment est une sous classe de la classe Fragement

public class DetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        /*inflater.inflate retourne un élément de type view, elle convertit un layout xml en
        un objet view utilisable dans le code source
        Elle a trois paramètres :
        1. le premier est le layout
        2. le deuxième est le parent( container) de ce layout
        3. un boolean pour spécifier au système de créer ou non un parent. Toujours le mettre à false
          pour que le système utilise le parent spécifier dans le layout sans créer un autre
         */

        return inflater.inflate(R.layout.country_detail, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle= this.getArguments();
        // On récupère le bundle sauvegardé
        if (bundle!=null) {
            // On récupère la position
            int position = bundle.getInt("position");
            ImageView imageView = (ImageView) getActivity().findViewById(R.id.imageView);
            TextView textView = (TextView) getActivity().findViewById(R.id.textView);
            TextView textView2 = (TextView) getActivity().findViewById(R.id.textView2);
            TextView textView3 = (TextView) getActivity().findViewById(R.id.textView3);
            TextView textView4 = (TextView) getActivity().findViewById(R.id.textView4);
            Resources rs = getResources();
            String[] capitals = rs.getStringArray(R.array.capitals);
            String[] population = rs.getStringArray(R.array.population);
            String[] countries = getResources().getStringArray(R.array.countries);
            String country = countries[position].toLowerCase();
            // On affiche les détails
            // On récupère l'dentifiant de l'image
            // chaque image a le nom "ic_nom du pays"
            int i = rs.getIdentifier("ic_" + country, "drawable", "esi.dz.myapplication");
            imageView.setImageResource(i);
            // On récupère la capitale du pays et la population
            textView2.setText(capitals[position]);
            textView4.setText(population[position]);
        }
    }
}
