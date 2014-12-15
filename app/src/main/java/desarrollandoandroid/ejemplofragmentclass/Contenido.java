package desarrollandoandroid.ejemplofragmentclass;

/**
 * Creado por Pablo Bascuñana Saiz el 6/12/14.
 */
public class Contenido {


    private String texto;
    private String informacion;



    public Contenido(String texto, String informacion) {
        this.texto = texto;
        this.informacion = informacion;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
}

