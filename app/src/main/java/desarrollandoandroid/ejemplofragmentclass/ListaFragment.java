package desarrollandoandroid.ejemplofragmentclass;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Creado por Pablo Bascuñana Saiz el 6/12/14.
 */
public class ListaFragment extends Fragment {

    ArrayList<Contenido> mItems;
    ListView mListView;
    Contenido mContenido;

    private ContenidoListener mListener; // Variable para nuestro evento personalizado.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mListView = (ListView) getView().findViewById(R.id.listView);
        mItems = new ArrayList<Contenido>();
        // Introducimos los elementos a mContenido para posteriormente añadirlos a mItems con el método add().
        mContenido = new Contenido (getResources().getString(R.string.ele1), getResources().getString(R.string.info1));
        mItems.add(mContenido);
        mContenido = new Contenido (getResources().getString(R.string.ele2), getResources().getString(R.string.info2));
        mItems.add(mContenido);
        mContenido = new Contenido (getResources().getString(R.string.ele3), getResources().getString(R.string.info3));
        mItems.add(mContenido);
        mContenido = new Contenido (getResources().getString(R.string.ele4), getResources().getString(R.string.info4));
        mItems.add(mContenido);
        mContenido = new Contenido (getResources().getString(R.string.ele5), getResources().getString(R.string.info5));
        mItems.add(mContenido);
        mContenido = new Contenido (getResources().getString(R.string.ele6), getResources().getString(R.string.info6));
        mItems.add(mContenido);
        mContenido = new Contenido (getResources().getString(R.string.ele7), getResources().getString(R.string.info7));
        mItems.add(mContenido);
        mContenido = new Contenido (getResources().getString(R.string.ele8), getResources().getString(R.string.info8));
        mItems.add(mContenido);
        mContenido = new Contenido (getResources().getString(R.string.ele9), getResources().getString(R.string.info9));
        mItems.add(mContenido);
        mContenido = new Contenido (getResources().getString(R.string.ele10), getResources().getString(R.string.info10));
        mItems.add(mContenido);

        ContenidoAdapter mAdapter = new ContenidoAdapter(this, mItems);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mListener != null) {
                    mListener.onElementoSeleccionado((Contenido) mListView.getAdapter().getItem(position),
                            (Contenido) mListView.getAdapter().getItem(position));
                }
            }
        });
    }

    private class ContenidoAdapter extends ArrayAdapter<Contenido>{

        Activity mContext;
        ArrayList<Contenido> mItems;

        public ContenidoAdapter(ListaFragment listaFragment, ArrayList<Contenido> items) {
            super(listaFragment.getActivity(), R.layout.listaelementos_contenido, items);
            this.mContext = listaFragment.getActivity();
            this.mItems = items;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View mView = convertView;
            ViewHolder mHolder;

            if (mView == null){
                LayoutInflater mInflater = mContext.getLayoutInflater();
                mView = mInflater.inflate(R.layout.listaelementos_contenido, null);

                mHolder = new ViewHolder();
                mHolder.mTexto = (TextView) mView.findViewById(R.id.textViewElementosListado);

                mView.setTag(mHolder);
            }
            else {
                mHolder = (ViewHolder) mView.getTag();
            }

            mHolder.mTexto.setText(mItems.get(position).getTexto());

            return mView;
        }
    }

    private class ViewHolder {
        TextView mTexto;
    }
    // Defino la interfaz ContenidoListener
    public interface ContenidoListener {
        void onElementoSeleccionado(Contenido texto, Contenido informacion); // Método onElementoSeleccionado
    }
    // Con el método setContenidoListener podemo asignar el evento desde fuera de esta clase.
    public void setContenidoListener (ContenidoListener listener) {
        this.mListener = listener;
    }
}
