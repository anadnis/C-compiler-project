import java.text.ParseException;

public class Etiqueta extends Objeto{
    private boolean puesta;

    public Etiqueta (String nombre , int bloque){
        super(nombre,bloque, false);
        puesta = false;
    }

    @Override
    public String getIDC(){
        return getNombre();
    }
        


    @Override
    public Objeto generarCodigoMetodo ;//foto del metodo generarcodigoMetodo jueves 12 de diciembre





}






