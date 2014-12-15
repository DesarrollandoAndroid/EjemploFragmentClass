package desarrollandoandroid.ejemplofragmentclass;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Creado por Pablo Bascuñana Saiz el 6/12/14.
 */
public class DetalleActivity extends FragmentActivity {

    public static final String EXTRA_TEXTO = "desarrollandoandroid.ejemplofragmentclass.EXTRA_TEXTO";
    public static final String EXTRA_INFO = "desarrollandoandroid.ejemplofragmentclass.EXTRA_INFO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        // Cargamos el Fragment del layout activity_detalle
        DetalleFragment mDetalle = (DetalleFragment) getSupportFragmentManager().findFragmentById(R.id.detalleFragment);
        // Recuperamos el parámetro pasado desde la actividad anterior (MainActivity) y lo muestra en el fragment detalle
        mDetalle.mostrarTextoDetalle(getIntent().getStringExtra(EXTRA_TEXTO), getIntent().getStringExtra(EXTRA_INFO));
    }
}
