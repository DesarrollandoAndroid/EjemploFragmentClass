package desarrollandoandroid.ejemplofragmentclass;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Creado por Pablo Bascuñana Saiz el 6/12/14.
 */
public class DetalleFragment extends android.support.v4.app.Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_detalle, container, false);
        return mView;
    }

    public void mostrarTextoDetalle (String texto, String informacion) {
        TextView mTextView = (TextView) getView().findViewById(R.id.textViewTitulo);
        mTextView.setText(texto);
        TextView mTextViewDetalle = (TextView) getView().findViewById(R.id.textViewInformacion);
        mTextViewDetalle.setText(informacion);
    }
}
