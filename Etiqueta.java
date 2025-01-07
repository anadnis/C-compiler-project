import java.text.ParseException;

public class Etiqueta extends Objeto{
    private boolean usada;

    public Etiqueta(String nombre, int bloque) {
        super(nombre, bloque, false);
        usada = false;
    }

    @Override
    public String getIDC(){
        return getNombre();
    }

    @Override
    public Objeto generarCodigoMetodo(String metodo, Objeto[] params, int linea) throws Exception {
        switch(metodo) {
            case Metodos.PONERETIQ:
                if(usada) {
                    throw new ParseException("Etiqueta <" + getNombre() + "> ya usada", linea);
                }
                PLXC.out.println(getNombre() + ": ");
                break;
            case Metodos.SALTARETIQ:
                PLXC.out.println("goto " + getNombre() + ";");
                break;
            default:
                throw new UnsupportedOperationException(metodo + " no es un método válido para etiquetas");
        }

        return null;
    }





}






