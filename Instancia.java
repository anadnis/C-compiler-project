import java.util.Vector;

public abstract class Instancia extends Objeto{
    private final Tipo tipo;

    public Instancia(String nombre, int bloque, boolean mutable, Tipo tipo){
        super(nombre, bloque, mutable);
        this.tipo=tipo;
    }

    public abstract class Instancia extends Objeto{
        private final Tipo tipo;
    }
    
    //no se si Tipo o tipo aqui
    public Tipo getTipo(){
    return tipo;
    }
}