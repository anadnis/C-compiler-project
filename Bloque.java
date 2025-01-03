import java.util.Vector;

public class Bloque extends Instruccion{
    private Vector<Intruccion> instrucciones;

    public Bloque (int linea){
        super(linea);
        instrucciones = new Vector<>();
    }

    public void add(Instruccion instruccion){
        instrucciones.add(instruccion);
    }

    @Override
    public Objeto generarCodigo() throws Exception{ //coger de carlos
        for(Instruccion)
    }

}