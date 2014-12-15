package desarrollandoandroid.ejemplofragmentclass;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Creado por Pablo Bascuñana Saiz el 6/12/14.
 */
public class MainActivity extends FragmentActivity implements ListaFragment.ContenidoListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListaFragment mListaFragment = (ListaFragment) getSupportFragmentManager().findFragmentById(R.id.listaFragment);
        mListaFragment.setContenidoListener(this);
    }

    public void onElementoSeleccionado (Contenido texto, Contenido informacion) {

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                ((DetalleFragment) getSupportFragmentManager().findFragmentById(R.id.detalleFragment))
                        .mostrarTextoDetalle(texto.getTexto(), informacion.getInformacion());
        }
        else
        {
            Intent mIntent = new Intent(MainActivity.this, DetalleActivity.class);
            mIntent.putExtra(DetalleActivity.EXTRA_TEXTO, texto.getTexto());
            mIntent.putExtra(DetalleActivity.EXTRA_INFO, texto.getInformacion());
            startActivity(mIntent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
