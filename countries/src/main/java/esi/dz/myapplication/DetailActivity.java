package esi.dz.myapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class DetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Sur un smartphone on lance l'acivité détails
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        // on crée un bundle est on sauvegarde la valeur du intent dans position
        bundle.putInt("position",getIntent().getIntExtra("position",0));
        detailFragment.setArguments(bundle);
        // on lance le fragment détail et on passe la main à ce fragment pour l'affichage
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment2,detailFragment).commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
