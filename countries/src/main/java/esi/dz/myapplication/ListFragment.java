package esi.dz.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by lenovo on 21/03/2015.
 */
// La classe qui représente un fragment est une sous classe de la classe Fragement

public class ListFragment extends Fragment {


    ListView listView;

/* La spécification du layout du fragment se fait au niveau de la méthode OnCreateView
 OnCreateView ext exécutée quand le système dessine les élements de l'interface
 La méthode onCreateView doit retourner un élément de type View
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /*inflater.inflate retourne un élément de type view, elle convertit un layout xml en
        un objet view utilisable dans le code source
        Elle a trois paramètres :
        1. le premier est le layout
        2. le deuxième est le parent( container) de ce layout
        3. un boolean pour spécifier au système de créer ou non un parent. Toujours le mettre à false
          pour que le système utilise le parent spécifié dans le layout sans créer un autre
         */
        return inflater.inflate(R.layout.country_list, container, false);
    }
/* OnStart: le Fragment a chargé l'interface et l'activité est créée
*/
    @Override
    public void onStart() {
        super.onStart();

        // remplir la liste à partir du tableau des pays dans le fichier strings.xml
        ArrayAdapter arrayAdapter =
                new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,
                        getResources().getStringArray(R.array.countries));

        listView = (ListView) getActivity().findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);
        // appeler l'évènement onClick de la liste
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // On vérifie la configuration
                if(getResources().getConfiguration().smallestScreenWidthDp>=600) {
                    // Tablette
                    // on remplace le framelayout par le fragment detail
                    DetailFragment detailFragment = new DetailFragment();
                    Bundle bundle = new Bundle();
                    // On sauvegarde la position du clique dans un object bundle
                    bundle.putInt("position",position);
                    detailFragment.setArguments(bundle);
                    // On lance le FragmementManger pour remplacer le frameLyout par le fragment
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    // On remplace le frameLyout qui a un id "R.id.fragment" par le fragment
                    fragmentTransaction.replace(R.id.fragment2,detailFragment).commit();


                }
                else {
                    // Smartphone
                    // Dans ce cas on lance l'activié détail
                    // Le Intent dz.esi.intent.details est spécifié dans le manifest
                    Intent intent = new Intent("dz.esi.intent.details");
                    // On envoie à l'activité détail la position du clique
                    intent.putExtra("position",position);
                    startActivity(intent);

                }
            }
        });
    }
    }

