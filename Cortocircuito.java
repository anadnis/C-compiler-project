//esto es para manejar el cortocircuito en expresiones lógicas
//si la primera expresión es falsa, no se evalua la segunda, nos sirve para añadir muchas cosas como ?
import java.util.Vector;

public class Cortocircuito extends Instruccion {

    private Instruccion e1, e2;
    private String metodo;

    public Cortocircuito(int linea, Instruccion e1, String metodo, Instruccion param[]) {
        super(linea);
        this.e1 = e1;
        this.metodo = metodo;
        this.e2 = e2;

    }
    
    @Override

    public Objeto generarCodigo() throws Exception{
        Objeto o1 = e1.generarCodigo();
        Etiqueta destino = new Etiqueta(Objeto.newEtiq(), o1.getBloque()); //
        Objeto r = o1.generarCodigoMetodo(metodo, new Objeto[]{destino});
        Objeto o2 = e2.generarCodigo();
        r.generarCodigoMetodo(Metodos.CONSTRUCTORCOPIA, new Objeto[]{o2},)//
        destino.generarCodigoMetodo(Metodos.PONERETIQ, null, getLinea());
        return r; 
    }
}